package com.training.expensemanagementsystem.controller;

import com.training.expensemanagementsystem.dao.GuestDAO;
import com.training.expensemanagementsystem.model.Account;
import com.training.expensemanagementsystem.model.GuestUser;
import com.training.expensemanagementsystem.service.GuestService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("expense")
public class GuestController {

    @Autowired
    GuestService guestService;

    @Autowired
    RestTemplate restTemplate ;

    @PostMapping
    @CircuitBreaker(name = "myFirstCircuitBreaker" , fallbackMethod = "microserviceNotAvailable")
    public ResponseEntity<String> saveExpenseDetails(@RequestBody GuestUser guestUser)
    {
        //check whether this guest
        //1. Make Rest call to localhost:9090/softbank/api/accounts
        //2. Get the data
        ResponseEntity<Account> accountData =
                restTemplate.getForEntity("http://localhost:9090/softbank/api/accounts/"+guestUser.getGuestId(), Account.class);
        //3. Analyaze it and
        if(guestUser.getGuestId()<0)
        {
            throw new RuntimeException("Guest Id is invalid and cannot be negative");
        }
        if(accountData.getStatusCode() == HttpStatus.NO_CONTENT)
        {
            return new ResponseEntity<String>("You cannot have expense because you dont have account",
                    HttpStatusCode.valueOf(200));
        }
        else  if(accountData.getBody().getBalance() < guestUser.getMonthlyExpense())
        {
            return new ResponseEntity<String>("Insufficient balance. Have balance before applying expense",
                    HttpStatusCode.valueOf(200));
        }
        else {
            boolean result = guestService.saveGuest(guestUser);
            if(result)
            {
                return new ResponseEntity<String>("Expense added successfully", HttpStatusCode.valueOf(201));
            }
            else {
                return new ResponseEntity<String>("Your data incorrect", HttpStatusCode.valueOf(422));
            }
        }
    }


    public ResponseEntity<String> microserviceNotAvailable(GuestUser guestUser,Throwable t) {

        return new ResponseEntity<String>("Softbank service is currently unavailable. Please try again later.",HttpStatusCode.valueOf(200));
    }


    @Autowired
    GuestDAO   guestDAO;




    @GetMapping
    public ResponseEntity<List<GuestUser>> getExpenseDetails()
    {
        //get all from DB
        List<GuestUser> guestUsers = guestDAO.findAll();
        return new ResponseEntity<List<GuestUser>>(guestUsers, HttpStatusCode.valueOf(200));
    }

    @GetMapping("{id}")
    public ResponseEntity<GuestUser> getExpenseDetails(@PathVariable Long id){
        Optional<GuestUser> user = guestDAO.findById(id);
        if(user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateExpenseDetails(@RequestBody GuestUser user){
        Optional<GuestUser> userOptional = guestDAO.findById(user.getGuestId());
        if(userOptional.isEmpty()){
            return new ResponseEntity<>("Guest not found", HttpStatus.NOT_FOUND);
        }
        guestDAO.save(user);
        return new ResponseEntity<>("guest updated", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpenseDetails(@PathVariable Long id){
        Optional<GuestUser> guestUser = guestDAO.findById(id);
        if(guestUser.isEmpty()){
            return new ResponseEntity<>("guest not found", HttpStatus.NOT_FOUND);
        }
        guestDAO.deleteById(id);
        return new ResponseEntity<>("guest deleted", HttpStatus.OK);
    }


    // 1. Balance API
    @GetMapping("/balance/{amount}")
    public ResponseEntity<List<GuestUser>> getBalance(@PathVariable double amount) {
        List<GuestUser> guestUsers = guestDAO.findByBalanceLessThan(amount);
        return ResponseEntity.ok(guestUsers);
    }






}

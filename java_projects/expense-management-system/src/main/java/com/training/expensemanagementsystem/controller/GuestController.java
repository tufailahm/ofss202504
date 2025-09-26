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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("expense")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8000" })
public class GuestController {

    @Autowired
    GuestService guestService;

    @Autowired
    RestTemplate restTemplate ;

    @PostMapping
    @CircuitBreaker(name = "myFirstCircuitBreaker", fallbackMethod = "microserviceNotAvailable")
    public ResponseEntity<Map<String, Object>> saveExpenseDetails(@RequestBody GuestUser guestUser) {

        // Make REST call to accounts service
        ResponseEntity<Account> accountData =
                restTemplate.getForEntity("http://localhost:9090/softbank/api/accounts/" + guestUser.getGuestId(), Account.class);

        // Validate guestId
        if (guestUser.getGuestId() < 0) {
            throw new RuntimeException("Guest Id is invalid and cannot be negative");
        }

        Map<String, Object> response = new HashMap<>();

        if (accountData.getStatusCode() == HttpStatus.NO_CONTENT) {
            response.put("status", "failed");
            response.put("message", "You cannot have expense because you don’t have an account");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } else if (accountData.getBody().getBalance() < guestUser.getMonthlyExpense()) {
            response.put("status", "failed");
            response.put("message", "Insufficient balance. Have balance before applying expense");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } else {
            boolean result = guestService.saveGuest(guestUser);
            if (result) {
                response.put("status", "success");
                response.put("message", "Expense added successfully");
                response.put("guestId", guestUser.getGuestId());
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                response.put("status", "failed");
                response.put("message", "Your data is incorrect");
                return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
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

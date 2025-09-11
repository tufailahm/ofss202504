package com.training.softbankrestapi.controller;

import com.training.softbankrestapi.dao.AccountDAO;
import com.training.softbankrestapi.dao.AccountDAOImpl;
import com.training.softbankrestapi.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController  //details later
@RequestMapping("/softbank/api/accounts")
public class AccountController {

    AccountDAO accountDAO = new AccountDAOImpl();

    @GetMapping("hi")         //http://localhost:9090/softbank/api/accounts/hi
    public String sayHello(){
        return "Hello OFSS";
    }



    @GetMapping("message")         //http://localhost:9090/softbank/api/accounts/message
    public String sayMessage(){
        return "Hello Good morning";
    }

    @GetMapping          //  http://localhost:9090/softbank/api/accounts
   // http://localhost:9090/softbank/api/accounts?mobileNumber=
    public List<Account> getAccounts(@RequestParam(value = "mobileNumber", required = false)String  mobileNumber){
        List<Account> list = new ArrayList<>();
        if(mobileNumber == null){
            list = accountDAO.getAccount();
        }
        else {
              list = accountDAO.getAccount(mobileNumber);     //select * from accounts
        }
        return list;
    }

    //WELCOME USER BY NAME
    @GetMapping("name/{nn}")   // http://localhost:9090/softbank/api/accounts/name/naina
    public String welcome(@RequestHeader("ofss")String company, @PathVariable("nn")String name)
    {
        return "Welcome , " +name+" You are in location :"+company;
    }

    @GetMapping("{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable int accountNumber) throws SQLException {
        ResponseEntity<Account> responseEntity;
       Account account = new Account();
        if(accountDAO.isAccountExists(accountNumber)){
            account = accountDAO.getAccount(accountNumber);
                    responseEntity = new ResponseEntity<Account>(account, HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<Account>(account, HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }




    @GetMapping("add/{a}/{b}")
    public double addNumbers(@PathVariable double a, @PathVariable double b) throws SQLException {
        return a + b;
    }

    @GetMapping("random/{startRange}")
    public int getRandomTill100(@PathVariable int startRange) throws SQLException {
        return new Random().nextInt(startRange, 100);
    }

    @GetMapping("random/{startRange}/{endRange}")
    public int getRandomInRange(@PathVariable int startRange,@PathVariable int endRange) throws SQLException {
        return new Random().nextInt(startRange, endRange);
    }




    //GET A SINGLE ACCOUNT NUMBER
//    @GetMapping("{accountNumber}")    //  http://localhost:9090/softbank/api/accounts/1001
//    public Account getAccount(@PathVariable("accountNumber")String accountNumber) {
//
//
//    }


    //SAVE a account
    @PostMapping        //http://localhost:9090/softbank/api/accounts       -POST
    public ResponseEntity<String> saveAccount(@RequestBody Account account){
        if(accountDAO.isAccountExists(account.getAccountNumber())){
            return new ResponseEntity<String>("Account number already exists", HttpStatus.CONFLICT);
        }
        else {
            accountDAO.createAccount(account);
            return new ResponseEntity<String>("Account number Saved successfully", HttpStatus. CREATED);
        }
    }


    //UPDATE aan account
    @PutMapping        //http://localhost:9090/softbank/api/accounts       -POST
    public ResponseEntity<String> updateAccount(@RequestBody Account account){
        if(accountDAO.isAccountExists(account.getAccountNumber())){
            accountDAO.updateAccount(account);
            return new ResponseEntity<String>("Account number  updated ", HttpStatus.OK);

        }
        else {
            return new ResponseEntity<String>("Account number does not  exists", HttpStatus.OK);
        }
    }


    //DELETE        http://localhost:9090/softbank/api/accounts/1919


    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accountNumber) throws SQLException {
        if (accountDAO.isAccountExists(accountNumber)) {
            accountDAO.deleteAccount(accountNumber);
            return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Account not found", HttpStatus.NO_CONTENT);
        }
    }

    //Transfer
    @PutMapping("transfer/{from}/{to}/{amount}")
    public ResponseEntity<String> transferAccount(@PathVariable("from") int from, @PathVariable("to") int to, @PathVariable("amount") int amount) {
        if (accountDAO.isAccountExists(from) && accountDAO.isAccountExists(to)) {
           boolean result =  accountDAO.transfer(from, to, amount);
           if(result)
           {
               return new ResponseEntity<>("Money transferred successfully", HttpStatus.OK);
           }
            else {
               return new ResponseEntity<>("Money transferred failed ", HttpStatus.valueOf(420));
           }
        } else {
            return new ResponseEntity<>("Account(s) not found", HttpStatus.NOT_FOUND);
        }
    }


}

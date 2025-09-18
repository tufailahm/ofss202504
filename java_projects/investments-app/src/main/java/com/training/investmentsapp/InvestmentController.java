package com.training.investmentsapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvestmentController {


    @GetMapping("getInterestRate")
    public String getInterestRate(){
        return "Current Interest Rate is : 7.3";
    }
}

package com.springsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BalanceController {

    @GetMapping("/getAccount")
    public  String getAccount(){
        return "Account in DataBase";
    }
}

package com.springsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/getbalance")
    public  String getBalance(){
       return "Balance in DataBase";
    }


}

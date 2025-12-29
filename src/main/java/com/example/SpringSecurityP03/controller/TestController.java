package com.example.SpringSecurityP03.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class TestController {

    @GetMapping("/login")
    @PreAuthorize("hasRole('ADMIN')")
    public String login(){
        return "This is login page";
    }

    @GetMapping("/getbalance")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String getBalance(){
        return "This is getBalance page";
    }

    @GetMapping("/aboutUs")
    @PreAuthorize("hasRole('USER')")
    public String aboutUs(){
        return "This is about Us page";
    }

    @GetMapping("/contactUs")
    @PreAuthorize("hasRole('USER')")
    public String contactUs(){
        return "This is contact us page";
    }

}

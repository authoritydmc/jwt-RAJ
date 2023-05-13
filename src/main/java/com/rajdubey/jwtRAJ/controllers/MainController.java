package com.rajdubey.jwtRAJ.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String welcome()
    {
        return "welcome buddy ,some addition to check dev tools";
    }
}

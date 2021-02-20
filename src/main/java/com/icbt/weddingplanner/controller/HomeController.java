package com.icbt.weddingplanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/home")
public class HomeController {

    @GetMapping
    public String home(){
        return "<h1>WELCOME TO WEDDING PLANNER REST API</h1>";
    }

}

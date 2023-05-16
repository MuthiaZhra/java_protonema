package com.protonema.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.protonema.restapi.dto.Request;


@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {

    //Post Method

    @PostMapping
    public String PostData(@RequestBody Request request){
        return "Halo, Selamat datang " + request.getName();
    }

    //Get Method
    @GetMapping
    @RequestMapping("/get")
    public String GetData(){
        return" Hai , ini adalah get Method";
    }

    //Put Method
    @PutMapping 
    public Request updateData(@RequestBody Request request){
        return request;
        
    }

    //Parameter

    @PostMapping
    @RequestMapping("/parameter")
    public Long postParameter(@RequestParam  Long x , @RequestParam Long y){
        return x+y;
    }


   
    
}

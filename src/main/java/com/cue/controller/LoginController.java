package com.cue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cue.dao.Handler;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	Handler handler;
	
	@GetMapping
    public Integer loginValidate(@RequestParam(value="email") String email, @RequestParam(value="password") String password){
		System.out.println();
		System.out.println("Request Param email: " + email);
		System.out.println("Request Param password: " + password);
		
		return handler.validateLogin(email, password);
    }

}

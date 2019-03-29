package com.cue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cue.beans.User;
import com.cue.dao.UserDaoImpl;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserDaoImpl ud;
	
	@GetMapping(value="/all")
    public List<User> getAllUsers(){
		return ud.getAllUsers();
    }
	
	@GetMapping(value="/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		User user = ud.getUserById(id);
		if(user == null) {
			// Maybe add an Exception here if I want?
		}
		return user;
	}
	

}

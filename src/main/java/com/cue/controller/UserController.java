package com.cue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping
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
	
	@PostMapping
	public boolean createUser(@RequestBody User user){
		List<User> users = ud.getAllUsers();
		for(User u : users) {
			if(u.getId() == user.getId()) {
				return false;
			}
		}
		return ud.createUser(user);
	}
	
	@PutMapping("/{id}")
	public boolean updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		List<User> users = ud.getAllUsers();
		for(User u : users) {
			if(u.getId() == id) {
				user.setId(id);
				return ud.updateUser(user);
			}
		}
		return false;
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable("id") Integer id) {
		List<User> users = ud.getAllUsers();
		for(User u : users) {
			if(u.getId() == id) {
				return ud.deleteUserById(id);
			}
		}
		return false;
	}

}

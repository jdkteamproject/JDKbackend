package com.cue.dao;

import java.util.List;

import org.json.simple.JSONObject;

import com.cue.models.User;

public interface UserDao {
	
	public List<User> getAllUsers();
	public User getUserById(Integer id);
	public boolean createUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUserById(Integer id);
	public User getUserByEmail(String email);

}

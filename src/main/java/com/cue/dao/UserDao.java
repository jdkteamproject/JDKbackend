package com.cue.dao;

import java.util.List;

import com.cue.beans.User;

public interface UserDao {
	
	public List<User> getAllUsers();
	public User getUserById(int id);
	public boolean createUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUserById(int id);

}

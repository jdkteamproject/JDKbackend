package com.cue.handler;

import java.util.List;

import org.json.simple.JSONObject;

import com.cue.beans.User;

public class Handler implements UserDao {
	
	private UserDao ud = new UserDaoImpl();
	private TicketMasterAPI tm = new TicketMasterAPI();
	
	public JSONObject getAllAPIEvents() {
		return tm.getAllAPIEvents();
	}

	@Override
	public List<User> getAllUsers() {
		return ud.getAllUsers();
	}

	@Override
	public User getUserById(int id) {
		return ud.getUserById(id);
	}

	@Override
	public boolean createUser(User user) {
		return ud.createUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
	}

}

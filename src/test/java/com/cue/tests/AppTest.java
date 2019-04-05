package com.cue.tests;

import java.util.ArrayList;
import java.util.List;

import com.cue.dao.Handler;
import com.cue.models.Event;
import com.cue.models.User;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
    extends TestCase
    {
	
	Handler handler = new Handler();
	
	User user1 = new User("testing1@gmail.com", "testing1", "123", "Sports", "New York");
	User user2 = new User("testing2@gmail.com", "testing2", "123", "Arts", "New Orleans");
	
	Event event1 = new Event("G5diZ4oLvGfYG");
	Event event2 = new Event("vv1A7ZAf4Gkdb0k-J");

    public AppTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( AppTest.class );
    }
    
    public void testPasswordValidation() {
    	if(handler.getUserByEmail("testing1@gmail.com") == null) handler.createUser(user1);
    	User testUser = handler.getUserByEmail("testing1@gmail.com");
    	
        assertEquals(handler.validateLogin(user1.getEmail(), user1.getPassword()), testUser.getId());
    }
    
    public void testPasswordValidation2() {
    	if(handler.getUserByEmail("testing1@gmail.com") == null) handler.createUser(user1);
    	Integer result = -1;
    	
        assertEquals(handler.validateLogin(user1.getEmail(), "__**//%%$$"), result);
    }

    public void testGetAllCategories() {
    	List<String> temp = new ArrayList<String>();
		temp.add("Arts");
		temp.add("Music");
		temp.add("Sports");
   
        assertEquals(handler.getAllCategories(), temp);
    }
    
    public void testDeleteAndCreateUser() {
    	if(handler.getUserByEmail("testing1@gmail.com") != null) {
    		User testUser = handler.getUserByEmail("testing1@gmail.com");
    		assertTrue(handler.deleteUserById(testUser.getId()));
    	} else {
    		assertTrue(handler.createUser(user1));
    	}
    }
    
    public void testDeleteAndCreateUser2() {
    	if(handler.getUserByEmail("testing2@gmail.com") != null) {
    		User testUser = handler.getUserByEmail("testing2@gmail.com");
    		assertTrue(handler.deleteUserById(testUser.getId()));
    	} else {
    		assertTrue(handler.createUser(user2));
    	}
    }
    
    public void testUpdateUser() {
    	if(handler.getUserByEmail("testing1@gmail.com") == null) this.testDeleteAndCreateUser();
    	
    	User testUser = handler.getUserByEmail("testing1@gmail.com");
    	boolean testBool;
    	if(testUser.isAdmin()) {
    		testUser.setAdmin(false);
    		testBool = false;
    	} else {
    		testUser.setAdmin(true);
    		testBool = true;
    	}
    	handler.updateUser(testUser);
    	
    	
    	assertEquals((boolean)handler.getUserById(testUser.getId()).isAdmin(), testBool);
    	
    }
    
    public void testUpdateUser2() {
    	if(handler.getUserByEmail("testing1@gmail.com") == null) this.testDeleteAndCreateUser();
    	
    	User testUser = handler.getUserByEmail("testing1@gmail.com");
    	boolean testBool;
    	if(testUser.isBanned()) {
    		testUser.setBanned(false);
    		testBool = false;
    	} else {
    		testUser.setBanned(true);
    		testBool = true;
    	}
    	handler.updateUser(testUser);
    	
    	
    	assertEquals((boolean)handler.getUserById(testUser.getId()).isBanned(), testBool);
    }
    
    public void testUpdateUser3() {
    	if(handler.getUserByEmail("testing1@gmail.com") == null) this.testDeleteAndCreateUser();
    	
    	User testUser = handler.getUserByEmail("testing1@gmail.com");
    	String testString = "updateTest";
    	testUser.setUsername(testString);
    	handler.updateUser(testUser);
    	
    	
    	assertEquals((String)handler.getUserById(testUser.getId()).getUsername(), testString);
    	
    }
    
//    public void testUpdateUser4() {
//    	if(handler.getUserByEmail("testing1@gmail.com") == null) this.testDeleteAndCreateUser();
//    	
//    	User testUser = handler.getUserByEmail("testing1@gmail.com");
//    	testUser.setFavEvents(new HashSet<Event>());
//    	
//    	handler.updateUser(testUser);
//    	
//    	
//    	assertEquals((HashSet<Event>)handler.getUserById(testUser.getId()).getFavEvents(), new HashSet<Event>());
//    	
//    }
//    
//    public void testAddfavEvent() {
//    	if(handler.getUserByEmail("testing1@gmail.com") == null) this.testDeleteAndCreateUser();
//    	List<Event> events = handler.getAllEvents();
//    	boolean exists = false;
//    	for(Event e : events) {
//    		if(e.getE_sid().equals("G5diZ4oLvGfYG")) {
//    			exists = true;
//    			event1 = e;
//    		}
//    	}
//    	if(!exists) handler.createEvent(event1);
//    	
//    	User testUser = handler.getUserByEmail("testing1@gmail.com");
//    	
//    	testUser.addFavEvent(event1);
//    	
//    	handler.updateUser(testUser);
//    	
//    	assertEquals((HashSet<Event>)handler.getUserById(testUser.getId()).getFavEvents(), testUser.getFavEvents());
//    	
//    }
    
}






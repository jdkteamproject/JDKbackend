package com.cue.main;

import com.cue.dao.Handler;
import com.cue.models.Event;
import com.cue.models.Notification;
import com.cue.models.User;

public class Driver {

	public static void main(String[] args) {

//		Session s = HibernateUtil.getSession();
//		s.close();
		
		Handler handler = new Handler();
		
		User user1 = new User("tester1@gmail.com", "tester1", "123", "Sports", "New York");
		User user2 = new User("tester2@gmail.com", "tester2", "123", "Arts", "New Orleans");
		User user3 = new User("tester3@gmail.com", "tester3", "password1", "Music", "Seattle");
		User user4 = new User("tester4@gmail.com", "tester4", "!!!", "Arts", "Miami");
		User user5 = new User("admin1@gmail.com", "admin", "admin", "Sports", "Portland");
		user5.setAdmin(true);
		
		Event event1 = new Event("G5diZ4oLvGfYG");
		Event event2 = new Event("vv1A7ZAf4Gkdb0k-J");
		Event event3 = new Event("G5viZ4xNaxPva");
		Event event4 = new Event("177YvfG6ucTT-Ar");
		
		Notification n1 = new Notification("You've got mail!");
		Notification n2 = new Notification("You've been banned, sorry!");
		
		handler.createEvent(event1);
		handler.createEvent(event2);
		handler.createEvent(event3);
		handler.createEvent(event4);
		
		handler.createNotification(n1);
		handler.createNotification(n2);
		
		user1.addNotification(n1);
		user3.addNotification(n1);
		user3.setBanned(true);
		user3.addNotification(n2);
		
		user1.addFavEvent(event1);
		user1.addFavEvent(event2);
		user2.addFavEvent(event1);
		user3.addFavEvent(event3);
		user3.addFavEvent(event4);
		user4.addFavEvent(event1);
		
		handler.createUser(user1);
		handler.createUser(user2);
		handler.createUser(user3);
		handler.createUser(user4);
		handler.createUser(user5);
		
//		HibernateUtil.closeSessionFactory();
	}

}
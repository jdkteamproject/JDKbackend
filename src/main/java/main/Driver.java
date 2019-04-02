package main;

import com.cue.dao.Handler;
import com.cue.models.Event;
import com.cue.models.Notification;
import com.cue.models.User;

public class Driver {

	public static void main(String[] args) {

//		Session s = HibernateUtil.getSession();
//		s.close();
		
		Handler handler = new Handler();
		
		User user1 = new User("shimjay1@gmail.com", "magikarp", "123", "New York");
		User user2 = new User("alfonzo@gmail.com", "alfonzo", "123", "New Orleans");
		User user3 = new User("newPerson@gmail.com", "NewGuy", "password1", "Seattle");
		User user4 = new User("person4@gmail.com", "4th Person", "!!!", "Miami");
		user3.setCategory("Sports");
		user2.setCategory("Music");
		
		Event event1 = new Event("G5diZ4oLvGfYG");
		Event event2 = new Event("vv1A7ZAf4Gkdb0k-J");
		
		Notification n1 = new Notification("You've got mail!");
		Notification n2 = new Notification("You've been banned, sorry!");
		
		handler.createEvent(event1);
		handler.createEvent(event2);
		
		user1.addFavEvent(event1);
		user1.addFavEvent(event2);
		user2.addFavEvent(event1);
		
		handler.createUser(user1);
		handler.createUser(user2);
		handler.createUser(user3);
		
//		HibernateUtil.closeSessionFactory();
	}

}
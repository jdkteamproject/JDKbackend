package main;

import java.util.List;

import com.cue.beans.User;
import com.cue.dao.Handler;
import com.cue.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

//		Session s = HibernateUtil.getSession();
//		s.close();
		
		Handler handler = new Handler();
		
//		User user1 = new User("shimjay1@gmail.com", "magikarp", "123");
//		handler.createUser(user1);
//		
//		User user2 = new User("alfonzo@gmail.com", "alfonzo", "123");
//		handler.createUser(user2);
		
		System.out.println("Getting all users...");
		List<User> users = handler.getAllUsers();
		
		for(User user: users) {
			System.out.println(user);
		}
		
		System.out.println("Got all users");
		
		HibernateUtil.closeSessionFactory();
	}

}
package main;

import com.cue.beans.User;
import com.cue.dao.UserDao;
import com.cue.dao.UserDaoImpl;
import com.cue.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

//		Session s = HibernateUtil.getSession();
//		s.close();
		
		UserDao ud = new UserDaoImpl();
		
		User user1 = new User("shimjay1@gmail.com", "magikarp", "123", "New York");
		ud.createUser(user1);
		
		User user2 = new User("alfonzo@gmail.com", "alfonzo", "123", "Reston");
		user2.addFriend(user1);
		ud.createUser(user2);
		
		HibernateUtil.closeSessionFactory();
	}

}
package com.cue.handler;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cue.beans.User;
import com.cue.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getAllUsers() {
		Session s = HibernateUtil.getSession();
		List<User> users = null;
		
		try {
			users = s.createCriteria(User.class).list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return users;
	}

	@Override
	public User getUserById(int id) {
		Session s = HibernateUtil.getSession();
		User u = null;
		
		try{
			u = (User) s.get(User.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return u;
	}

	@Override
	public boolean createUser(User user) {
		boolean created = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		try {
			s.save(user);
			tx.commit();
			created = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally{
			s.close();
		}
	
		return created;
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

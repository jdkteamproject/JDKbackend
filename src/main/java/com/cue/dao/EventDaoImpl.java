package com.cue.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.cue.models.Event;
import com.cue.util.HibernateUtil;

@Component
public class EventDaoImpl implements EventDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getAllEvents() {
		Session s = HibernateUtil.getSession();
		List<Event> events = null;
		
		try {
			events = s.createCriteria(Event.class).list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return events;
	}

	@Override
	public Event getEventById(Integer id) {
		Session s = HibernateUtil.getSession();
		Event u = null;
		
		try{
			u = (Event) s.get(Event.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return u;
	}

	@Override
	public boolean createEvent(Event event) {
		boolean created = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		try {
			s.save(event);
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
	public boolean updateEvent(Event change) {
		boolean changed = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Event u = null;
		
		try {
			u = (Event) s.get(Event.class, change.getE_id());
			
			if(change.getE_sid() != null) {
				u.setE_sid(change.getE_sid());
			}
			
			s.save(u);
			tx.commit();
			changed = true;
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();			
		}finally {
			s.close();
		}
		
		return changed;
	}

	@Override
	public boolean deleteEventById(Integer id) {
		boolean deleted = false;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();;
		
		try {
			s.delete(s.get(Event.class, id));
			tx.commit();
			
			deleted = true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		return deleted;
		
	}

}

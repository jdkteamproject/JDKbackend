package com.cue.dao;

import java.util.List;

import com.cue.models.Event;

public interface EventDao {
	
	public List<Event> getAllEvents();
	public Event getEventById(Integer id);
	public boolean createEvent(Event event);
	public boolean updateEvent(Event event);
	public boolean deleteEventById(Integer id);

}

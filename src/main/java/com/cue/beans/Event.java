package com.cue.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {
	@Id
	@Column(name="e_id")
	private int id;

	public Event() {
		super();
	}

	public Event(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + "]";
	}
	
	
}

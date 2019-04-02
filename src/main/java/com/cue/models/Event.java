package com.cue.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {
	@Id
	@Column(name="e_id")
	@SequenceGenerator(sequenceName="event_seq", name="e_seq")
	@GeneratedValue(generator="e_seq", strategy=GenerationType.SEQUENCE)
	private Integer e_id;
	
	@Column(name="e_sid")
	private String e_sid;

	public Event() {
		super();
	}

	public Event(String e_sid) {
		super();
		this.e_sid = e_sid;
	}
	
	public Event(Integer e_id, String e_sid) {
		super();
		this.e_id = e_id;
		this.e_sid = e_sid;
	}

	public Integer getE_id() {
		return e_id;
	}

	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}

	public String getE_sid() {
		return e_sid;
	}

	public void setE_sid(String e_sid) {
		this.e_sid = e_sid;
	}

	@Override
	public String toString() {
		return "Event [e_id=" + e_id + ", e_sid=" + e_sid + "]";
	}
	
	
}

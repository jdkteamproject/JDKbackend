package com.cue.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="notifications")
public class Notification {
	@Id
	@Column(name="n_id")
	@SequenceGenerator(sequenceName="notification_seq", name="n_seq")
	@GeneratedValue(generator="n_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="n_message")
	private String message;

	public Notification() {
		super();
	}
	
	public Notification(String message) {
		super();
		this.message = message;
	}
	
	public Notification(Integer id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", message=" + message + "]";
	}
	
	
}

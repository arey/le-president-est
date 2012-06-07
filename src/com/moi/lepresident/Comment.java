package com.moi.lepresident;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

public class Comment implements Serializable {
	
	@Id
	private Long id;
	
	private String user;
	
	private String text;
	
	private Date date;
	
	public Comment() {
		
	}
	
	public Comment(String user, String text) {
		this.user = user;
		this.text = text;
		this.date = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}

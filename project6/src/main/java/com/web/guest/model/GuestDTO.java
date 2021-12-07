package com.web.guest.model;

import java.sql.Date;

public class GuestDTO {
	private int id;
	private String writer;
	private String context;
	private Date gDate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getContext() {
		return context;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	public Date getgDate() {
		return gDate;
	}
	
	public void setgDate(Date gDate) {
		this.gDate = gDate;
	}
	
	public void setgDate(String gDate) {
		this.gDate = Date.valueOf(gDate);
	}
}

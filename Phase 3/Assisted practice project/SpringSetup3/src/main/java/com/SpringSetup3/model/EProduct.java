package com.SpringSetup3.model;

import java.util.Date;

public class EProduct {
	private long ID;
	private String name;
	private Date dateAdded;

	public long getID() {
		return ID;
	}


	public void setID(long ID) {
		this.ID = ID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
}
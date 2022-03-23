package com.learnersacademy.models;

public class Teacher {
	
	private int id;
	private String tfname;
	private String lname;
	private int age;
	
	public Teacher(int id, String tfname, String lname, int age) {
		super();
		this.id = id;
		this.tfname = tfname;
		this.lname = lname;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return tfname;
	}

	public void setFname(String tfname) {
		this.tfname = tfname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}

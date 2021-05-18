package com.mindtree.entity;

public class Patient {
	private String name;
	private byte age;
	private int centerid;

	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, byte age, int centerid) {
		super();
		this.name = name;
		this.age = age;
		this.centerid = centerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public int getCenterid() {
		return centerid;
	}

	public void setCenterid(int centerid) {
		this.centerid = centerid;
	}

}

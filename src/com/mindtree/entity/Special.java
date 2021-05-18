package com.mindtree.entity;

public class Special {
	private String name;
	private String cname;
	private int id;
	private int strength;
	private int age;

	public Special() {
		super();

	}

	public Special(String name, String cname, int id, int strength, int age) {
		super();
		this.name = name;
		this.cname = cname;
		this.id = id;
		this.strength = strength;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

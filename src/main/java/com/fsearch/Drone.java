package com.fsearch;
public class Drone {
	private Integer id;
	private String hashName;
	public Integer getId() {
		return id;
	}
	public Drone(Integer id, String hashName) {
		super();
		this.id = id;
		this.hashName = hashName;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHashName() {
		return hashName;
	}
	public void setHashName(String hashName) {
		this.hashName = hashName;
	}
	}

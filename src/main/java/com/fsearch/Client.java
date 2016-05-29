package com.fsearch;

public class Client {
	private Integer id;
	private String hashName;

	public Integer getId() {
		return id;
	}
	public Client(Integer id, String hashName) {
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

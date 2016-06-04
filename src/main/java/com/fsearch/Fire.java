package com.fsearch;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Fire {
	private String hashNane;
	public Fire() {

	}

	public Fire(Integer id, Integer droneId, Integer fireRate, Double latitude, Double longtitude, Date date,String hashName) {
		super();
		this.hashNane=hashName;
		this.id = id;
		this.fireRate = fireRate;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.date = date;
		this.droneId = droneId;
	}

	public String getHashNane() {
		return hashNane;
	}

	public void setHashNane(String hashNane) {
		this.hashNane = hashNane;
	}

	public Integer getDroneId() {
		return droneId;
	}

	public void setDroneId(Integer droneId) {
		this.droneId = droneId;
	}

	private Integer id, fireRate, droneId;
	private Double latitude, longtitude;
	@JsonFormat(pattern="MMM d',' yyyy H:mm:ss a")	
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double altitude) {
		this.latitude = altitude;
	}

	public Integer getFireRate() {
		return fireRate;
	}

	public void setFireRate(Integer fireRate) {
		this.fireRate = fireRate;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

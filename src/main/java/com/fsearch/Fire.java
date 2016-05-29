package com.fsearch;

import java.util.Date;

public class Fire {
	public Fire(Integer id, Integer fireRate, Double latitude, Double longtitude, Date date) {
		super();
		this.id = id;
		this.fireRate = fireRate;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.date = date;
	}

	private Integer id, fireRate;
	private Double latitude, longtitude;
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

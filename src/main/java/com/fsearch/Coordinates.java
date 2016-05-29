package com.fsearch;

public class Coordinates {
	private Integer id;
	private Double latitude, longtitude, altitude, speed;

	public Coordinates(Integer id, Double latitude, Double longtitude, Double altitude, Double speed) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.altitude = altitude;
		this.speed = speed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}
}

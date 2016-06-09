package com.fsearch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FireRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int createFire(Fire fire) {
		return jdbcTemplate.update("INSERT INTO fire (firerate,latitude,longtitude,date,droneid) VALUES (?,?,?,?,?)",
				fire.getFireRate(), fire.getLatitude(), fire.getLongtitude(), 
				fire.getDate().getTime(),    
				fire.getDroneId());
	}

	public List<Fire> getFire() {
		try {
			return jdbcTemplate.query("SELECT * FROM 	fire", new FireMapper());
		} catch (Exception e) {
			return null;
		}
	}

	public List<Fire> getFire(Date timeFrom) {
		try {
			return jdbcTemplate.query("SELECT * FROM fire WHERE date > ?", new FireMapper(),timeFrom.getTime());
		} catch (Exception e) {
			return null;
		}
	}
}

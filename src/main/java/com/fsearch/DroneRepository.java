package com.fsearch;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DroneRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int createDrone(Drone drone) {
		return jdbcTemplate.update("INSERT INTO drone (hashname) VALUES (?)", drone.getHashName());
	}
	public Drone getDrone(String hashName){
	return jdbcTemplate.queryForObject("SELECT * FROM drone WHERE hashname=?", new DroneMapper(), hashName);
	}
	public List<Drone> getDrone() {
		try{
		return jdbcTemplate.query("SELECT * FROM 	drone", new DroneMapper());
		} catch(Exception e){
			return null;
		}
		
	}
}

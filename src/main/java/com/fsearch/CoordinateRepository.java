package com.fsearch;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class CoordinateRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int createCoordinate(Coordinates coordinates){
	return	jdbcTemplate.update("INSERT INTO coordinate (latitude,longtitude,altitude,speed,date,droneid) VALUES (?,?,?,?,?,?)",coordinates.getLatitude(),coordinates.getLongtitude(),coordinates.getAltitude(),coordinates.getSpeed(),coordinates.getDate(),coordinates.getDroneID() );
	}
	public List<Coordinates> getCoordinate(){
	return jdbcTemplate.query("SELECT * FROM 	coordinate", 	new	CoordinateMapper());
	}
}

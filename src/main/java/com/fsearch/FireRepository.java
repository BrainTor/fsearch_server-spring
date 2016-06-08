package com.fsearch;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class FireRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int createFire(Fire fire){
	return	jdbcTemplate.update("INSERT INTO \"FIRE\" (\"fireRate\",\"latitude\",\"longtitude\",\"date\",\"droneID\") VALUES (?,?,?,?,?)",fire.getFireRate(),fire.getLatitude(),fire.getLongtitude(),fire.getDate(),fire.getDroneId() );
	}
	public List<Fire> getFire(){
	return jdbcTemplate.query("SELECT * FROM 	\"FIRE\"", 	new	FireMapper());
	}
}

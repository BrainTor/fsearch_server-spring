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
public int createDrone(Drone drone){
return	jdbcTemplate.update("INSERT INTO drone (hashname) VALUES (?)",drone.getHashName() );
}
public List<Drone> getDrone(){
return jdbcTemplate.query("SELECT * FROM 	\"Drone\"", 	new	DroneMapper());
}
}

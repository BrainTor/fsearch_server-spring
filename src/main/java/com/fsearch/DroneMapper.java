package com.fsearch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
	public class DroneMapper implements RowMapper<Drone> {
		public Drone mapRow(ResultSet rs, int rowNum) throws SQLException {
		Drone drone= new Drone(rs.getInt("id"),rs.getString("hashName"));
	    return drone;
		}
}

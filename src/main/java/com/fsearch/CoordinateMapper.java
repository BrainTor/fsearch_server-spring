package com.fsearch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
public class CoordinateMapper implements RowMapper<Coordinates> {
	public Coordinates mapRow(ResultSet rs, int rowNum) throws SQLException {
	Coordinates coordinates= new Coordinates();
    coordinates.setLatitude(rs.getDouble("latitude"));
    coordinates.setLongtitude(rs.getDouble("longtitude"));
    coordinates.setAltitude(rs.getDouble("altitude"));
    coordinates.setSpeed(rs.getDouble("speed"));
    coordinates.setDate(new Date(rs.getLong("date")));
    coordinates.setDroneID(rs.getInt("droneid"));
	return coordinates;
	}
}

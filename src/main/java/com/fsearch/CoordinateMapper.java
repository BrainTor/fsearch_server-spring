package com.fsearch;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class CoordinateMapper implements RowMapper<Coordinates> {
	public Coordinates mapRow(ResultSet rs, int rowNum) throws SQLException {
	Coordinates coordinates= new Coordinates();
    coordinates.setLatitude(rs.getDouble("latitude"));
    coordinates.setLongtitude(rs.getDouble("longtitude"));
    coordinates.setAltitude(rs.getDouble("altitude"));
    coordinates.setSpeed(rs.getDouble("speed"));
    coordinates.setDate(rs.getDate("date"));
    coordinates.setDroneID(rs.getInt("droneID"));
	return coordinates;
	}
}

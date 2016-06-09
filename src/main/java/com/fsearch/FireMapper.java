package com.fsearch;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class FireMapper implements RowMapper<Fire>{
	public Fire mapRow(ResultSet rs, int rowNum) throws SQLException {
	Fire fire= new Fire();
    fire.setLatitude(rs.getDouble("latitude"));
    fire.setLongtitude(rs.getDouble("longtitude"));
    fire.setDate(rs.getDate("date"));
    fire.setDroneId(rs.getInt("droneid"));
    fire.setFireRate(rs.getInt("firerate"));
	return fire;
	}
}

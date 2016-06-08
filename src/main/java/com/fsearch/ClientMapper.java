package com.fsearch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class ClientMapper implements RowMapper<Client> {
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client= new Client(rs.getInt("id"),rs.getString("hashName"));
	    return client;
	}
}

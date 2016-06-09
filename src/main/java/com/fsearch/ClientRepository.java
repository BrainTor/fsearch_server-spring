package com.fsearch;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int createClient(Client client) {
		return jdbcTemplate.update("INSERT INTO client (hashname) VALUES (?)", client.getHashName());
	}

	public Client getClient(String hashName) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM client WHERE hashname=?", new ClientMapper(), hashName);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Client> getClient() {
		try {
			return jdbcTemplate.query("SELECT * FROM 	client", new ClientMapper());
		} catch (Exception e) {
			return null;
		}
	}
}

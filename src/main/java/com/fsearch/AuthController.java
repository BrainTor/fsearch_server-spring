package com.fsearch;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	ArrayList<Drone> droneList = new ArrayList<Drone>();
	ArrayList<Client> clientList = new ArrayList<Client>();
	@RequestMapping("/auth/fillDrone")
	public Boolean setDrone(
			@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "ID", required = true) Integer ID)
		    {
		if(!hashName.equals("password")){
			return false;
		}
		Drone drone = new Drone(ID,hashName);
		droneList.add(drone);
		return true;
	}
	@RequestMapping("/auth/fillClient")
	public Boolean setClient(
			@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "hashNameDrone", required = true) String hashNameDrone,
			@RequestParam(value = "ID", required = true) Integer ID)
		    {
		if(!hashName.equals("password")){
			return false;
		}
		Client client = new Client(ID,hashNameDrone);
		clientList.add(client);
		return true;
	}

}

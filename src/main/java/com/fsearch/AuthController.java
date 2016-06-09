package com.fsearch;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	ArrayList<Drone> droneList = new ArrayList<Drone>();
	ArrayList<Client> clientList = new ArrayList<Client>();
	@RequestMapping(value="/auth/fillDrone",method={RequestMethod.POST,RequestMethod.GET})
	public Boolean setDrone(
			@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "hashNameDrone", required = true) String hashNameDrone)
		    {
		if(!hashName.equals("password")){
			return false;
		}
		Drone drone = new Drone(0,hashNameDrone);
		droneList.add(drone);
		return true;
	}
	@RequestMapping(value="/auth/fillClient",method={RequestMethod.POST,RequestMethod.GET})
	public Boolean setClient(
			@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "hashNameClient", required = true) String hashNameClient)
		    {
		if(!hashName.equals("password")){
			return false;
		}
		Client client = new Client(0,hashNameClient);
		clientList.add(client);
		return true;
	}

}

package com.fsearch;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	@Autowired
	private DroneRepository droneRepository;
	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping(value = "/auth/fillDrone", method = { RequestMethod.POST, RequestMethod.GET })
	public Boolean setDrone(@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "hashNameDrone", required = true) String hashNameDrone) {
		java.util.List<Drone> list = droneRepository.getDrone();
		if (list.size() == 0) {
			if (!hashName.equals("password")) {
				return false;
			}
		} else if (droneRepository.getDrone(hashName) == null) {
			return false;
		}
		Drone drone = new Drone(0, hashNameDrone);
		droneRepository.createDrone(drone);
		return true;
	}

	@RequestMapping(value = "/auth/fillClient", method = { RequestMethod.POST, RequestMethod.GET })
	public Boolean setClient(@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "hashNameClient", required = true) String hashNameClient) {
		java.util.List<Client> list = clientRepository.getClient();
		if (list.size() == 0) {
			if (!hashName.equals("password")) {
				return false;
			}
		} else if (clientRepository.getClient(hashName) == null) {
			return false;
		}
		Client client = new Client(0, hashNameClient);
		clientRepository.createClient(client);
		return true;
	}

}

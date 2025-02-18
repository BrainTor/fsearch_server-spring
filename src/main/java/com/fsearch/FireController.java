package com.fsearch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FireController {
	@Autowired
	private DroneRepository droneRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private FireRepository fireRepository;
	@RequestMapping("/fire/set")
	public Boolean Fire(
			@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "latitude", required = true) Double latitude,
			@RequestParam(value = "longtitude", required = true) Double longtitude,
			@RequestParam(value = "fireRate", required = true) Integer fireRate) {
		Drone drone=droneRepository.getDrone(hashName);
		if(drone==null){
			return false;
		}
		Fire fire = new Fire(0,drone.getId(),fireRate,  latitude, longtitude,new Date(),null);
		fireRepository.createFire(fire);
		return true;
	}
	@RequestMapping(value="/fire/get",method={RequestMethod.POST,RequestMethod.GET})
	public ArrayList<Fire> getCoordinate(@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "timeFrom", required = false) String timeFrom) 
	// date format string https://www.ibm.com/support/knowledgecenter/SSMKHH_9.0.0/com.ibm.etools.mft.doc/ak05616_.htm
	{
		Client client=clientRepository.getClient(hashName);
		if(client==null){
			return null;
		}
		if(timeFrom==null){
			return (ArrayList<com.fsearch.Fire>) fireRepository.getFire();	
		}
		else{
			SimpleDateFormat parserSDF = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
	        Date date=null;
			try {
				date = parserSDF.parse(timeFrom);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.err.println("! "+date+" ! "+fireRepository.getFire(date));
			return (ArrayList<com.fsearch.Fire>) fireRepository.getFire(date);
		}

	}
	@RequestMapping(value="/fire/set_",method=RequestMethod.POST)
	public Boolean setCoordinate(
			@RequestBody Fire fire,@RequestParam("hashName") String hashName){
		Drone drone=droneRepository.getDrone(hashName);
		if(drone==null){
			return false;
		}
		fire.setDroneId(drone.getId());
		fire.setDate(new Date());
		fireRepository.createFire(fire);
		return true;
	}

}

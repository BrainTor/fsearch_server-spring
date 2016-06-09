package com.fsearch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoordController {
	@Autowired
	private DroneRepository droneRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CoordinateRepository coordinateRepository;
	@RequestMapping("/")
	public String index() {
		return "Вы подключились на сервер <br/>Добавить пользователя <a href='/auth.html'>здесь</a> <br/>Добавить пожар <a href='/setfire.html'>здесь</a> <br/>Добавить координату <a href='/setcoordinate.html'>здесь</a> ";
	}

	@RequestMapping("/coordinates/set")
	public Boolean setCoordinate(
			@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "latitude", required = true) Double latitude,
			@RequestParam(value = "longtitude", required = true) Double longtitude,
			@RequestParam(value = "altitude", required = true) Double altitude,
			@RequestParam(value = "speed", required = true) Double speed) {
		Drone drone=droneRepository.getDrone(hashName);
		if(drone==null){
			return false;
		}
		Coordinates coordinates = new Coordinates(0, drone.getId(), new Date(), latitude, longtitude, altitude, speed);
		coordinateRepository.createCoordinate(coordinates);
		return true;
	}
	@RequestMapping(value="/coordinates/get",method={RequestMethod.POST,RequestMethod.GET})
	public ArrayList<Coordinates> getCoordinate(@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "timeFrom", required = false) String timeFrom) {
		Client client=clientRepository.getClient(hashName);
		SimpleDateFormat parserSDF = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
        Date date=null;
		try {
			date = parserSDF.parse(timeFrom);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(client==null){
			return null;
		}
		if(timeFrom==null){
			return (ArrayList<com.fsearch.Coordinates>) coordinateRepository.getCoordinate();	
		}
		else{
			return (ArrayList<com.fsearch.Coordinates>)coordinateRepository.getCoordinate(date);
		}

	}
	@RequestMapping(value="/coordinates/set_",method=RequestMethod.POST)
	public Boolean setCoordinate(
			@RequestBody Coordinates coordinate, @RequestParam("hashName") String hashName){
		Drone drone=droneRepository.getDrone(hashName);
		if(drone==null){
			return false;
		}
		coordinate.setDroneID(drone.getId());
		coordinate.setDate(new Date());
		coordinateRepository.createCoordinate(coordinate);
		return true;

	}
}

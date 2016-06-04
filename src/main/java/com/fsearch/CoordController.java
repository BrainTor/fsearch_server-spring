package com.fsearch;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoordController {
	ArrayList<Coordinates> arrayList = new ArrayList<Coordinates>();

	@RequestMapping("/")
	public String index() {
		return "Вы подключились на сервер";
	}

	@RequestMapping("/coordinates/set")
	public Boolean setCoordinate(
			@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "latitude", required = true) Double latitude,
			@RequestParam(value = "longtitude", required = true) Double longtitude,
			@RequestParam(value = "altitude", required = true) Double altitude,
			@RequestParam(value = "speed", required = true) Double speed) {
		if(!hashName.equals("password")){
			return false;
		}
		Coordinates coordinates = new Coordinates(0, 0, new Date(), latitude, longtitude, altitude, speed);
		arrayList.add(coordinates);
		return true;
	}
	@RequestMapping(value="/coordinates/get",method={RequestMethod.POST,RequestMethod.GET})
	public ArrayList<Coordinates> getCoordinate(@RequestParam(value = "hashName", required = true) String hashName) {
		if(!hashName.equals("password")){
			return null;
		}
		return arrayList;
	}
	
	@RequestMapping(value="/cordinates/set_",method=RequestMethod.POST)
	public Boolean setCoordinate(
			@RequestBody Coordinates coordinate,
			@RequestParam(value = "hashName", required = true) String hashName){
		System.out.println(hashName);
		if(!hashName.equals("password")){
			return false;
		}
		arrayList.add(coordinate);
		return true;
	}
}

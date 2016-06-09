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
		return "Вы подключились на сервер <br/>Добавить пользователя <a href='/auth.html'>здесь</a>";
	}

	@RequestMapping("/coordinates/set")
	public Boolean setCoordinate(
			@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "latitude", required = true) Double latitude,
			@RequestParam(value = "longtitude", required = true) Double longtitude,
			@RequestParam(value = "altitude", required = true) Double altitude,
			@RequestParam(value = "speed", required = true) Double speed) {
		if(!"password".equals(hashName)){
			return false;
		}
		Coordinates coordinates = new Coordinates(0, 0, new Date(), latitude, longtitude, altitude, speed);
		arrayList.add(coordinates);
		return true;
	}
	@RequestMapping(value="/coordinates/get",method={RequestMethod.POST,RequestMethod.GET})
	public ArrayList<Coordinates> getCoordinate(@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "timeFrom", required = false) Date timeFrom) {
		if(!"password".equals(hashName)){
			return null;
		}
		if (timeFrom == null) {
			return arrayList;
		}
		ArrayList<Coordinates> temp = new ArrayList<Coordinates>();
		for (Coordinates c : arrayList) {
			if (c.getDate().compareTo(timeFrom) > 0) {
				temp.add(c);
			}
		}
		return temp;

	}
	
	@RequestMapping(value="/coordinates/set_",method=RequestMethod.POST)
	public Boolean setCoordinate(
			@RequestBody Coordinates coordinate, @RequestParam("hashName") String hashName){
		if(!"password".equals(hashName)){
			return false;
		}
		arrayList.add(coordinate);
		return true;
	}
}

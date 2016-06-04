package com.fsearch;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FireController {
	ArrayList<Fire> arrayList = new ArrayList<Fire>();
	@RequestMapping("/fire/set")
	public Boolean Fire(
			@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "latitude", required = true) Double latitude,
			@RequestParam(value = "longtitude", required = true) Double longtitude,
			@RequestParam(value = "fireRate", required = true) Integer fireRate) {
		if(!hashName.equals("password")){
			return false;
		}
		Fire fire = new Fire(0,0,fireRate,  latitude, longtitude,new Date());
		arrayList.add(fire);
		return true;
	}
	@RequestMapping(value="/fire/get",method={RequestMethod.POST,RequestMethod.GET})
	public ArrayList<Fire> getCoordinate(@RequestParam(value = "hashName", required = true) String hashName) {
		if(!hashName.equals("password")){
			return null;
		}
		return arrayList;
	}
	@RequestMapping(value="/fire/set_",method=RequestMethod.POST)
	public Boolean setCoordinate(
			@RequestBody Fire fire,
			@RequestParam(value = "hashName", required = true) String hashName){		System.out.println(hashName);
		if(!hashName.equals("password")){
			return false;
		}
		arrayList.add(fire);
		return true;
	}

}

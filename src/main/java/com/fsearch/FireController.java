package com.fsearch;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
public class FireController {
	ArrayList<Fire> arrayList = new ArrayList<Fire>();
	@RequestMapping("/fire/set")
	public Boolean Fire(
			@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "latitude", required = true) Double latitude,
			@RequestParam(value = "longtitude", required = true) Double longtitude,
			@RequestParam(value = "fireRate", required = true) Integer fireRate) {
		if(!"password".equals(hashName)){
			return false;
		}
		Fire fire = new Fire(0,0,fireRate,  latitude, longtitude,new Date());
		arrayList.add(fire);
		return true;
	}
	@RequestMapping(value="/fire/get",method={RequestMethod.POST,RequestMethod.GET})
	public ArrayList<Fire> getCoordinate(@RequestParam(value = "hashName", required = true) String hashName,
			@RequestParam(value = "timeFrom", required = false) @DateTimeFormat(pattern="EEE MMM dd HH:mm:ss ZZZZ yyyy") Date timeFrom) 
	// date format string https://www.ibm.com/support/knowledgecenter/SSMKHH_9.0.0/com.ibm.etools.mft.doc/ak05616_.htm
	{
		if(!"password".equals(hashName)){
			return null;
		}
		if(timeFrom==null){
			return arrayList;	
		}
		ArrayList<Fire>temp=new ArrayList<Fire>();
		for(Fire f:arrayList){
			if(f.getDate().compareTo( timeFrom)<0){
				temp.add(f);
			}
		}
		return temp;
	}
	@RequestMapping(value="/fire/set_",method=RequestMethod.POST)
	public Boolean setCoordinate(
			@RequestBody Fire fire,@RequestParam("hashName") String hashName){
		if(!"password".equals(hashName)){
			return false;
		}
		arrayList.add(fire);
		return true;
	}

}

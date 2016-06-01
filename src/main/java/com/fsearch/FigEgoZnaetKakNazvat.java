package com.fsearch;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class FigEgoZnaetKakNazvat {
   ArrayList arayToFig=new ArrayList<>();
	@RequestMapping("/figZnaet/set")
	public Boolean FigZnaet(
			@RequestParam(value = "Coordinate", required = true) Coordinates coordinate,
			@RequestParam(value = "hashName", required = true) String hashName) {
		if(!hashName.equals("password")){
			return false;
		}
		arayToFig.add(1,coordinate);
		return true;
	}
	@RequestMapping("/fire/get")
	public ArrayList getCoordinate(@RequestParam(value = "hashName", required = true) String hashName) {
		if(!hashName.equals("password")){
			return null;
		}
		return arayToFig;
	}
}

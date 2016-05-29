package com.fsearch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Coordinates {
	
	@RequestMapping("/")
	public String index() { 
		
		return "Fsearch server alive!!!";
	}
	@RequestMapping("/coordinates")
	public String setCoordinate(@RequestParam(value="altitude", required=true) String	altitude) {
		return altitude;
	}
}

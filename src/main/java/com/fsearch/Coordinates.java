package com.fsearch;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Coordinates extends HttpServlet {
	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		int i=0;
		return "hello world";
	}
}

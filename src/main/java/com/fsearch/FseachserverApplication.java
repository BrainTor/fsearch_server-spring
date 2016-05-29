package com.fsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan
@SpringBootApplication
public class FseachserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FseachserverApplication.class, args);
	}
}

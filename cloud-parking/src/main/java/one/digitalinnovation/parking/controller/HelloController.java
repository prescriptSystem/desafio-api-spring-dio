package one.digitalinnovation.parking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RequestMapping("/")
@RestController
public class HelloController {
	
	@GetMapping
	public String hello() 
	{
		return "Hello Dio";
	}

}

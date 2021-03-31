package com.baz.microservicios.rest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NotificacionController {
	
	
	@GetMapping("/prueba")
	public String prueba(){
		return "shsbhs";
	}

}

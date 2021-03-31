package com.baz.microservicios.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceNotificacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceNotificacionesApplication.class, args);
	}

}

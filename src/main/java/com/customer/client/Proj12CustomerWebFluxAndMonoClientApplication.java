package com.customer.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.customer.client.service.CustomerWebFluxAndMonoService;

@SpringBootApplication
public class Proj12CustomerWebFluxAndMonoClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Proj12CustomerWebFluxAndMonoClientApplication.class, args);
		CustomerWebFluxAndMonoService service = context.getBean(CustomerWebFluxAndMonoService.class);
		//service.invokeCustomerEvent();
		System.out.println("----------------------------------------------------------");
		service.invokeCustomerEvents();
		
		
	}

}

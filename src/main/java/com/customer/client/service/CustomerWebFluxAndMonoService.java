package com.customer.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.customer.client.constants.AppConstants;
import com.customer.client.model.CustomerEvent;
import com.customer.client.properties.AppProperties;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerWebFluxAndMonoService {

	@Autowired
	private AppProperties props;

	public final static String GET_CUSTOMER_EVENT = "http://localhost:8080/customerEvent";
	public final static String GET_CUSTOMER_EVENTS = "http://localhost:8080/customerEvents";

	@Autowired
	private WebClient client;

	public void invokeCustomerEvent() {

		String eventUrl = props.getMessages().get(AppConstants.EVENTURL);

		CustomerEvent event = client.get().uri(eventUrl).retrieve().bodyToMono(CustomerEvent.class).block();
		System.out.println(event);

	}

	public void invokeCustomerEvents() {
		String eventsUrl = props.getMessages().get(AppConstants.EVENTSURL);

		client.get().uri(eventsUrl).retrieve().bodyToFlux(CustomerEvent.class).subscribe(System.out::println);

	}

}

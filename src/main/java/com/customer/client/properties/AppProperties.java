package com.customer.client.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "web-client")
@Data
public class AppProperties {
	
	private Map<String,String> messages=new HashMap<>();

}

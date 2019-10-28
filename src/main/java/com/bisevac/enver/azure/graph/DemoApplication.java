package com.bisevac.enver.azure.graph;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {
	@Autowired
    private RestTemplate restTemplate;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restTemplate.getForEntity("https://graph.microsoft.com/v1.0/users", ResponseDTO.class);
		restTemplate.getForEntity("https://graph.microsoft.com/v1.0/users", ResponseDTO.class);
	}

}

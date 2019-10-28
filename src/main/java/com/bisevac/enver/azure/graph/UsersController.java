package com.bisevac.enver.azure.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UsersController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public ResponseEntity<Void> test() {
        restTemplate.getForEntity("https://graph.microsoft.com/v1.0/users", ResponseDTO.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
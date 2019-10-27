package com.bisevac.enver.azure.graph;

import java.util.Collections;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Scope("singleton")
@Slf4j
public class AuthService implements APIConfiguration {


    public static String getToken() {
        log.info("get restTemplate");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        log.info("create headers");
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //
        // create a map for post parameters
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", "client_id");
        map.add("scope", GRAPH_DEFAULT_SCOPE);
        map.add("client_secret", "client_secret");
        map.add("grant_type", "client_credentials");

        log.info("set Accept header");
        // headers.setAccept(Collections.singletonList(MediaType.APPLICATION_FORM_URLENCODED));

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        log.info("set Url");
        String url = String.format(GRAPH_API_LOGIN_URL, "tenant_id");
        log.info("URL " + url);
        log.info("Headers" + entity.getBody().toString());
        ResponseEntity<AuthResponseDTO> response = restTemplate.postForEntity(url, entity, AuthResponseDTO.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            log.info("Token generated");
            return String.format("%s %s", response.getBody().getTokenType(), response.getBody().getAccessToken());
        }

        return null;
    }

}
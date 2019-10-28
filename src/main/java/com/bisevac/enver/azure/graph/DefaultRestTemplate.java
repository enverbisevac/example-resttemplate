package com.bisevac.enver.azure.graph;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DefaultRestTemplate {
    @Autowired
    private HttpComponentsClientHttpRequestFactory factory;

    @Autowired
    private AuthService authService;

    @Bean
    public RestTemplate getRestTemplate() {
        log.info("restTemplate bean");
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(factory));
        // restTemplate.setMessageConverters(Collections.singletonList(mappingJacksonHttpMessageConverter()));

        // this should be changed depends on cloud provider
        // AzureExample Authorization: Bearer token
        List<ClientHttpRequestInterceptor> interceptors
          = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new RequestResponseLoggingInterceptor());
        interceptors.add(new InjectTokenInterceptor("Authorization", authService.getToken()));
        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }
}
package com.bisevac.enver.azure.graph;

import java.io.IOException;

import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class InjectTokenInterceptor implements ClientHttpRequestInterceptor {
    private String tokenField;
    private String tokenValue;

    
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
            ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add(tokenField, tokenValue);
        request.getHeaders().add(HTTP.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }
}
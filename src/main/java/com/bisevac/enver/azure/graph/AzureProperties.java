package com.bisevac.enver.azure.graph;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("azure.sp.auth")
public class AzureProperties {
    private String tenantId;
    private String clientId;
    private String secretKey;
}

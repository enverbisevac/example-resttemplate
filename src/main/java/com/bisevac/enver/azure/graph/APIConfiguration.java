package com.bisevac.enver.azure.graph;

public interface APIConfiguration {
    static final String GRAPH_API_LOGIN_URL = "https://login.microsoftonline.com/%s/oauth2/v2.0/token";
    static final String GRAPH_API_BASE_URL = "";

    static final String GRAPH_DEFAULT_SCOPE = "https://graph.microsoft.com/.default";
}
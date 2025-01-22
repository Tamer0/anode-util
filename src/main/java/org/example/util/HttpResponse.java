package org.example.util;

import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
public class HttpResponse {
    int statusCode;
    String body;
    Map<String, String> headers;
    
    public boolean isSuccessful() {
        return statusCode >= 200 && statusCode < 300;
    }
} 
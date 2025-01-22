package org.example.exception;

import lombok.Getter;

@Getter
public class HttpRequestException extends RuntimeException {
    private final int statusCode;
    private final String responseBody;
    
    public HttpRequestException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }
    
    public HttpRequestException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = 0;
        this.responseBody = null;
    }
} 
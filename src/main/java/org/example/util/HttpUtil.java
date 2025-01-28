package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.constants.Enums;
import org.example.exception.HttpRequestException;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class HttpUtil {
    private static final int CONNECT_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 30000;
    private static Logger logger = Logger.getLogger(HttpUtil.class.getName());
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static HttpResponse sendRequest(String url,
                                         Enums.HttpMethod method,
                                         Map<String, String> headers, 
                                         Object body, Enums.ContentType contentType) {
        try {

            String jsonBody = objectMapper.writeValueAsString(body);

            HttpURLConnection connection = createConnection(url, method, headers, contentType);
            
            if (jsonBody != null && method != Enums.HttpMethod.GET) {
                writeRequestBody(connection, jsonBody, contentType);
            }
            
            return readResponse(connection);
        } catch (IOException e) {
            throw new HttpRequestException("Failed to execute HTTP request", e);
        }
    }
    
    private static HttpURLConnection createConnection(String url, 
                                                    Enums.HttpMethod method,
                                                    Map<String, String> headers,
                                                      Enums.ContentType contentType) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method.name());
        connection.setConnectTimeout(CONNECT_TIMEOUT);
        connection.setReadTimeout(READ_TIMEOUT);
        
        // Set default headers
        connection.setRequestProperty("Accept", "*/*");
        if (contentType != null) {
            connection.setRequestProperty("Content-Type", contentType.getValue());
        }
        
        // Set custom headers
        if (headers != null) {
            headers.forEach(connection::setRequestProperty);
        }
        
        if (method != Enums.HttpMethod.GET) {
            connection.setDoOutput(true);
        }
        
        return connection;
    }
    
    private static void writeRequestBody(HttpURLConnection connection, 
                                       Object body,
                                         Enums.ContentType contentType) throws IOException {
        Map<String, Object> parsedBody = RequestBodyParser.parseRequestBody(body, contentType);
        String bodyStr = convertBodyToString(parsedBody, contentType);
        
        try (OutputStream os = connection.getOutputStream()) {
            os.write(bodyStr.getBytes(StandardCharsets.UTF_8));
            os.flush();
        }
    }
    
    private static String convertBodyToString(Map<String, Object> body, Enums.ContentType type) {

        if (type == null || type == Enums.ContentType.TEXT_PLAIN) {
            return body.getOrDefault("rawText", "").toString();
        }
        switch (type) {
            case JSON:
                return JsonUtil.toJson(body);
            case FORM_URLENCODED:
                return body.entrySet().stream()
                    .map(e -> e.getKey() + "=" + e.getValue())
                    .collect(Collectors.joining("&"));
            default:
                throw new IllegalArgumentException("Unsupported content type: " + type);
        }
    }
    
    private static HttpResponse readResponse(HttpURLConnection connection) throws IOException {
        int statusCode = connection.getResponseCode();
        Map<String, String> responseHeaders = new HashMap<>();
        
        // Read response headers
        connection.getHeaderFields().forEach((key, values) -> {
            if (key != null && !values.isEmpty()) {
                responseHeaders.put(key, values.get(0));
            }
        });
        
        // Read response body
        String responseBody = null;
        try {
            if (statusCode < 400) {
                responseBody = readStream(connection.getInputStream());
            } else {
                responseBody = readStream(connection.getErrorStream());
            }
        } catch (IOException e) {
            logger.info("Failed to read response body");
        }
        
        HttpResponse response = HttpResponse.builder()
            .statusCode(statusCode)
            .headers(responseHeaders)
            .body(responseBody)
            .build();
            
        if (!response.isSuccessful()) {
            throw new HttpRequestException(
                "Request failed with status " + statusCode,
                statusCode,
                responseBody
            );
        }
        
        return response;
    }
    
    private static String readStream(java.io.InputStream is) throws IOException {
        if (is == null) return null;
        
        try (java.io.BufferedReader br = new java.io.BufferedReader(
                new java.io.InputStreamReader(is, StandardCharsets.UTF_8))) {
            return br.lines().collect(Collectors.joining("\n"));
        }
    }
} 
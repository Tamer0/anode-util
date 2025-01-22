package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.constants.Enums;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class RequestBodyParser {
    
    public static Map<String, Object> parseRequestBody(Object body, Enums.ContentType contentType) {
        if (body == null) {
            return Collections.emptyMap();
        }
        
        if (body instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) body;
            return map;
        }
        
        Enums.ContentType type = Enums.ContentType.fromString(contentType.getValue());
        if (type == null) {
            return Collections.singletonMap("rawText", body.toString());
        }
        
        switch (type) {
            case JSON:
                return parseJsonBody(body);
            case FORM_URLENCODED:
                return parseFormUrlEncodedBody(body.toString());
            case TEXT_PLAIN:
                return Collections.singletonMap("rawText", body.toString());
            default:
                throw new IllegalArgumentException("Unsupported content type: " + contentType);
        }
    }
    
    private static Map<String, Object> parseJsonBody(Object body) {
        if (body instanceof String) {
            return JsonUtil.fromJson((String) body, Map.class);
        }
        return (Map<String, Object>) body;
    }
    
    private static Map<String, Object> parseFormUrlEncodedBody(String body) {
        if (body == null || body.trim().isEmpty()) {
            return Collections.emptyMap();
        }
        
        return Arrays.stream(body.split("&"))
            .filter(param -> param != null && !param.trim().isEmpty())
            .map(param -> param.split("=", 2))
            .collect(Collectors.toMap(
                pair -> decodeUrlComponent(pair[0]),
                pair -> pair.length > 1 ? decodeUrlComponent(pair[1]) : "",
                (existing, replacement) -> existing, // Keep first value on duplicate keys
                HashMap::new
            ));
    }

    
    private static String decodeUrlComponent(String component) {
        try {
            return URLDecoder.decode(component, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 encoding not supported", e);
        }
    }
} 
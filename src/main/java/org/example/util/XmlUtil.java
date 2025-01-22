package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.Map;

public class XmlUtil {
    private static final ObjectMapper xmlMapper = new XmlMapper();
    
    public static Map<String, Object> xmlToMap(String xml) {
        try {
            return xmlMapper.readValue(xml, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse XML", e);
        }
    }
    
    public static String mapToXml(Map<String, Object> map) {
        try {
            return xmlMapper.writeValueAsString(map);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert map to XML", e);
        }
    }
} 
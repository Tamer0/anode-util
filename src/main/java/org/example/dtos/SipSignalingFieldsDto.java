package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SipSignalingFieldsDto {

    /** required: ["correlator","localIpAddress","localPort","remoteIpAddress","remotePort","sipSignalingFieldsVersion"] */

    private String correlator;


    private String localIpAddress;


    private Integer localPort;


    private String remoteIpAddress;


    private Integer remotePort;


    private Double sipSignalingFieldsVersion;

    private String summarySip;

    /** vendorNfNameFields: Boş obje => Map */
    private Map<String, Object> vendorNfNameFields = new HashMap<>();
}

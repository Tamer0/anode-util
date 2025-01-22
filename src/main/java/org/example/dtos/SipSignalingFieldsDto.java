package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SipSignalingFieldsDto {

    /** required: ["correlator","localIpAddress","localPort","remoteIpAddress","remotePort","sipSignalingFieldsVersion"] */
    @NotNull
    private String correlator;

    @NotNull
    private String localIpAddress;

    @NotNull
    private Integer localPort;

    @NotNull
    private String remoteIpAddress;

    @NotNull
    private Integer remotePort;

    @NotNull
    private Double sipSignalingFieldsVersion;

    private String summarySip;

    /** vendorNfNameFields: Boş obje => Map */
    private Map<String, Object> vendorNfNameFields = new HashMap<>();
}

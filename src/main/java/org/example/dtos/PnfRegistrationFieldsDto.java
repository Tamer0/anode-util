package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PnfRegistrationFieldsDto {

    private Map<String, String> additionalFields = new HashMap<>();
    private String lastServiceDate;
    private String macAddress;
    private String manufactureDate;

    /** required: ["modelNumber","pNFRegistrationFieldsVersion","serialNumber","vendorName"] */

    @NotNull
    private String modelNumber;

    private String oamV4IpAddress;
    private String oamV6IpAddress;

    @NotNull
    private Double pNFRegistrationFieldsVersion;

    @NotNull
    private String serialNumber;
    private String softwareVersion;
    private String unitFamily;
    private String unitType;

    @NotNull
    private String vendorName;
}

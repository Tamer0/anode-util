package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeartbeatFieldsDto {

    private Map<String, String> additionalFields = new HashMap<>();

    /** required: ["heartbeatFieldsVersion"] */
    @NotNull
    private Double heartbeatFieldsVersion;
}

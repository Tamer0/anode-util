package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OtherFieldsDto {

    /** required: ["otherFieldsVersion"] */
    @NotNull
    private Double otherFieldsVersion;

    private Map<String, String> hashMap;
}

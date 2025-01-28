package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OtherFieldsDto {

    /** required: ["otherFieldsVersion"] */

    private Double otherFieldsVersion;

    private Map<String, String> hashMap;
}

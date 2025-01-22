package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.constants.Enums;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class FaultFieldsDto {

    private Map<String, String> alarmAdditionalInformation;

    /** required: ["alarmCondition","eventSeverity","eventSourceType","faultFieldsVersion","specificProblem"] */
    @NotNull
    private String alarmCondition;

    private String alarmInterfaceA;
    private String eventCategory;

    @NotNull
    private Enums.EventSeverity eventSeverity;

    @NotNull
    private String eventSourceType;

    @NotNull
    private Double faultFieldsVersion;

    @NotNull
    private String specificProblem;

    private String vfStatus;
}

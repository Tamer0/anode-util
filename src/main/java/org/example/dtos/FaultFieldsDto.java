package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.constants.Enums;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class FaultFieldsDto {

    private Map<String, String> alarmAdditionalInformation;


    private String alarmCondition;

    private String alarmInterfaceA;

    private String eventCategory;

    private Enums.EventSeverity eventSeverity;

    private String eventSourceType;

    private String faultFieldsVersion;

    private String specificProblem;

    private String vfStatus;
}

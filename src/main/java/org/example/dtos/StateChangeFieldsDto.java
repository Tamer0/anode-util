package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StateChangeFieldsDto {

    /** required: ["stateChangeFieldsVersion","newState","oldState","stateInterface"] */
    private Double stateChangeFieldsVersion;

    private String newState;

    private String oldState;

    private String stateInterface;
}

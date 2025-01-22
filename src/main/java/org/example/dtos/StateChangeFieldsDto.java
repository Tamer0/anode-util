package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StateChangeFieldsDto {

    /** required: ["stateChangeFieldsVersion","newState","oldState","stateInterface"] */
    @NotNull
    private Double stateChangeFieldsVersion;

    @NotNull
    private String newState;

    @NotNull
    private String oldState;

    @NotNull
    private String stateInterface;
}

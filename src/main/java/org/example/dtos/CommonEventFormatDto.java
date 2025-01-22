package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.dtos.EventDto;
import org.jetbrains.annotations.NotNull;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonEventFormatDto {

    @NotNull
    private EventDto event;
}

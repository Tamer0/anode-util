package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.constants.Enums;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class CommonEventHeaderDto {

    /** required: ["domain","eventId","eventName","lastEpochMicrosec","priority",
     *            "reportingEntityName","sequence","sourceName","startEpochMicrosec",
     *            "version","vesEventListenerVersion"]
     **/
    @NotNull
    private Enums.Domain domain;

    @NotNull
    private String eventId;

    @NotNull
    private String eventName;

    @NotNull
    private Double lastEpochMicrosec;

    @NotNull
    private Enums.Priority priority;

    @NotNull
    private String reportingEntityName;

    @NotNull
    private Integer sequence;

    @NotNull
    private String sourceName;

    @NotNull
    private Double startEpochMicrosec;

    @NotNull
    private Double version;

    @NotNull
    private String vesEventListenerVersion;

    /** opsiyonel */
    private String timeZoneOffset;

}

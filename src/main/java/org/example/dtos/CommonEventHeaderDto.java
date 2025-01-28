package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class CommonEventHeaderDto {

    /** required: ["domain","eventId","eventName","lastEpochMicrosec","priority",
     *            "reportingEntityName","sequence","sourceName","startEpochMicrosec",
     *            "version","vesEventListenerVersion"]
     **/

    private String domain;


    private String eventId;


    private String eventName;


    private Double lastEpochMicrosec;


    private String priority;


    private String reportingEntityName;


    private Integer sequence;


    private String sourceName;


    private Double startEpochMicrosec;


    private String version;


    private String vesEventListenerVersion;

    private String eventType;

    /** opsiyonel */
    private String timeZoneOffset;

}

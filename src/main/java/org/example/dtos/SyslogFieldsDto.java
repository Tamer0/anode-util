package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SyslogFieldsDto {

    /** required: ["syslogFieldsVersion","syslogMsg"] */
    @NotNull
    private Double syslogFieldsVersion;

    private String eventSourceType;
    private String syslogTag;

    @NotNull
    private String syslogMsg;

    private String syslogMsgHost;
    private String syslogFacility;
    private String syslogPriority;
    private String syslogSeverity;
    private String syslogProc;
    private String syslogProcId;
    private String syslogVer;
    private String syslogMsgId;

    /** patternProperties => Map<String, Object> */
    private Map<String, Object> syslogSdParams = new HashMap<>();

    private Map<String, String> additionalFields = new HashMap<>();
}

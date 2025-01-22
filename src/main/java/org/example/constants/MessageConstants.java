package org.example.constants;

import java.util.Map;

public final class MessageConstants {
    private MessageConstants() {}
    
    // Validation Messages
    public static final String REQUIRED_FIELD = "%s is required";
    public static final String INVALID_IP = "Invalid IP address format";
    public static final String INVALID_PORT = "Port must be between 0 and 65535";
    
    // Success Messages
    public static final String CREATED_SUCCESS = "%s created successfully";
    public static final String UPDATED_SUCCESS = "%s updated successfully";
    public static final String DELETED_SUCCESS = "%s deleted successfully";

    // VES Fields
    public static final String RRP_host = "host";
    public static final String RRP_port = "port";
    public static final String RRP_domain = "domain";
    public static final String RRP_eventId = "eventId";
    public static final String RRP_eventName = "eventName";
    public static final String RRP_eventType = "eventType";
    public static final String RRP_lastEpochMicrosec = "lastEpochMicrosec";
    public static final String RRP_nfcNamingCode = "nfcNamingCode";
    public static final String RRP_nfNamingCode = "nfNamingCode";
    public static final String RRP_nfVendorName = "nfVendorName";
    public static final String RRP_priority = "priority";
    public static final String RRP_reportingEntityId = "reportingEntityId";
    public static final String RRP_reportingEntityName = "reportingEntityName";
    public static final String RRP_sequence = "sequence";
    public static final String RRP_sourceId = "sourceId";
    public static final String RRP_sourceName = "sourceName";
    public static final String RRP_startEpochMicrosec = "startEpochMicrosec";
    public static final String RRP_timeZoneOffset = "timeZoneOffset";
    public static final String RRP_version = "version";
    public static final String RRP_vesEventListenerVersion = "vesEventListenerVersion";
    public static final String RRP_alarmAdditionalInformation = "alarmAdditionalInformation";
    public static final String RRP_alarmCondition = "alarmCondition";
    public static final String RRP_alarmInterfaceA = "alarmInterfaceA";
    public static final String RRP_eventCategory = "eventCategory";
    public static final String RRP_eventSeverity = "eventSeverity";
    public static final String RRP_eventSourceType = "eventSourceType";
    public static final String RRP_faultFieldsVersion = "faultFieldsVersion";
    public static final String RRP_specificProblem = "specificProblem";
    public static final String RRP_vfStatus = "vfStatus";

} 
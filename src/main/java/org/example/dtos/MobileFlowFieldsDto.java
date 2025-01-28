package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.constants.Enums;
import org.jetbrains.annotations.NotNull;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MobileFlowFieldsDto {

    /** required: ["mobileFlowFieldsVersion"] */
    
    private Double mobileFlowFieldsVersion;

    private Map<String, String> additionalFields = new HashMap<>();

    private List<MobileFlowFieldsArrayItemDto> arrayOfMobileFlowFields;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class MobileFlowFieldsArrayItemDto {

        /** required: ["flowDirection","flowRole","ipProtocolType","gtpConnectionType",
         *             "gtpProtocolType","gtpVersion","ipVersion","otherEndpoints",
         *             "flowActivationEpochMicrosec","flowActivationTime","flowDeactivationEpochMicrosec",
         *             "flowDeactivationTime","flowEndEpochMicrosec","flowEndTime",
         *             "flowStartEpochMicrosec","flowStartTime"]
         */

        
        private Enums.FlowDirection flowDirection;

        
        private Enums.FlowRole flowRole;

        
        private Enums.IpProtocolType ipProtocolType;

        
        private Enums.GtpConnectionType gtpConnectionType;

        
        private Enums.GtpProtocolType gtpProtocolType;

        
        private Enums.GtpVersion gtpVersion;

        
        private Enums.IpVersion ipVersion;

        
        private List<String> otherEndpoints;

        
        private Double flowActivationEpochMicrosec;

        
        private String flowActivationTime;

        
        private Double flowDeactivationEpochMicrosec;

        
        private String flowDeactivationTime;

        
        private Double flowEndEpochMicrosec;

        
        private String flowEndTime;
        
        private Double flowStartEpochMicrosec;
        
        private String flowStartTime;

        // Opsiyoneller
        private Double confidenceFactor;
        private Map<String, String> httpHeader = new HashMap<>();
        private String imei;
        private String imsi;
        private String lac;
        private String mcc;
        private String mnc;
        private String msisdn;
        private String radioAccessTechnology;
        private String rac;
        private String sac;
        private Enums.SamplingAlgorithm samplingAlgorithm;
        private String tac;
        private String endpointIpv4Address;
        private String endpointIpv6Address;
        private String escapedUsername;
        private Integer largePacketRtt;
        private Integer largePacketThreshold;
        private Integer midPacketRtt;
        private Integer mobileQciCos;
        private Integer numActivation;
        private Integer numActiveSeconds;
        private Integer numAlerts;
        private Integer numBytesReceived;
        private Integer numBytesSent;
        private Integer numDlThptSamples;
        private Integer numFlowTimeouts;
        private Integer numHttpErrors;
        private Integer numMessagesReceived;
        private Integer numMessagesSent;
        private Integer numPktsLost;
        private Integer numPktsReceived;
        private Integer numPktsRetransmitted;
        private Integer numPktsSent;
        private Integer numUlThptSamples;
        private Integer roundTripDelay;
        private Integer rxSessionDrop;
        private String theFlowType;
        private Integer thptMeasurementInterval;
        private Integer transactionTime;
        private Integer txSessionDrop;
    }
}

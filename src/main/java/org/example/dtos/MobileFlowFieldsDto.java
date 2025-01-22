package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.constants.Enums;
import org.jetbrains.annotations.NotNull;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MobileFlowFieldsDto {

    /** required: ["mobileFlowFieldsVersion"] */
    @NotNull
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

        @NotNull
        private Enums.FlowDirection flowDirection;

        @NotNull
        private Enums.FlowRole flowRole;

        @NotNull
        private Enums.IpProtocolType ipProtocolType;

        @NotNull
        private Enums.GtpConnectionType gtpConnectionType;

        @NotNull
        private Enums.GtpProtocolType gtpProtocolType;

        @NotNull
        private Enums.GtpVersion gtpVersion;

        @NotNull
        private Enums.IpVersion ipVersion;

        @NotNull
        private List<String> otherEndpoints;

        @NotNull
        private Double flowActivationEpochMicrosec;

        @NotNull
        private String flowActivationTime;

        @NotNull
        private Double flowDeactivationEpochMicrosec;

        @NotNull
        private String flowDeactivationTime;

        @NotNull
        private Double flowEndEpochMicrosec;

        @NotNull
        private String flowEndTime;

        @NotNull
        private Double flowStartEpochMicrosec;

        @NotNull
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

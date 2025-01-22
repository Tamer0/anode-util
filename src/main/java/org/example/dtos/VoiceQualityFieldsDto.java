package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoiceQualityFieldsDto {

    /**
     * required: [
     *   "voiceQualityFieldsVersion","endpointDescription","endpointRef","adjacentAccessPointMac",
     *   "meanOpinionScore","packetLossRate","sessionDuration","sessionStartTime",
     *   "sessionEndTime","sipCallId"
     * ]
     */
    @NotNull
    private Double voiceQualityFieldsVersion;

    @NotNull
    private String endpointDescription;

    @NotNull
    private String endpointRef;

    @NotNull
    private String adjacentAccessPointMac;

    @NotNull
    private Double meanOpinionScore;

    @NotNull
    private Double packetLossRate;

    @NotNull
    private Integer sessionDuration;

    @NotNull
    private String sessionStartTime;

    @NotNull
    private String sessionEndTime;

    @NotNull
    private String sipCallId;

    // Opsiyoneller
    private Double counterInterval;
    private List<String> exceededThreshold;
    private Double jitterBufferDiscardRate;
    private Double packetLossDiscardRate;
    private String rcode;
    private Double roundTripDelay;
    private Double rxOctets;
    private Double rxPackets;
    private String rxSessionReleaseCause;
    private String configParam;
    private String codec;
    private String phoneNumber;

    /** vendorNfNameFields: Boş obje => Map */
    private Map<String, Object> vendorNfNameFields = new HashMap<>();

    private Double txOctets;
    private Double txPackets;
    private String txSessionReleaseCause;
    private String adjacentCellId;
    private String connectionType;
    private String eutraCellId;
    private String lacId;
    private String locationAreaCode;
    private String mcc;
    private String mnc;
    private String rac;
    private String radioConnectionId;
    private String sac;
    private String serviceProvider;
}

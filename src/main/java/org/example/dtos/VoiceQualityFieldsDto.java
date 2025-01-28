package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VoiceQualityFieldsDto {

    /**
     * required: [
     *   "voiceQualityFieldsVersion","endpointDescription","endpointRef","adjacentAccessPointMac",
     *   "meanOpinionScore","packetLossRate","sessionDuration","sessionStartTime",
     *   "sessionEndTime","sipCallId"
     * ]
     */

    private Double voiceQualityFieldsVersion;


    private String endpointDescription;


    private String endpointRef;


    private String adjacentAccessPointMac;


    private Double meanOpinionScore;


    private Double packetLossRate;


    private Integer sessionDuration;


    private String sessionStartTime;


    private String sessionEndTime;


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

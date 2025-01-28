package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ThresholdCrossingAlertFieldsDto {

    /** required: [
     *   "thresholdCrossingAlertFieldsVersion","alertAction","alertType","eventName","thresholdCrossingFieldsVersion"
     * ]
     */

    private Double thresholdCrossingAlertFieldsVersion;

    private Map<String, String> additionalParameters = new HashMap<>();


    private String alertAction; // Örnek: "CLEAR" / "SET" (enum olabilir)

    private String alertDescription;


    private String alertType;   // enum olabilir

    private Double collectionTimestamp;
    private List<String> embeddedAlertMessage;


    private String eventName;

    private String interfaceName;
    private String networkService;
    private String possibleRootCause;
    private String reportingEntity;
    private Integer sequence;
    private String sourceId;
    private String sourceIdType;


    private Double thresholdCrossingFieldsVersion;

    /** thresholdCrossingFieldsContent => Map */
    private Map<String, Object> thresholdCrossingFieldsContent = new HashMap<>();

    private String vfStatus;
}

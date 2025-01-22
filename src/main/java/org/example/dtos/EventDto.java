package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class EventDto {

    /** Şemada "required": ["commonEventHeader"] */
    @NotNull
    private CommonEventHeaderDto commonEventHeader;

    /** comStnFields: Boş obje => Map kullanıyoruz */
    private Map<String, Object> comStnFields = new HashMap<>();

    /** dataCollectionFields: Boş obje => Map */
    private Map<String, Object> dataCollectionFields = new HashMap<>();

    private FaultFieldsDto faultFields;

    /** hbnameFields: Boş obje => Map */
    private Map<String, Object> hbnameFields = new HashMap<>();

    private HeartbeatFieldsDto heartbeatFields;

    /** measurementFields: Boş obje => Map */
    private Map<String, Object> measurementFields = new HashMap<>();

    private MeasurementsForVfScalingFieldsDto measurementsForVfScalingFields;
    private MobileFlowFieldsDto mobileFlowFields;
    private NotificationFieldsDto notificationFields;
    private OtherFieldsDto otherFields;
    private PnfRegistrationFieldsDto pnfRegistrationFields;

    /** registrationFields: Boş obje => Map */
    private Map<String, Object> registrationFields = new HashMap<>();

    private SipSignalingFieldsDto sipSignalingFields;

    /** snmpTrapFields: Boş obje => Map */
    private Map<String, Object> snmpTrapFields = new HashMap<>();

    private StateChangeFieldsDto stateChangeFields;
    private SyslogFieldsDto syslogFields;
    private ThresholdCrossingAlertFieldsDto thresholdCrossingAlertFields;
    private VoiceQualityFieldsDto voiceQualityFields;
}

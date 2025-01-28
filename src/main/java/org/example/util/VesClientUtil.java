package org.example.util;

import org.example.constants.Enums;
import org.example.dtos.CommonEventFormatDto;
import org.example.dtos.CommonEventHeaderDto;
import org.example.dtos.EventDto;
import org.example.dtos.FaultFieldsDto;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.example.constants.MessageConstants.*;

public class VesClientUtil {

    private static final Map<String, AtomicInteger> COUNTERS = new ConcurrentHashMap<>();
    private static final String VES_URL_ENDPOINT = "/eventListener/v7";

    /**
     * Ana metod: Oluşturulmuş CommonEventFormatDto'yu VES'e gönderir.
     */
    public static void sendEvent(CommonEventFormatDto commonEventFormatDto, String hostname, String port) {
        try {
            HttpUtil.sendRequest(
                    getVesUrl(hostname, port),
                    Enums.HttpMethod.POST,
                    null,
                    commonEventFormatDto,
                    Enums.ContentType.JSON
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Fault Event oluşturan yardımcı metod.
     * eventMap içindeki gerekli verileri çekip bir "CommonEventFormatDto" inşa eder, sonra VES'e gönderir.
     */
    public static void createFaultEvent(Map<String, Object> eventMap) {
        // 1) Zorunlu alanları kontrol et (Bu alanlar yoksa alarm oluşturamayız)
        validateMandatoryField(eventMap, RRP_eventId);
        validateMandatoryField(eventMap, RRP_eventName);
        validateMandatoryField(eventMap, RRP_eventSeverity);
        validateMandatoryField(eventMap, RRP_specificProblem);
        validateMandatoryField(eventMap, RRP_host);   // VES'e nereye göndereceğiz?
        validateMandatoryField(eventMap, RRP_port);

        // 2) FaultFieldsDto oluştur
        FaultFieldsDto faultFieldsDto = new FaultFieldsDto();

        // - alarmCondition (zorunlu bir VES alanı, senaryoya göre)
        validateMandatoryField(eventMap, RRP_alarmCondition);
        faultFieldsDto.setAlarmCondition(eventMap.get(RRP_alarmCondition).toString());

        // - eventSeverity (örnek: "CRITICAL", "MAJOR", "MINOR" vb.) -> Enum'a parse
        Enums.EventSeverity severity = Enums.EventSeverity.valueOf(eventMap.get(RRP_eventSeverity).toString());
        faultFieldsDto.setEventSeverity(severity);

        // - eventSourceType default "application"
        faultFieldsDto.setEventSourceType(eventMap.getOrDefault(RRP_eventSourceType, "application").toString());

        // - vfStatus default "Active"
        faultFieldsDto.setVfStatus(eventMap.getOrDefault(RRP_vfStatus, "Active").toString());

        // - faultFieldsVersion default 4.0
        String faultVersion = eventMap.getOrDefault(RRP_faultFieldsVersion, "4.0").toString();
        faultFieldsDto.setFaultFieldsVersion(faultVersion);

        // - specificProblem (zorunlu)
        faultFieldsDto.setSpecificProblem(eventMap.get(RRP_specificProblem).toString());

        // Opsiyonel alanlar
        if (eventMap.get(RRP_alarmAdditionalInformation) != null) {
            faultFieldsDto.setAlarmAdditionalInformation(
                    (Map<String, String>) eventMap.get(RRP_alarmAdditionalInformation)
            );
        }
        if (eventMap.get(RRP_alarmInterfaceA) != null) {
            faultFieldsDto.setAlarmInterfaceA(eventMap.get(RRP_alarmInterfaceA).toString());
        }
        if (eventMap.get(RRP_eventCategory) != null) {
            faultFieldsDto.setEventCategory(eventMap.get(RRP_eventCategory).toString());
        }

        // 3) CommonEventHeaderDto oluştur (domain=FAULT)
        CommonEventHeaderDto commonEventHeaderDto = getCommonEventHeaderDto(eventMap, Enums.Domain.FAULT);

        // 4) EventDto oluştur
        EventDto eventDto = new EventDto();
        eventDto.setCommonEventHeader(commonEventHeaderDto);
        eventDto.setFaultFields(faultFieldsDto);

        // 5) CommonEventFormatDto oluştur
        CommonEventFormatDto commonEventFormatDto = new CommonEventFormatDto(eventDto);

        // 6) VES'e gönder
        sendEvent(
                commonEventFormatDto,
                eventMap.get(RRP_host).toString(),
                eventMap.get(RRP_port).toString()
        );
    }

    /**
     * CommonEventHeaderDto'yu dolduran yardımcı metod.
     * domain alanını parametreden alır, geri kalanları eventMap'ten çeker.
     */
    private static CommonEventHeaderDto getCommonEventHeaderDto(Map<String, Object> eventMap, Enums.Domain domain) {
        CommonEventHeaderDto commonEventHeaderDto = new CommonEventHeaderDto();

        // Domain sabit
        commonEventHeaderDto.setDomain(domain.getJsonValue());

        // EventId => her alarmda uniq yapmak için generateEventId
        String rawEventId = eventMap.get(RRP_eventId).toString();
        commonEventHeaderDto.setEventId(generateEventId(rawEventId));

        // EventName
        commonEventHeaderDto.setEventName(eventMap.get(RRP_eventName).toString());

        // lastEpochMicrosec
        commonEventHeaderDto.setLastEpochMicrosec((double) (System.currentTimeMillis() * 1000));

        // priority => Map'ten Priority enum'a parse
        validateMandatoryField(eventMap, RRP_priority); // Kolaylık olsun diye
        Enums.Priority priority = Enums.Priority.valueOf(eventMap.get(RRP_priority).toString());
        commonEventHeaderDto.setPriority(priority.getJsonValue());

        // sequence
        commonEventHeaderDto.setSequence(0);

        // reportingEntityName
        validateMandatoryField(eventMap, RRP_reportingEntityName);
        commonEventHeaderDto.setReportingEntityName(eventMap.get(RRP_reportingEntityName).toString());

        // sourceName
        validateMandatoryField(eventMap, RRP_sourceName);
        commonEventHeaderDto.setSourceName(eventMap.get(RRP_sourceName).toString());

        // startEpochMicrosec
        commonEventHeaderDto.setStartEpochMicrosec((double) (System.currentTimeMillis() * 1000));

        // version => 4.1 sabit
        commonEventHeaderDto.setVersion("4.1");

        // vesEventListenerVersion => 7.1.1 sabit
        commonEventHeaderDto.setVesEventListenerVersion("7.1.1");

        // eventType => varsayılan "Application"
        String evtType = eventMap.getOrDefault(RRP_eventType, "Application").toString();
        commonEventHeaderDto.setEventType(evtType);

        // opsiyonel: timeZoneOffset
        if (eventMap.get(RRP_timeZoneOffset) != null) {
            commonEventHeaderDto.setTimeZoneOffset(eventMap.get(RRP_timeZoneOffset).toString());
        }

        return commonEventHeaderDto;
    }

    /**
     * Her alarm (ya da event) ID'sine artan bir sayı ekleyerek
     * "myEvent-1", "myEvent-2" vb. şekilde benzersiz ID üretir.
     */
    private static String generateEventId(String eventId) {
        AtomicInteger counter = COUNTERS.computeIfAbsent(eventId, k -> new AtomicInteger(1));
        int currentCount = counter.getAndIncrement();
        return eventId + "-" + currentCount;
    }

    /**
     * VES URL'sini oluşturur. Port null ise HTTPS, değilse HTTP varsayılanı vs.
     */
    private static String getVesUrl(String host, String port) {
        if (port == null) {
            return "https://" + host + VES_URL_ENDPOINT;
        }
        return "http://" + host + ":" + port + VES_URL_ENDPOINT;
    }

    /**
     * Map içinden zorunlu alanı kontrol eder. Yoksa IllegalArgumentException fırlatır.
     */
    private static void validateMandatoryField(Map<String, Object> eventMap, String fieldName) {
        if (eventMap.get(fieldName) == null) {
            throw new IllegalArgumentException(
                    "Mandatory field '" + fieldName + "' is missing in eventMap"
            );
        }
    }
}

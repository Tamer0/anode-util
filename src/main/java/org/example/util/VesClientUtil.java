package org.example.util;

import org.example.constants.Enums;
import org.example.dtos.CommonEventFormatDto;
import org.example.dtos.CommonEventHeaderDto;
import org.example.dtos.EventDto;
import org.example.dtos.FaultFieldsDto;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.example.constants.MessageConstants.*;

public class VesClientUtil {
    private static final Map<String, AtomicInteger> COUNTERS = new ConcurrentHashMap<>();

    private static final String VES_URL_ENDPOINT = "/eventListener/v7";

    public static void sendEvent(CommonEventFormatDto commonEventFormatDto, String hostname, String port) {
        try {
            HttpUtil.sendRequest(getVesUrl(hostname, port),
                    Enums.HttpMethod.POST, null, commonEventFormatDto, Enums.ContentType.JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String generateEventId(String eventId) {
        AtomicInteger counter = COUNTERS.computeIfAbsent(eventId, k -> new AtomicInteger(1));
        int currentCount = counter.getAndIncrement();
        return eventId + "-" + currentCount;
    }

    private static String getVesUrl(String host, String port) {
        if (port == null) {
            return "https://" + host + VES_URL_ENDPOINT;
        }
        return "http://" + host + ":" + port + VES_URL_ENDPOINT;
    }

    private static void validateMandatoryField(Map<String, Object> eventMap, String fieldName) {
        if (eventMap.get(fieldName) == null) {
            throw new IllegalArgumentException("Mandatory field " + fieldName + " is missing in eventMap");
        }
    }

    public static void createFaultEvent(Map<String, Object> eventMap) {
        try {
            FaultFieldsDto faultFieldsDto = new FaultFieldsDto();
            faultFieldsDto.setAlarmCondition(eventMap.get(RRP_alarmCondition).toString());
            faultFieldsDto.setEventSeverity(Enums.EventSeverity.valueOf(eventMap.get(RRP_eventSeverity).toString()));

            faultFieldsDto.setEventSourceType(eventMap.getOrDefault(RRP_eventSourceType, "application").toString());
            faultFieldsDto.setVfStatus(eventMap.getOrDefault(RRP_vfStatus, "Active").toString());
            faultFieldsDto.setFaultFieldsVersion(Double.parseDouble(eventMap.getOrDefault(RRP_faultFieldsVersion, 4.0).toString()));
            faultFieldsDto.setSpecificProblem(eventMap.get(RRP_specificProblem).toString());

            if (eventMap.get(RRP_alarmAdditionalInformation) != null) {
                faultFieldsDto.setAlarmAdditionalInformation((Map<String, String>) eventMap.get(RRP_alarmAdditionalInformation));
            }
            if (eventMap.get(RRP_alarmInterfaceA) != null) {
                faultFieldsDto.setAlarmInterfaceA(eventMap.get(RRP_alarmInterfaceA).toString());
            }
            if (eventMap.get(RRP_eventCategory) != null) {
                faultFieldsDto.setEventCategory(eventMap.get(RRP_eventCategory).toString());
            }

            CommonEventHeaderDto commonEventHeaderDto = getCommonEventHeaderDto(eventMap, Enums.Domain.FAULT);

            EventDto eventDto = new EventDto();
            eventDto.setCommonEventHeader(commonEventHeaderDto);
            eventDto.setFaultFields(faultFieldsDto);

            CommonEventFormatDto commonEventFormatDto = new CommonEventFormatDto(eventDto);

            sendEvent(commonEventFormatDto, eventMap.get(RRP_host).toString(), eventMap.get(RRP_port).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static CommonEventHeaderDto getCommonEventHeaderDto(Map<String, Object> eventMap, Enums.Domain domain) {
        CommonEventHeaderDto commonEventHeaderDto = new CommonEventHeaderDto();
        commonEventHeaderDto.setDomain(domain);
        commonEventHeaderDto.setEventId(generateEventId(eventMap.get(RRP_eventId).toString()));
        commonEventHeaderDto.setEventName(eventMap.get(RRP_eventName).toString());
        commonEventHeaderDto.setLastEpochMicrosec((double) (System.currentTimeMillis() * 1000));
        commonEventHeaderDto.setPriority(Enums.Priority.valueOf(eventMap.get(RRP_priority).toString()));
        commonEventHeaderDto.setSequence(0);
        commonEventHeaderDto.setEventName( eventMap.get(RRP_eventName).toString());
        commonEventHeaderDto.setReportingEntityName(eventMap.get(RRP_reportingEntityName).toString());
        commonEventHeaderDto.setSourceName(eventMap.get(RRP_sourceName).toString());
        commonEventHeaderDto.setStartEpochMicrosec((double) (System.currentTimeMillis() * 1000));
        commonEventHeaderDto.setVersion(4.1);
        commonEventHeaderDto.setVesEventListenerVersion("7.1.1");

        if (eventMap.get(RRP_timeZoneOffset) != null) {
            commonEventHeaderDto.setTimeZoneOffset(eventMap.get(RRP_timeZoneOffset).toString());
        }
        return commonEventHeaderDto;
    }

}

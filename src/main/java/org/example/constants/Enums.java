package org.example.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Enums {

    public enum Domain {
        FAULT("fault"),
        HEARTBEAT("heartbeat"),
        MEASUREMENTS_FOR_VF_SCALING("measurementsForVfScaling"),
        MOBILE_FLOW("mobileFlow"),
        NOTIFICATION("notification"),
        OTHER("other"),
        PNF_REGISTRATION("pnfRegistration"),
        SIP_SIGNALING("sipSignaling"),
        STATE_CHANGE("stateChange"),
        SYSLOG("syslog"),
        THRESHOLD_CROSSING_ALERT("thresholdCrossingAlert"),
        VOICE_QUALITY("voiceQuality"),
        XNF_REGISTRATION("xNFRegistration"),
        CM_NOTIFY("cmNotify"),
        MEASUREMENT("measurement");

        private final String jsonValue;

        Domain(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }

    public enum Priority {
        HIGH("High"),
        MEDIUM("Medium"),
        NORMAL("Normal"),
        LOW("Low");

        private final String jsonValue;

        Priority(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }

    public enum EventSeverity {
        CRITICAL("CRITICAL"),
        MAJOR("MAJOR"),
        MINOR("MINOR"),
        WARNING("WARNING"),
        NORMAL("NORMAL"),
        UNKNOWN("UNKNOWN");

        private final String jsonValue;

        EventSeverity(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum FlowDirection {
        IN("in"),
        OUT("out"),
        BOTH("both");

        private final String jsonValue;

        FlowDirection(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum FlowRole {
        SGW("sgw"),
        PGW("pgw"),
        SGI("sgi"),
        UNKNOWN("unknown");

        private final String jsonValue;

        FlowRole(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum IpProtocolType {
        IPV4("ipv4"),
        IPV6("ipv6"),
        IPV4V6("ipv4v6"),
        UNKNOWN("unknown");

        private final String jsonValue;

        IpProtocolType(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }

    public enum GtpConnectionType {
        CONTROL("control"),
        USER("user"),
        UNKNOWN("unknown");

        private final String jsonValue;

        GtpConnectionType(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum GtpProtocolType {
        GTPV0("gtpv0"),
        GTPV1("gtpv1"),
        GTPV2C("gtpv2c"),
        UNKNOWN("unknown");

        private final String jsonValue;

        GtpProtocolType(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum GtpVersion {
        V0("v0"),
        V1("v1"),
        V2C("v2c"),
        UNKNOWN("unknown");

        private final String jsonValue;

        GtpVersion(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum IpVersion {
        FOUR("4"),
        SIX("6"),
        FOUR_SIX("46"),
        UNKNOWN("unknown");

        private final String jsonValue;

        IpVersion(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum SamplingAlgorithm {
        UNIFORM("uniform"),
        STATIC("static"),
        ADAPTIVE("adaptive"),
        UNKNOWN("unknown");

        private final String jsonValue;

        SamplingAlgorithm(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum ChangeIdentifier {
        SERVICE("Service"),
        OTHER("Other");

        private final String jsonValue;

        ChangeIdentifier(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum ChangeType {
        ADDITION("addition"),
        DELETION("deletion"),
        ATTRIBUTE_VALUE_CHANGE("attributeValueChange"),
        OTHER("other");

        private final String jsonValue;

        ChangeType(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum AlertAction {
        CLEAR("CLEAR"),
        SET("SET");

        private final String jsonValue;

        AlertAction(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum AlertType {
        CARD_ANOMALY("CARD_ANOMALY"),
        ELEMENT_ANOMALY("ELEMENT_ANOMALY"),
        INTERFACE_ANOMALY("INTERFACE_ANOMALY"),
        PROCESS_ANOMALY("PROCESS_ANOMALY"),
        ROUTE_ANOMALY("ROUTE_ANOMALY"),
        SERVICE_ANOMALY("SERVICE_ANOMALY"),
        SYSTEM_ANOMALY("SYSTEM_ANOMALY"),
        ENVIRONMENTAL_ANOMALY("ENVIRONMENTAL_ANOMALY"),
        UNKNOWN("UNKNOWN"),
        VIRTUAL_NETWORK_FUNCTION_ANOMALY("VIRTUAL_NETWORK_FUNCTION_ANOMALY"),
        CARD_THRESHOLD_CROSSED("CARD_THRESHOLD_CROSSED"),
        ELEMENT_THRESHOLD_CROSSED("ELEMENT_THRESHOLD_CROSSED"),
        INTERFACE_THRESHOLD_CROSSED("INTERFACE_THRESHOLD_CROSSED"),
        PROCESS_THRESHOLD_CROSSED("PROCESS_THRESHOLD_CROSSED"),
        ROUTE_THRESHOLD_CROSSED("ROUTE_THRESHOLD_CROSSED"),
        SERVICE_THRESHOLD_CROSSED("SERVICE_THRESHOLD_CROSSED"),
        SYSTEM_THRESHOLD_CROSSED("SYSTEM_THRESHOLD_CROSSED"),
        ENVIRONMENTAL_THRESHOLD_CROSSED("ENVIRONMENTAL_THRESHOLD_CROSSED"),
        VIRTUAL_NETWORK_FUNCTION_THRESHOLD_CROSSED("VIRTUAL_NETWORK_FUNCTION_THRESHOLD_CROSSED");

        private final String jsonValue;

        AlertType(String jsonValue) {
            this.jsonValue = jsonValue;
        }

        public String getJsonValue() {
            return jsonValue;
        }
    }
    public enum HttpMethod {
        GET, POST, PUT, PATCH, DELETE
    }

    @Getter
    @RequiredArgsConstructor
    public enum ContentType {
        JSON("application/json"),
        FORM_URLENCODED("application/x-www-form-urlencoded"),
        TEXT_PLAIN("text/plain");

        private final String value;

        public static ContentType fromString(String contentType) {
            if (contentType == null) {
                return null;
            }

            String normalizedContentType = contentType.toLowerCase().split(";")[0].trim();

            for (ContentType type : values()) {
                if (type.getValue().equals(normalizedContentType)) {
                    return type;
                }
            }

            throw new IllegalArgumentException("Unsupported content type: " + contentType);
        }
    }
}

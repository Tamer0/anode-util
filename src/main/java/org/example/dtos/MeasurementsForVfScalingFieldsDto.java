package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MeasurementsForVfScalingFieldsDto {

    /**
     * required: ["measurementsForVfScalingFieldsVersion", "measurementInterval"]
     */
    private Double measurementsForVfScalingFieldsVersion;

    private Integer measurementInterval;

    private List<AdditionalMeasurement> additionalMeasurements;
    private List<MeasurementGroup> measurementGroup;
    private List<VNicPerformance> vNicPerformanceArray;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AdditionalMeasurement {
        private String name;
        private Map<String, Double> values = new HashMap<>();
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class MeasurementGroup {
        private String name;
        private List<Measurement> measurements;

        @Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Measurement {
            private Map<String, Double> values = new HashMap<>();
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class VNicPerformance {
        private Map<String, Double> values = new HashMap<>();
    }
}

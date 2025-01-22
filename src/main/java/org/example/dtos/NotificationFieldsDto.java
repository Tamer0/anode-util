package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationFieldsDto {

    /** required: ["notificationFieldsVersion","changeIdentifier","changeType"] */
    @NotNull
    private Double notificationFieldsVersion;

    @NotNull
    private String changeIdentifier; // İsterseniz enum yapabilirsiniz

    @NotNull
    private String changeType;       // İsterseniz enum yapabilirsiniz

    private List<NamedHashMapDto> arrayOfNamedHashMap;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class NamedHashMapDto {
        @NotNull
        private String name;
        @NotNull
        private Map<String, String> hashMap;
    }
}

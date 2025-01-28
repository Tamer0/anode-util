package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NotificationFieldsDto {

    /** required: ["notificationFieldsVersion","changeIdentifier","changeType"] */

    private Double notificationFieldsVersion;


    private String changeIdentifier; // İsterseniz enum yapabilirsiniz


    private String changeType;       // İsterseniz enum yapabilirsiniz

    private List<NamedHashMapDto> arrayOfNamedHashMap;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class NamedHashMapDto {

        private String name;

        private Map<String, String> hashMap;
    }
}

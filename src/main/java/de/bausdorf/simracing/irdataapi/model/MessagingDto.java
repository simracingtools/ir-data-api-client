package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessagingDto<T> {
    @JsonProperty("type")
    private String type;
    @JsonProperty("data")
    T data;
}

package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MemberRecapResultDto {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("year")
    private Long year;
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("season")
    private Long season;
    @JsonProperty("stats")
    private MemberRecapDto stats;
}

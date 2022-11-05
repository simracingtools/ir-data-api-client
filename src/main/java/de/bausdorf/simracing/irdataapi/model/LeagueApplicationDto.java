package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class LeagueApplicationDto {
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("admins")
    private Object[] admins;
    @JsonProperty("initiated")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime initiated;
    @JsonProperty("league_id")
    private Long leagueId;
    @JsonProperty("application_id")
    private Long applicationId;
    @JsonProperty("helmet")
    private HelmetDto helmet;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("message")
    private String message;
}

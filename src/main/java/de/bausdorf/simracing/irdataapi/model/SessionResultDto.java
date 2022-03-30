package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SessionResultDto {
    @JsonProperty("simsession_number")
    private Long simsessionNumber;
    @JsonProperty("simsession_type")
    private Long simsessionType;
    @JsonProperty("simsession_type_name")
    private String simsessionTypeName;
    @JsonProperty("simsession_subtype")
    private Long imsessionSubtype;
    @JsonProperty("simsession_name")
    private String simsessionName;
    @JsonProperty("results")
    private MemberSessionResultDto[] results;
}

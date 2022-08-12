package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CountryDto {
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("country_code")
    private String countryCode;
}

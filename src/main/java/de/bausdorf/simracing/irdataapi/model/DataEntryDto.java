package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
public class DataEntryDto {
    @JsonProperty("when")
    @JsonFormat(pattern = DataApiConstants.LOCAL_DATE_FORMAT)
    private LocalDate when;
    @JsonProperty("value")
    private Long value;
}

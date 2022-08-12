package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DriverRecordDto {
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("club_id")
    private Long clubId;
    @JsonProperty("club_name")
    private String clubName;
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("track_id")
    private Long trackId;
    @JsonProperty("season_year")
    private Long seasonYear;
    @JsonProperty("season_quarter")
    private Long seasonQuarter;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("region")
    private String region;
    @JsonProperty("license")
    private DriverLicenseInfoDto license;
    @JsonProperty("practice_lap_time")
    private Long practiceLapTime;
    @JsonProperty("practice_date")
    @JsonFormat(pattern = DataApiConstants.LOCAL_DATE_FORMAT)
    private LocalDate practiceDate;
    @JsonProperty("qualify_lap_time")
    private Long qualifyLapTime;
    @JsonProperty("qualify_date")
    @JsonFormat(pattern = DataApiConstants.LOCAL_DATE_FORMAT)
    private LocalDate qualifyDate;
    @JsonProperty("tt_lap_time")
    private Long ttLapTime;
    @JsonProperty("tt_date")
    @JsonFormat(pattern = DataApiConstants.LOCAL_DATE_FORMAT)
    private LocalDate ttDate;
    @JsonProperty("race_lap_time")
    private Long raceLapTime;
    @JsonProperty("race_date")
    @JsonFormat(pattern = DataApiConstants.LOCAL_DATE_FORMAT)
    private LocalDate raceDate;
}

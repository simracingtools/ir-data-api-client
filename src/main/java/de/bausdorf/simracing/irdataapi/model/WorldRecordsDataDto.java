package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class WorldRecordsDataDto {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("track_id")
    private Long trackId;
    @JsonProperty("season_year")
    private Long seasonYear;
    @JsonProperty("season_quarter")
    private Long seasonQuarter;
    @JsonProperty("chunk_info")
    private ChunkInfoDto chunkInfo;
    @JsonProperty("last_updated")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime lastUpdated;
}

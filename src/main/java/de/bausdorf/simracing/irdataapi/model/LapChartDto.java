package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class LapChartDto {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("session_info")
    private SessionInfoDto sessionInfo;
    @JsonProperty("best_lap_num")
    private Long bestLapNum;
    @JsonProperty("best_lap_time")
    private Long bestLapTime;
    @JsonProperty("best_nlaps_num")
    private Long bestNlapsNum;
    @JsonProperty("best_nlaps_time")
    private Long bestNlapsTime;
    @JsonProperty("best_qual_lap_num")
    private Long bestQualLapNum;
    @JsonProperty("best_qual_lap_time")
    private Long bestQualLapTime;
    @JsonProperty("best_qual_lap_at")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime bestQualLapAt;
    @JsonProperty("chunk_info")
    private ChunkInfoDto chunkInfo;
}

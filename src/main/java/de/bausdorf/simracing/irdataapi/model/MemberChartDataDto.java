package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberChartDataDto {
  @JsonProperty("success")
  private Boolean success;
  @JsonProperty("cust_id")
  private Long custId;
  @JsonProperty("blackout")
  private Boolean blackout;
  @JsonProperty("category_id")
  private Long categoryId;
  @JsonProperty("chart_type")
  private Long chartType;
  @JsonProperty("data")
  private DataEntryDto[] data;
}

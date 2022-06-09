package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CarPointDto {
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("car_name")
    private String carName;
    @JsonProperty("team_car")
    private Boolean teamCar;
}

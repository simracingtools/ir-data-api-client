package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class DriverPointsCarClassDto {
    @JsonProperty("car_class_id")
    private Long carClassId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cars_in_class")
    private CarRefShortDto[] carsInClass;
}

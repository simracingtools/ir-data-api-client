package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CarInClassDto {
    private String car_dirpath;
    private Long car_id;
    private Boolean retired;
}

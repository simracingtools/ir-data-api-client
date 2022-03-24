package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarClassDto {
    private Long car_class_id;
    private Long cust_id;
    private String name;
    private Long relative_speed;
    private String short_name;
    private CarInClassDto[] cars_in_class;
}

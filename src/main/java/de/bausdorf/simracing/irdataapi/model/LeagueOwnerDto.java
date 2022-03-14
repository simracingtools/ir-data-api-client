package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LeagueOwnerDto {
    private Long cust_id;
    private String display_name;
    private HelmetDto helmet;
    private String car_number;
    private String nick_name;
}

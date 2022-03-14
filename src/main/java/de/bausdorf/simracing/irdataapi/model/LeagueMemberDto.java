package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LeagueMemberDto {
    private Long cust_id;
    private String display_name;
    private HelmetDto helmet;
    private Boolean owner;
    private Boolean admin;
    private Boolean league_mail_opt_out;
    private Boolean league_pm_opt_out;
    private String league_member_since;
    private String car_number;
    private String nick_name;
}

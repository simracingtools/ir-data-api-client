package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberInfoDto {
    private String cust_id;//": 361716,
    private String display_name;//": "Daniel Toennissen",
    private HelmetDto helmet;//"helmet": { },
    private String last_login;//": "2022-03-13T09:16:00.717162Z",
    private String member_since;//": "2019-02-10",
    private String club_id;//": 42,
    private String club_name;//": "DE-AT-CH",
    private String ai;//": false
}

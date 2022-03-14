package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LeagueInfoDto {
    private Long league_id;
    private Long owner_id;
    private String league_name;
    private String created;
    private Boolean hidden;
    private String message;
    private String url;
    private Boolean recruiting;
    private Boolean private_wall;
    private Boolean private_roster;
    private Boolean private_schedule;
    private Boolean private_results;
    private Long roster_count;//": 573,
    private LeagueOwnerDto owner;
    private ImageDto image;
    private TagsDto tags;
    private LeagueMemberDto[] roster;
}

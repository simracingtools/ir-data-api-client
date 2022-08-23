package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LeagueMembershipDto {
    @JsonProperty("league_id")
    private Long leagueId;
    @JsonProperty("league_name")
    private String leagueName;
    @JsonProperty("owner")
    private Boolean owner;
    @JsonProperty("admin")
    private Boolean admin;
    @JsonProperty("league_mail_opt_out")
    private Boolean leagueMailOptOut;
    @JsonProperty("league_pm_opt_out")
    private Boolean leaguePmOptOut;
    @JsonProperty("car_number")
    private String carNumber;
    @JsonProperty("nick_name")
    private String nickName;
    @JsonProperty("league")
    private LeagueInfoDto fullLeagueInfo;
}

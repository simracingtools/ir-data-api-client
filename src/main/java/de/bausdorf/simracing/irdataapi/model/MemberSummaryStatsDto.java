package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MemberSummaryStatsDto {
    private Long num_official_sessions;
    private Long num_league_sessions;
    private Long num_official_wins;
    private Long num_league_wins;
}

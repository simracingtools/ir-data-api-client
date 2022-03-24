package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MemberYearlyDto {
    private Long cust_id;
    private MemberStatsDto[] stats;
}

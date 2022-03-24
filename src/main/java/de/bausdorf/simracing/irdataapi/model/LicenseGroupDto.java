package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LicenseGroupDto {
    private Long license_group;
    private String group_name;
    private Long min_num_races;
    private Long participation_credits;
    private Long min_sr_to_fast_track;
    private Long min_num_tt;
    private LicenseLevelDto[] levels;
}

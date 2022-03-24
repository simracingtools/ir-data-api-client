package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LicenseLevelDto {
    private Long license_id;
    private Long license_group;
    private String license;
    private String short_name;
    private String license_letter;
    private String color;
}

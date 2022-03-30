package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LicenseInfoDto {
    @JsonProperty("parent_id")
    private Long parentId;
    @JsonProperty("license_group")
    private Long licenseGroup;
    @JsonProperty("min_license_level")
    private Long minLicenseLevel;
    @JsonProperty("max_license_level")
    private Long maxLicenseLevel;
    @JsonProperty("group_name")
    private String groupName;
}

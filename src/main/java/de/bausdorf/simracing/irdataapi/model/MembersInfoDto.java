package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MembersInfoDto {
    private boolean success;
    private String[] cust_ids;
    private MemberInfoDto[] members;
}

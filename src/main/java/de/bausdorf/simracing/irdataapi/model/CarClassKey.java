package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CarClassKey  {
    private Long carClassId;
    private Long custId;
    private String name;
    private String shortName;

    public CarClassKey(CarClassDto dto) {
        this.carClassId = dto.getCarClassId();
        this.custId = dto.getCustId();
        this.name = dto.getName();
        this.shortName = dto.getShortName();
    }

}

package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long category_id;
    private String name;
    private Long limit;
    private TagDto[] tags;
}

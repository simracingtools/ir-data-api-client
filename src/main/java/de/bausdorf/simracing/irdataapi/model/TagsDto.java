package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagsDto {
    private CategoryDto[] categorized;
    private CategoryDto[] not_categorized;
}

package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarAssetDto {
    private Long car_id;
    private CarRuleDto[] car_rules;
    private String detail_copy;
    private String detail_screen_shot_images;//": "formula_skipbarber/fsb2000_ss_1,formula_skipbarber/fsb2000_ss_2,formula_skipbarber/fsb2000_ss_3,formula_skipbarber/fsb2000_ss_4,formula_skipbarber/fsb2000_ss_5,formula_skipbarber/fsb2000_ss_6,formula_skipbarber/fsb2000_ss_7,formula_skipbarber/fsb2000_ss_8",
    private String detail_techspecs_copy;
    private String folder;
    private String gallery_images;
    private String gallery_prefix;
    private String group_image;
    private String group_name;
    private String large_image;
    private String logo;
    private String small_image;
    private String sponsor_logo;
    private String template_path;
}

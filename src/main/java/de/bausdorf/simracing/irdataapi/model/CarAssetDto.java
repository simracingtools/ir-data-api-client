package de.bausdorf.simracing.irdataapi.model;

/*-
 * #%L
 * de.bausdorf.simracing:ir-data-api-client
 * %%
 * Copyright (C) 2022 bausdorf engineering
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

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

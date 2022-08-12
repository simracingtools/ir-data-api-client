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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarAssetDto {
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("car_rules")
    private CarRuleDto[] carRules;
    @JsonProperty("detail_copy")
    private String detailCopy;
    @JsonProperty("detail_screen_shot_images")
    private String detailScreenShotImages;
    @JsonProperty("detail_techspecs_copy")
    private String detailTechspecsCopy;
    @JsonProperty("folder")
    private String folder;
    @JsonProperty("gallery_images")
    private String galleryImages;
    @JsonProperty("gallery_prefix")
    private String galleryPrefix;
    @JsonProperty("group_image")
    private String groupImage;
    @JsonProperty("group_name")
    private String groupName;
    @JsonProperty("large_image")
    private String largeImage;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("small_image")
    private String smallImage;
    @JsonProperty("sponsor_logo")
    private String sponsorLogo;
    @JsonProperty("template_path")
    private String templatePath;
}

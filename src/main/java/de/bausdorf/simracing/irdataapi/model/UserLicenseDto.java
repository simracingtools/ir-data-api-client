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
public class UserLicenseDto {
      @JsonProperty("category_id")
      private Long categoryId;
      @JsonProperty("category")
      private String category;
      @JsonProperty("license_level")
      private Long licenseLevel;
      @JsonProperty("safety_rating")
      private Double safetyRating;
      @JsonProperty("cpi")
      private Double cpi;
      @JsonProperty("irating")
      private Long iRating;
      @JsonProperty("tt_rating")
      private Long ttRating;
      @JsonProperty("mpr_num_races")
      private Long mprNumRaces;
      @JsonProperty("color")
      private String color;
      @JsonProperty("group_name")
      private String groupName;
      @JsonProperty("group_id")
      private String groupId;
      @JsonProperty("mpr_num_tts")
      private String mprNumTts;
      @JsonProperty("pro_promotable")
      private Boolean proPromotable;
}

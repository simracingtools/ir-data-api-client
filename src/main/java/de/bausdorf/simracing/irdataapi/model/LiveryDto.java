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
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LiveryDto {
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("pattern")
    private Long pattern;
    @JsonProperty("color1")
    private String color1;
    @JsonProperty("color2")
    private String color2;
    @JsonProperty("color3")
    private String color3;
    @JsonProperty("number_font")
    private Long numberFont;
    @JsonProperty("number_color1")
    private String numberColor1;
    @JsonProperty("number_color2")
    private String numberColor2;
    @JsonProperty("number_color3")
    private String numberColor3;
    @JsonProperty("number_slant")
    private Long numberSlant;
    @JsonProperty("sponsor1")
    private Long sponsor1;
    @JsonProperty("sponsor2")
    private Long sponsor2;
    @JsonProperty("car_number")
    private String carNumber;
    @JsonProperty("wheel_color")
    private String wheelColor;
    @JsonProperty("rim_type")
    private Long rimType;
}

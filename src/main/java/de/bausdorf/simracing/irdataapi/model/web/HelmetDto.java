package de.bausdorf.simracing.irdataapi.model.web;

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
public class HelmetDto {
    @JsonProperty("c3")
    private String color3;
    @JsonProperty("ll")
    private Long ll;
    @JsonProperty("hp")
    private Long hp;
    @JsonProperty("ht")
    private Long ht;
    @JsonProperty("c1")
    private String color1;
    @JsonProperty("ft")
    private Long ft;
    @JsonProperty("c2")
    private String color2;

}

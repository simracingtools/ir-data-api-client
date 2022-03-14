package de.bausdorf.simracing.irdataapi.model;

/*-
 * #%L
 * iRDataAPIClient
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
public class HelmetDto {
    private String pattern;//": 67,
    private String color1;//": "000000",
    private String color2;//": "10cf15",
    private String color3;//": "111111",
    private String face_type;//": 0,
    private String helmet_type;//": 0

}

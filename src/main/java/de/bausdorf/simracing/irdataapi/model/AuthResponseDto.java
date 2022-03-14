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
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class AuthResponseDto {
    private String authcode;
    private Boolean inactive;
    private String message;
    private Boolean verificationRequired;
    private String autoLoginSeries;
    private String autoLoginToken;
    private String custId;
    private String email;
    private String ssoCookieDomain;
    private String ssoCookieName;
    private String ssoCookiePath;
    private String ssoCookieValue;
}

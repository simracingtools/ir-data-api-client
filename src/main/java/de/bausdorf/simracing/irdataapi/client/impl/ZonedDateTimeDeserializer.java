package de.bausdorf.simracing.irdataapi.client.impl;

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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Slf4j
public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateString = jsonParser.getText();
        try {
            return ZonedDateTime.parse(dateString);
        } catch (DateTimeParseException e1) {
            try {
                return ZonedDateTime.parse(dateString, DateTimeFormatter.ofPattern(DataApiConstants.UTC_DATETIME_FORMAT));
            } catch (DateTimeParseException e2) {
                return ZonedDateTime.parse(dateString, DateTimeFormatter.ofPattern(DataApiConstants.UTC_PRECISE_DATETIME_FORMAT));
            }
        }
    }
}

package de.bausdorf.simracing.irdataapi.client;

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

import de.bausdorf.simracing.irdataapi.config.ConfigProperties;
import de.bausdorf.simracing.irdataapi.model.AuthResponseDto;
import de.bausdorf.simracing.irdataapi.model.CarInfoDto;
import de.bausdorf.simracing.irdataapi.model.LoginRequestDto;
import de.bausdorf.simracing.irdataapi.model.MembersInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = {IrDataClientTest.class})
@EnableConfigurationProperties(value = ConfigProperties.class)
@TestPropertySource("classpath:application-test.properties")
@Slf4j
class IrDataClientTest {

    @Autowired
    ConfigProperties config;

    IrDataClient dataClient = new IrDataClient();

    @Test
    void testGetMembersInfo() {
        authenticate();
        List<String> ids = new ArrayList<>();
        ids.add("229120");

        MembersInfoDto membersInfoDto = dataClient.getMembersInfo(ids);
        log.info(membersInfoDto.toString());
    }

    @Test
    void testGetCarInfo() {
        authenticate();
        CarInfoDto[] carInfoDtos = dataClient.getCarInfo();
        Arrays.asList(carInfoDtos).forEach(s -> log.info(s.toString()));

        log.info("got {} car infos", carInfoDtos.length);
    }

    private void authenticate() {
        if (!dataClient.isAuthenticated()) {
            LoginRequestDto dto = LoginRequestDto.builder()
                    .email(config.getUser())
                    .password(config.getPassword())
                    .build();
            AuthResponseDto authResponseDto = dataClient.authenticate(dto);
            log.info(authResponseDto.toString());
        }
    }
}

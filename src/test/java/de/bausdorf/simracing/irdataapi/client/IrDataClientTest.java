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
import de.bausdorf.simracing.irdataapi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.fail;

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
        List<Long> ids = new ArrayList<>();
        ids.add(229120L);

        MembersInfoDto membersInfoDto = dataClient.getMembersInfo(ids);
        log.info(membersInfoDto.toString());
    }

    @Test
    void testGetMemberSummary() {
        authenticate();
        MemberSummaryDto memberSummaryDto = dataClient.getMemberSummary(229120L);
        log.info(memberSummaryDto.toString());
    }

    @Test
    void testGetMembersInfoWithInvalidId() {
        authenticate();
        List<Long> ids = new ArrayList<>();
        ids.add(229120L);
        ids.add(0L);

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

    @Test
    void testGetCarClasses() {
        authenticate();
        CarClassDto[] carClassDtos = dataClient.getCarClasses();
        Arrays.asList(carClassDtos).forEach(s -> log.info(s.toString()));

        log.info("got {} car classes", carClassDtos.length);
    }

    @Test
    void testGetCarAssets() {
        authenticate();
        Map<Long, CarAssetDto> carAssetDtoMap = dataClient.getCarAssets();

        log.info("got {} car asset infos", carAssetDtoMap.size());
    }

    @Test
    void testGetDivisions() {
        authenticate();
        DivisionDto[] divisionDtos = dataClient.getDivisions();

        Arrays.asList(divisionDtos).forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetLicenseGroups() {
        authenticate();
        LicenseGroupDto[] licenseGroups = dataClient.getLicenseGroups();
        Arrays.asList(licenseGroups).forEach(s -> log.info(s.toString()));

        log.info("got {} license groups", licenseGroups.length);
    }

    @Test
    void testGetLeagueInfo() {
        authenticate();
        LeagueInfoDto leagueInfoDto = dataClient.getLeagueInfo(3693);

        log.info("got league {} infos", leagueInfoDto.getLeague_name());
        Arrays.stream(leagueInfoDto.getRoster())
                .filter(LeagueMemberDto::getAdmin)
                .forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetLeagueInfoWithInvalidId() {
        authenticate();
        try {
            dataClient.getLeagueInfo(0);
            fail("Exception expected");
        } catch( HttpClientErrorException e) {
            log.info(e.getMessage());
        }
    }

    @Test
    void testGetTrackInfo() {
        authenticate();
        TrackInfoDto[] trackInfoDtos = dataClient.getTrackInfos();

        Arrays.stream(trackInfoDtos)
                .filter(s -> (s.getSku() == 0L))
                .forEach(s -> log.info(s.toString()));

        log.info("got {} track infos", trackInfoDtos.length);
    }

    @Test
    void testInvalidAuthentication() {
        LoginRequestDto dto = LoginRequestDto.builder()
                .email("kirk@starfleet.com")
                .password("spock")
                .build();
        try {
            dataClient.authenticate(dto);
            fail("Exception expected");
        } catch(AuthorizationException e) {
            log.info(e.getMessage());
        }
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

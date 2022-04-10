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

import de.bausdorf.simracing.irdataapi.client.impl.IrDataClientImpl;
import de.bausdorf.simracing.irdataapi.config.ConfigProperties;
import de.bausdorf.simracing.irdataapi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {IrDataClientTest.class})
@EnableConfigurationProperties(value = ConfigProperties.class)
@TestPropertySource("classpath:application-test.properties")
@Slf4j
class IrDataClientTest {

    public static final long CUST_ID = 229120L;
    @Autowired
    ConfigProperties config;

    IrDataClient dataClient = new IrDataClientImpl();

    @Test
    void testGetMembersInfo() {
        authenticate();
        List<Long> ids = new ArrayList<>();
        ids.add(CUST_ID);

        MembersInfoDto membersInfoDto = dataClient.getMembersInfo(ids);
        assertNotNull(membersInfoDto);
        log.info(membersInfoDto.toString());
    }

    @Test
    void testGetMemberSummary() {
        authenticate();
        MemberSummaryDto memberSummaryDto = dataClient.getMemberSummary(CUST_ID);
        assertNotNull(memberSummaryDto);
        log.info(memberSummaryDto.toString());
    }

    @Test
    void testGetMemberYearlyStats() {
        authenticate();
        MemberYearlyDto yearlyDto = dataClient.getMemberStatsYearly(CUST_ID);
        assertNotNull(yearlyDto);
        assertTrue(yearlyDto.getStats().length > 0);
        Arrays.asList(yearlyDto.getStats()).forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetMemberRecentRaces() {
        authenticate();
        MemberRecentRacesDto recentRacesDto = dataClient.getMemberRecentRaces(CUST_ID);
        assertNotNull(recentRacesDto);
        assertTrue(recentRacesDto.getRaces().length > 0);
        Arrays.asList(recentRacesDto.getRaces()).forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetMemberCareer() {
        authenticate();
        MemberCareerDto memberCareerDto = dataClient.getMemberCareer(CUST_ID);
        assertNotNull(memberCareerDto);
        assertTrue(memberCareerDto.getStats().length > 0);
        Arrays.asList(memberCareerDto.getStats()).forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetMembersInfoWithInvalidId() {
        authenticate();
        List<Long> ids = new ArrayList<>();
        ids.add(CUST_ID);
        ids.add(0L);

        MembersInfoDto membersInfoDto = dataClient.getMembersInfo(ids);
        assertNotNull(membersInfoDto);
        assertTrue(membersInfoDto.getMembers().length > 0);
        log.info(membersInfoDto.toString());
    }

    @Test
    void testGetCarInfo() {
        authenticate();
        CarInfoDto[] carInfoDtos = dataClient.getCarInfo();
        assertNotNull(carInfoDtos);
        assertTrue(carInfoDtos.length > 0);
        Arrays.asList(carInfoDtos).forEach(s -> log.info(s.toString()));

        log.info("got {} car infos", carInfoDtos.length);
    }

    @Test
    void testGetCarClasses() {
        authenticate();
        CarClassDto[] carClassDtos = dataClient.getCarClasses();
        assertNotNull(carClassDtos);
        assertTrue(carClassDtos.length > 0);
        Arrays.asList(carClassDtos).forEach(s -> log.info(s.toString()));

        log.info("got {} car classes", carClassDtos.length);
    }

    @Test
    void testGetCarAssets() {
        authenticate();
        Map<Long, CarAssetDto> carAssetDtoMap = dataClient.getCarAssets();
        assertNotNull(carAssetDtoMap);
        assertTrue(carAssetDtoMap.size() > 0);

        log.info("got {} car asset infos", carAssetDtoMap.size());
    }

    @Test
    void testGetTrackAssets() {
        authenticate();
        Map<Long, TrackAssetDto> trackAssetDtoMap = dataClient.getTrackAssets();
        assertNotNull(trackAssetDtoMap);
        assertTrue(trackAssetDtoMap.size() > 0);
        trackAssetDtoMap.entrySet().stream()
                .filter(e -> e.getValue().getDetailTechspecsCopy() != null)
                .forEach(e -> log.info("{}: {}", e.getValue().getFolder(), e.getValue().getDetailTechspecsCopy()));

        log.info("got {} car asset infos", trackAssetDtoMap.size());
    }

    @Test
    void testGetDivisions() {
        authenticate();
        DivisionDto[] divisionDtos = dataClient.getDivisions();
        assertNotNull(divisionDtos);
        assertTrue(divisionDtos.length > 0);

        Arrays.asList(divisionDtos).forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetLicenseGroups() {
        authenticate();
        LicenseGroupDto[] licenseGroups = dataClient.getLicenseGroups();
        assertNotNull(licenseGroups);
        assertTrue(licenseGroups.length > 0);
        Arrays.asList(licenseGroups).forEach(s -> log.info(s.toString()));

        log.info("got {} license groups", licenseGroups.length);
    }

    @Test
    void testGetLeagueInfo() {
        authenticate();
        LeagueInfoDto leagueInfoDto = dataClient.getLeagueInfo(3693);
        assertNotNull(leagueInfoDto);
        assertTrue(leagueInfoDto.getRoster().length > 0);

        log.info("got league {} infos", leagueInfoDto.getLeagueName());
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
        assertNotNull(trackInfoDtos);
        assertTrue(trackInfoDtos.length > 0);

        Arrays.stream(trackInfoDtos)
                .filter(s -> (s.getSku() == 0L))
                .forEach(s -> log.info(s.toString()));

        log.info("got {} track infos", trackInfoDtos.length);
    }

    @Test
    void testGetSeasonInfoWithoutSeries() {
        authenticate();
        SeasonDto[] seasonDtos = dataClient.getSeasonInfo(false);
        assertNotNull(seasonDtos);
        assertTrue(seasonDtos.length > 0);

        log.info("got {} season infos", seasonDtos.length);
    }

    @Test
    void testGetSeasonInfoWithSeries() {
        authenticate();
        SeasonDto[] seasonDtos = dataClient.getSeasonInfo(true);
        assertNotNull(seasonDtos);
        assertTrue(seasonDtos.length > 0);

        log.info("got {} season infos", seasonDtos.length);
    }

    @Test
    void testGetOfficialSubsessionResult() {
        authenticate();
        SubsessionResultDto subsessionResultDto = dataClient.getSubsessionResult(44975865L);
        assertNotNull(subsessionResultDto);
        assertTrue(subsessionResultDto.getSessionResults().length > 0);

        log.info("got {} series infos", subsessionResultDto.getSeriesName());
    }

    @Test
    void testGetLeagueSubsessionResult() {
        authenticate();
        SubsessionResultDto subsessionResultDto = dataClient.getSubsessionResult(43352007L);
        assertNotNull(subsessionResultDto);
        assertTrue(subsessionResultDto.getSessionResults().length > 0);

        log.info("got {} series infos", subsessionResultDto.getSeriesName());
    }

    @Test
    void testGetOfficialLapChartData() {
        authenticate();
        LapChartDto lapChartDto = dataClient.getLapChartData(44975865L, 0L);
        assertNotNull(lapChartDto);
        assertTrue(lapChartDto.getSuccess());

        log.info("lap chart session info: {}", lapChartDto.getSessionInfo());

        List<LapChartEntryDto> chartEntries = dataClient.getLapEntries(lapChartDto.getChunkInfo());
        assertFalse(chartEntries.isEmpty());

        chartEntries.forEach(entry -> log.info(entry.toString()));
    }

    @Test
    void testGetLeagueLapChartData() {
        authenticate();
        LapChartDto lapChartDto = dataClient.getLapChartData(44975665L, 0L);
        assertNotNull(lapChartDto);
        assertTrue(lapChartDto.getSuccess());

        log.info("lap chart session info: {}", lapChartDto.getSessionInfo());

        List<LapChartEntryDto> chartEntries = dataClient.getLapEntries(lapChartDto.getChunkInfo());
        assertFalse(chartEntries.isEmpty());

        chartEntries.forEach(entry -> log.info(entry.toString()));
    }

    @Test
    void testGetOfficialLapData() {
        authenticate();
        LapDataDto lapDataDto = dataClient.getLapData(44975865L, 0L, null, false);
        assertNotNull(lapDataDto);
        assertTrue(lapDataDto.getSuccess());

        log.info("lap chart session info: {}", lapDataDto.getSessionInfo());

        List<LapChartEntryDto> chartEntries = dataClient.getLapEntries(lapDataDto.getChunkInfo());
        assertFalse(chartEntries.isEmpty());

        chartEntries.forEach(entry -> log.info(entry.toString()));
    }

    @Test
    void testGetLeagueLapData() {
        authenticate();
        LapDataDto lapDataDto = dataClient.getLapData(44975665L, 0L, 234139L, false);
        assertNotNull(lapDataDto);
        assertTrue(lapDataDto.getSuccess());

        log.info("lap chart session info: {}", lapDataDto.getSessionInfo());

        List<LapChartEntryDto> chartEntries = dataClient.getLapEntries(lapDataDto.getChunkInfo());
        assertFalse(chartEntries.isEmpty());

        chartEntries.forEach(entry -> log.info(entry.toString()));
    }

    @Test
    void testGetTeamLeagueLapData() {
        authenticate();
        LapDataDto lapDataDto = dataClient.getLapData(43352007L, 0L, -92660L, true);
        assertNotNull(lapDataDto);
        assertTrue(lapDataDto.getSuccess());

        log.info("lap chart session info: {}", lapDataDto.getSessionInfo());

        List<LapChartEntryDto> chartEntries = dataClient.getLapEntries(lapDataDto.getChunkInfo());
        assertFalse(chartEntries.isEmpty());

        chartEntries.forEach(entry -> log.info(entry.toString()));
    }

    @Test
    void testGetEventLog() {
        authenticate();
        EventLogDto eventLogDto = dataClient.getEventLog(43352007L, 0L);
        assertNotNull(eventLogDto);
        assertTrue(eventLogDto.getSuccess());

        log.info("event log info: {}", eventLogDto.getSessionInfo());
        log.info("chunk info: {}", eventLogDto.getChunkInfo());

        List<EventLogEntry> eventLogEntries = dataClient.getEventLogEntries(eventLogDto.getChunkInfo());
        assertFalse(eventLogEntries.isEmpty());

        log.info("got {} event log entries", eventLogEntries.size());
        eventLogEntries.forEach(entry -> log.info(entry.toString()));
    }

    @Test
    void testGetSeasonResults() {
        authenticate();
        SeasonResultsDto seasonResults = dataClient.getSeasonResults(3390L, DataApiConstants.EVENT_TYPE_RACE, 11L);
        assertNotNull(seasonResults);
        assertTrue(seasonResults.getSuccess());

        log.info("{} races in week 11", seasonResults.getResultsList().length);
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

    @Test
    void testReauthentication() {
        try {
            dataClient.getMemberSummary();
            fail("gateDataMember() should throw exception when not authorized");
        } catch (HttpClientErrorException e) {
            assertSame(HttpStatus.UNAUTHORIZED, e.getStatusCode());
            authenticate();
        }
        MemberSummaryDto memberSummaryDto = dataClient.getMemberSummary();
        log.info(memberSummaryDto.toString());
    }

    private void authenticate() {
        if (!dataClient.isAuthenticated()) {
            LoginRequestDto dto = LoginRequestDto.builder()
                    .email(config.getUser())
                    .password(config.getPassword())
                    .build();
            AuthResponseDto authResponseDto = dataClient.authenticate(dto);
            dataClient.setLogResponseJson(config.getLogResponseJson());
            log.info(authResponseDto.toString());
        }
    }
}

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
import de.bausdorf.simracing.irdataapi.model.search.HostedResultSearchRequest;
import de.bausdorf.simracing.irdataapi.model.search.LeagueSearchRequest;
import de.bausdorf.simracing.irdataapi.model.search.ResultSearchRequest;
import de.bausdorf.simracing.irdataapi.model.search.SeriesResultSearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.HttpClientErrorException;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.time.ZonedDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {IrDataClientTest.class})
@EnableConfigurationProperties(value = ConfigProperties.class)
@TestPropertySource("classpath:application-test.properties")
@Slf4j
class IrDataClientTest {

    public static final long CUST_ID = 229120L;
    @Autowired
    ConfigProperties config;

    static final IrDataClient dataClient = new IrDataClientImpl();

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

    @ParameterizedTest
    @NullSource
    @ValueSource(longs = {185159L, 372473L})
    void testGetMemberProfile(Long custId) {
        authenticate();
        MemberProfileDto memberProfile = dataClient.getMemberProfile(custId);
        assertNotNull(memberProfile);
        assertTrue(memberProfile.getSuccess());

        log.info("{}: {}, last login {}", memberProfile.getCustId(),
                memberProfile.getMemberInfo().getDisplayName(), memberProfile.getMemberInfo().getLastLogin());
    }

    @Test
    void testGetMemberBests() {
        authenticate();
        MemberBestsDto memberBests = dataClient.getMemberBests(229120L, 143L);
        assertNotNull(memberBests);

        log.info("car id: {}", memberBests.getCarId());
        Arrays.stream(memberBests.getBests())
                .forEach(best -> log.info("{} ({}): {} ({})", best.getTrack().getTrackName(), best.getTrack().getConfigName(), best.getBestLapTime(), best.getEventType()));
    }

    @Test
    void testGetMemberLookup() {
        authenticate();
        MemberInfoDto[] memberInfos = dataClient.getDriverLookup("Bausdorf");
        assertNotNull(memberInfos);

        Arrays.stream(memberInfos).forEach(info -> log.info("{}", info));
    }

    @Test
    void testGetUserInfo() {
        authenticate();
        UserInfoDto userInfo = dataClient.getUserInfo();
        assertNotNull(userInfo);
        log.info(userInfo.toString());
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
    void testGetMemberChartData() {
        authenticate();
        MemberChartDataDto chartData = dataClient.getMemberChartData(CUST_ID, CategoryType.ROAD, ChartType.I_RATING);
        assertNotNull(chartData);
        assertTrue(chartData.getData().length > 0);
        Arrays.asList(chartData.getData()).forEach(s -> log.info(s.toString()));
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
    void testGetMemberDivision() {
        authenticate();
        MemberDivisonDto memberDivisionDto = dataClient.getMemberDivision(3225L, 5L);
        assertNotNull(memberDivisionDto);
        log.info(memberDivisionDto.toString());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(longs = {97120L, 372473L})
    void testGetMemberAwards(Long custId) {
        authenticate();
        MemberAwardDto[] memberAwards = dataClient.getMemberAwards(custId);
        assertNotNull(memberAwards);
        assertNotEquals(0, memberAwards.length);

        long achievedAwards = Arrays.stream(memberAwards)
                .filter(MemberAwardDto::getAchievement)
                .count();
        log.info("custId {} has {} awards", memberAwards[0].getCustId(), achievedAwards);
    }

    @Test
    void testGetDriverSeasonStandingsRaceWeek() {
        authenticate();
        DriverStandingsDto driverStandingInfo = dataClient.getSeasonDriverStandings(3225L, 1860L, 7L);
        assertNotNull(driverStandingInfo);

        List<DriverStandingDto> driverStandings = dataClient.getDriverStandingEntries(driverStandingInfo.getChunkInfo());
        assertNotNull(driverStandings);
        assertEquals(driverStandingInfo.getChunkInfo().getRows(), driverStandings.size());
        log.info("fetched {} driver standings", driverStandings.size());
    }

    @Test
    void testGetDriverSeasonStandingsAll() {
        authenticate();
        DriverStandingsDto driverStandingInfo = dataClient.getSeasonDriverStandings(3225L, 1860L);
        assertNotNull(driverStandingInfo);

        List<DriverStandingDto> driverStandings = dataClient.getDriverStandingEntries(driverStandingInfo.getChunkInfo());
        assertNotNull(driverStandings);
        assertEquals(driverStandingInfo.getChunkInfo().getRows(), driverStandings.size());
        log.info("fetched {} driver standings", driverStandings.size());
    }

    @Test
    void testGetSupersessionSeasonStandings() {
        authenticate();
        DriverStandingsDto driverStandingInfo = dataClient.getSeasonSupersessionStandings(3464L, 1278L);
        assertNotNull(driverStandingInfo);

        List<DriverStandingDto> driverStandings = dataClient.getDriverStandingEntries(driverStandingInfo.getChunkInfo());
        assertNotNull(driverStandings);
        assertEquals(driverStandingInfo.getChunkInfo().getRows(), driverStandings.size());
        log.info("fetched {} driver standings", driverStandings.size());
    }

    @Test
    void testGetTeamSeasonStandings() {
        authenticate();
        DriverStandingsDto driverStandingInfo = dataClient.getSeasonTeamStandings(3225L, 1860L);
        assertNotNull(driverStandingInfo);

        List<TeamStandingDto> driverStandings = dataClient.getTeamStandingEntries(driverStandingInfo.getChunkInfo());
        assertNotNull(driverStandings);
        assertEquals(driverStandingInfo.getChunkInfo().getRows(), driverStandings.size());
        log.info("fetched {} team standings", driverStandings.size());
    }

    @Test
    void testGetTimeTrialSeasonStandings() {
        authenticate();
        DriverStandingsDto driverStandingInfo = dataClient.getSeasonTimeTrialStandings(3632L, 74L);
        assertNotNull(driverStandingInfo);

        List<DriverStandingDto> driverStandings = dataClient.getDriverStandingEntries(driverStandingInfo.getChunkInfo());
        assertNotNull(driverStandings);
        assertEquals(driverStandingInfo.getChunkInfo().getRows(), driverStandings.size());
        log.info("fetched {} driver standings", driverStandings.size());
    }

    @Test
    void testGetTimeTrialResults() {
        authenticate();
        DriverStandingsDto driverStandingInfo = dataClient.getSeasonTimeTrialResults(3632L, 74L, 0L);
        assertNotNull(driverStandingInfo);

        List<DriverTtStandingDto> driverStandings = dataClient.getTimeTrialStandingEntries(driverStandingInfo.getChunkInfo());
        assertNotNull(driverStandings);
        assertEquals(driverStandingInfo.getChunkInfo().getRows(), driverStandings.size());
        log.info("fetched {} driver standings", driverStandings.size());
    }

    @Test
    void testGetQualifyResults() {
        authenticate();
        DriverStandingsDto driverStandingInfo = dataClient.getSeasonQualifyResults(3632L, 74L, 0L);
        assertNotNull(driverStandingInfo);

        List<DriverQualifyStandingDto> driverStandings = dataClient.getQualifyStandingEntries(driverStandingInfo.getChunkInfo());
        assertNotNull(driverStandings);
        assertEquals(driverStandingInfo.getChunkInfo().getRows(), driverStandings.size());
        log.info("fetched {} driver standings", driverStandings.size());
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
    void testGetSeriesAssets() {
        authenticate();
        Map<Long, SeriesAssetDto> seriesAssetDtoMap = dataClient.getSeriesAssets();
        assertNotNull(seriesAssetDtoMap);
        assertTrue(seriesAssetDtoMap.size() > 0);

        log.info("got {} car asset infos", seriesAssetDtoMap.size());
    }

    @Test
    void testGetDivisions() {
        authenticate();
        ConstantDto[] constantDtos = dataClient.getDivisions();
        assertNotNull(constantDtos);
        assertTrue(constantDtos.length > 0);

        Arrays.asList(constantDtos).forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetEventTypes() {
        authenticate();
        ConstantDto[] constantDtos = dataClient.getEventTypes();
        assertNotNull(constantDtos);
        assertTrue(constantDtos.length > 0);

        Arrays.asList(constantDtos).forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetCategories() {
        authenticate();
        ConstantDto[] constantDtos = dataClient.getCategories();
        assertNotNull(constantDtos);
        assertTrue(constantDtos.length > 0);

        Arrays.asList(constantDtos).forEach(s -> log.info(s.toString()));
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
    void testGetLookup() {
        authenticate();
        LookupDto[] lookup = dataClient.getLookup(Arrays.asList(LookupTypes.values()));
        assertNotNull(lookup);
        assertTrue(lookup.length > 0);
        Arrays.asList(lookup).forEach(s -> log.info(s.toString()));
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
    void testGetLeagueMembershipFull() {
        authenticate();
        LeagueMembershipDto[] leagueInfoDto = dataClient.getLeagueMembership(true);
        assertNotNull(leagueInfoDto);
        assertNotNull(leagueInfoDto[0]);
        assertTrue(leagueInfoDto[0].getFullLeagueInfo().getRoster().length > 0);

        log.info("got league {} infos", leagueInfoDto[0].getLeagueName());
        Arrays.stream(leagueInfoDto[0].getFullLeagueInfo().getRoster())
                .filter(LeagueMemberDto::getAdmin)
                .forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetLeagueMembershipShort() {
        authenticate();
        LeagueMembershipDto[] leagueInfoDto = dataClient.getLeagueMembership();
        assertNotNull(leagueInfoDto);
    }

    @Test
    void testGetLeaguePointSystemLeagueAndSeason() {
        authenticate();
        LeaguePointSystemsDto pointSystemDto = dataClient.getLeaguePointSystems(3693L, 66994L);
        assertNotNull(pointSystemDto);
        assertTrue(pointSystemDto.getPointSystems().length > 0);

        Arrays.stream(pointSystemDto.getPointSystems())
                .forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetLeaguePointSystemLeague() {
        authenticate();
        LeaguePointSystemsDto pointSystemDto = dataClient.getLeaguePointSystems(3693L);
        assertNotNull(pointSystemDto);
        assertTrue(pointSystemDto.getPointSystems().length > 0);

        Arrays.stream(pointSystemDto.getPointSystems())
                .forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetLeagueSeasonsAll() {
        authenticate();
        LeagueSeasonsDto leagueSeasons = dataClient.getLeagueSeasons(3693L, true);
        assertNotNull(leagueSeasons);
        assertTrue(leagueSeasons.getSeasons().length > 0);

        Arrays.stream(leagueSeasons.getSeasons())
                .forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetLeagueSeasonsOnlyActive() {
        authenticate();
        LeagueSeasonsDto leagueSeasons = dataClient.getLeagueSeasons(3693L);
        assertNotNull(leagueSeasons);
        assertTrue(leagueSeasons.getSeasons().length > 0);

        Arrays.stream(leagueSeasons.getSeasons())
                .forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetLeagueSeasonStandingsCar() {
        authenticate();
        SeasonStandingsDto seasonStandings = dataClient.getLeagueSeasonStandings(3693L, 66994L, 2708L);
        assertNotNull(seasonStandings);
        assertTrue(seasonStandings.getSuccess());

        Arrays.stream(seasonStandings.getStandings().getDriverStandings())
                .forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetLeagueSeasonStandings() {
        authenticate();
        SeasonStandingsDto seasonStandings = dataClient.getLeagueSeasonStandings(3693L, 66994L);
        assertNotNull(seasonStandings);
        assertTrue(seasonStandings.getSuccess());

        Arrays.stream(seasonStandings.getStandings().getDriverStandings())
                .forEach(s -> log.info(s.toString()));
    }

    @Test
    void testGetLeagueSeasonSessionsResiltsOnly() {
        authenticate();
        LeagueSeasonSessionsDto seasonSessions = dataClient.getLeagueSeasonSessions(3693L, 66994L, true);
        assertNotNull(seasonSessions);
        assertTrue(seasonSessions.getSuccess());

        Arrays.stream(seasonSessions.getSessions())
                .forEach(s -> log.info(s.getLaunchAt().toString()));
    }

    @Test
    void testGetLeagueSeasonSessions() {
        authenticate();
        LeagueSeasonSessionsDto seasonSessions = dataClient.getLeagueSeasonSessions(3693L, 66994L);
        assertNotNull(seasonSessions);
        assertTrue(seasonSessions.getSuccess());

        Arrays.stream(seasonSessions.getSessions())
                .forEach(s -> log.info(s.getLaunchAt().toString()));
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
    void testGetSeriesStats() {
        authenticate();
        SeriesInfoDto[] seriesStats = dataClient.getSeriesStats();
        assertNotNull(seriesStats);
        assertTrue(seriesStats.length > 0);

        Arrays.stream(seriesStats).forEach(stats -> log.info("{}", stats.getSeriesName()));
        log.info("got {} series stats", seriesStats.length);
    }

    @Test
    void testGetSeries() {
        authenticate();
        SeriesDto[] series = dataClient.getSeries();
        assertNotNull(series);
        assertTrue(series.length > 0);

        Arrays.stream(series).forEach(stats -> log.info("{} ({})", stats.getSeriesName(), stats.getSeriesId()));
        log.info("got {} series stats", series.length);
    }

    @Test
    void testGetSeriesPastSeasons() {
        authenticate();
        SeriesPastSeasonsDto series = dataClient.getSeriesPastSeasons(139L);
        assertNotNull(series);
        assertTrue(series.getSuccess());
        assertTrue(series.getSeries().getSeasons().length > 0);

        Arrays.stream(series.getSeries().getSeasons()).forEach(stats -> log.info("{} ({})", stats.getSeasonName(), stats.getSeasonId()));
        log.info("got {} series seasons", series.getSeries().getSeasons().length);
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
        SubsessionResultDto subsessionResultDto = dataClient.getSubsessionResult(35673002L);
//        SubsessionResultDto subsessionResultDto = dataClient.getSubsessionResult(44975865L);
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
        LapDataDto lapDataDto = dataClient.getLapData(44975865L, 0L);
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

        List<EventLogEntryDto> eventLogEntries = dataClient.getEventLogEntries(eventLogDto.getChunkInfo());
        assertFalse(eventLogEntries.isEmpty());

        log.info("got {} event log entries", eventLogEntries.size());
        eventLogEntries.forEach(entry -> log.info(entry.toString()));
    }

    @Test
    void testGetSeasonResultsSeason() {
        authenticate();
        SeasonResultsDto seasonResults = dataClient.getSeasonResults(3390L);
        assertNotNull(seasonResults);
        assertTrue(seasonResults.getSuccess());

        log.info("{} races in week 11", seasonResults.getResultsList().length);
    }

    @Test
    void testGetSeasonResultsRace() {
        authenticate();
        SeasonResultsDto seasonResults = dataClient.getSeasonResults(3390L, DataApiConstants.EVENT_TYPE_RACE);
        assertNotNull(seasonResults);
        assertTrue(seasonResults.getSuccess());

        log.info("{} races in week 11", seasonResults.getResultsList().length);
    }

    @ParameterizedTest
    @MethodSource("eventTypeProvider")
    void testGetSeasonResultsRaceWeek(Long eventType) {
        authenticate();
        SeasonResultsDto seasonResults = dataClient.getSeasonResults(3390L, eventType, 11L);
        assertNotNull(seasonResults);
        assertTrue(seasonResults.getSuccess());

        log.info("{} races in week 11", seasonResults.getResultsList().length);
    }

    static List<Long> eventTypeProvider() {
        return Lists.list(DataApiConstants.EVENT_TYPE_RACE,
                DataApiConstants.EVENT_TYPE_PRACTICE,
                DataApiConstants.EVENT_TYPE_QUALIFY,
                DataApiConstants.EVENT_TYPE_TT);
    }

    @Test
    void testGetTeamMembers() {
        authenticate();
//        TeamInfoDto teamInfo = dataClient.getTeamMembers(129513L);
        TeamInfoDto teamInfo = dataClient.getTeamMembers(167074L);
        assertNotNull(teamInfo);

        Arrays.stream(teamInfo.getRoster()).forEach(member -> log.info("{}", member));
    }

    @Test
    void testGetMyLeagueSessions() {
        authenticate();
        CustLeagueSessionsDto sessionsDto = dataClient.getLeagueSessions(true);
        assertNotNull(sessionsDto);
        assertEquals(Boolean.TRUE, sessionsDto.getSuccess());
    }

    @Test
    void testGetAllLeagueSessions() {
        authenticate();
        CustLeagueSessionsDto sessionsDto = dataClient.getLeagueSessions(false);
        assertNotNull(sessionsDto);
        assertEquals(Boolean.TRUE, sessionsDto.getSuccess());
        log.info("fetched {} league sessions", sessionsDto.getSessions().length);
    }

    @Test
    void testGetJoinableLeagueSessionsForPackageId() {
        authenticate();
        JoinableSessionsDto sessionsDto = dataClient.getJoinableHostedSessions(67L);
        assertNotNull(sessionsDto);
        assertEquals(Boolean.TRUE, sessionsDto.getSuccess());
        assertEquals(67L, sessionsDto.getPackageId());
        assertNotNull(sessionsDto.getSessions());

        Arrays.stream(sessionsDto.getSessions()).forEach(session -> log.info("{}: {}", session.getLeagueName(), session.getSessionName()));
        log.info("fetched {} joinable sessions", sessionsDto.getSessions().length);
    }

    @Test
    void testGetAllJoinableLeagueSessions() {
        authenticate();
        JoinableSessionsDto sessionsDto = dataClient.getJoinableHostedSessions();
        assertNotNull(sessionsDto);
        assertEquals(Boolean.TRUE, sessionsDto.getSuccess());
        assertNotEquals(0, sessionsDto.getSessions().length);

        Arrays.stream(sessionsDto.getSessions()).forEach(session -> log.info("{}: {}", session.getLeagueName(), session.getSessionName()));
        log.info("fetched {} joinable sessions", sessionsDto.getSessions().length);
    }

    @Test
    void testGetDrivableHostedSessions() {
        authenticate();
        JoinableSessionsDto sessionsDto = dataClient.getDrivableHostedSessions();
        assertNotNull(sessionsDto);
        assertEquals(Boolean.TRUE, sessionsDto.getSuccess());
        assertNotEquals(0, sessionsDto.getSessions().length);

        Arrays.stream(sessionsDto.getSessions()).forEach(session -> log.info("{}: {}", session.getLeagueName(), session.getSessionName()));
        log.info("fetched {} driveable sessions", sessionsDto.getSessions().length);
    }

    @Test
    void testGetSpecialLeagueSessions() {
        authenticate();
        CustLeagueSessionsDto sessionsDto = dataClient.getLeagueSessions(false, 186L);
        assertNotNull(sessionsDto);
        assertEquals(Boolean.TRUE, sessionsDto.getSuccess());
        log.info("fetched {} league sessions", sessionsDto.getSessions().length);
    }

    @Test
    void testSearchLeagueDirectory() {
        authenticate();
        LeagueDirectoryDto directoryDto = dataClient.searchLeagueDirectory(LeagueSearchRequest.create()
                .withUpperBound(20L)
                .withLowerBound(1L));
        assertNotNull(directoryDto);
        assertEquals(20, directoryDto.getLeagueEntries().length);
        log.info("fetched {} league entries", directoryDto.getLeagueEntries().length);
    }

    @Test
    void testSearchHostedSessionResults() {
        authenticate();
        ResultSearchRequest searchRequest = HostedResultSearchRequest.create()
                .withSessionName("racing")
                .withStartRangeBegin(ZonedDateTime.now().minusDays(1));

        SearchResultDto resultDto = dataClient.searchHostedSeries(searchRequest);
        assertNotNull(resultDto);
        assertEquals(true, resultDto.getData().getSuccess());

        List<HostedSessionSearchResultDto> results = dataClient.getHostedResultEntries(resultDto.getData().getChunkInfo());
        log.info("fetched {} session results", results.size());
        results.stream()
                .sorted(Comparator.comparing(HostedSessionSearchResultDto::getStartTime))
                .forEach(result -> log.info(result.toString()));
        assertEquals(resultDto.getData().getChunkInfo().getRows(), results.size());
    }

    @Test
    void testSearchIRacingSessionResults() {
        authenticate();
        ResultSearchRequest searchRequest = SeriesResultSearchRequest.create()
                .withOfficialOnly(true)
                .withEventTypes(List.of(EventType.RACE))
                .withCategories(List.of(CategoryType.ROAD))
                .withStartRangeBegin(ZonedDateTime.now().minusHours(8));

        SearchResultDto resultDto = dataClient.searchIRacingSeries(searchRequest);
        assertNotNull(resultDto);
        assertEquals(true, resultDto.getData().getSuccess());

        List<SeriesSessionSearchResultDto> results = dataClient.getSeriesResultEntries(resultDto.getData().getChunkInfo());
        log.info("fetched {} session results", results.size());
        results.stream()
                .sorted(Comparator.comparing(SeriesSessionSearchResultDto::getStartTime))
                .forEach(result -> log.info(result.toString()));
        assertEquals(resultDto.getData().getChunkInfo().getRows(), results.size());
        log.info("fetched {} results", results.size());
    }

    @Test
    void testGetClubHistory() {
        authenticate();
        ClubHistoryDto[] clubHistory = dataClient.getClubHistory(2022L, 2L);

        assertNotNull(clubHistory);
        assertTrue(clubHistory.length > 0);

        Arrays.stream(clubHistory).forEach(entry -> log.info("{}", entry));
    }

    @Test
    void testGetCountries() {
        authenticate();
        CountryDto[] countries = dataClient.getCountries();

        assertNotNull(countries);
        assertTrue(countries.length > 0);

        Arrays.stream(countries).forEach(entry -> log.info("{}", entry));
    }

    @Test
    void testGetSeasonList() {
        authenticate();
        SeasonListDto seasonList = dataClient.getSeasonList(2022L, 2L);

        assertNotNull(seasonList);
        assertTrue(seasonList.getSeasons().length > 0);

        Arrays.stream(seasonList.getSeasons()).forEach(entry -> log.info("{}", entry));
    }

    @Test
    void testGetRaceGuideAll() {
        authenticate();
        RaceGuideDto raceGuide = dataClient.getRaceGuide();

        assertNotNull(raceGuide);
        assertEquals(Boolean.TRUE, raceGuide.getSuccess());
        assertTrue(raceGuide.getSessions().length > 0);

        Arrays.stream(raceGuide.getSessions()).forEach(entry -> log.info("{}", entry));
    }

    @Test
    void testGetRaceGuideForTomorrow() {
        ZonedDateTime from = ZonedDateTime.now().plusDays(1);

        authenticate();
        RaceGuideDto raceGuide = dataClient.getRaceGuide(from);

        assertNotNull(raceGuide);
        assertEquals(Boolean.TRUE, raceGuide.getSuccess());
        assertTrue(raceGuide.getSessions().length > 0);

        Arrays.stream(raceGuide.getSessions()).forEach(entry -> {
            log.info("{}", entry);
            assertTrue(entry.getStartTime().isAfter(from));
        });
    }

    @Test
    void testGetRaceGuideIncludeEnding() {
        ZonedDateTime from = ZonedDateTime.now().plusDays(1);

        authenticate();
        RaceGuideDto raceGuide = dataClient.getRaceGuide(from, true);

        assertNotNull(raceGuide);
        assertEquals(Boolean.TRUE, raceGuide.getSuccess());
        assertTrue(raceGuide.getSessions().length > 0);

        Arrays.stream(raceGuide.getSessions()).forEach(entry -> log.info("{}", entry));
    }

    @Test
    void testGetWorldRecords() {
        authenticate();
        MessagingDto<WorldRecordsDataDto> recordDataDto = dataClient.getWorldRecords(143L, 252L);
        assertNotNull(recordDataDto);
        assertTrue(recordDataDto.getData().getSuccess());

        log.info("lap chart session info: {}", recordDataDto.getData());

        List<DriverRecordDto> chartEntries = dataClient.getDriverRecords(recordDataDto.getData().getChunkInfo());
        assertFalse(chartEntries.isEmpty());

        chartEntries.forEach(entry -> log.info(entry.toString()));
    }

    @Test
    void testGetParticipationCredits() {
        authenticate();
        Map<String, Object>[] credits = dataClient.getParticipationCredits();

        log.info("participation credits: {}", (Object[]) credits);
        assertNotNull(credits);
    }

    @Test
    void testGetTimeAttackMemberResults() {
        authenticate();
        Map<String, Object>[] ta_results = dataClient.getTimeAttackSeasonResults(3779L);

        log.info("time attack member results: {}", (Object[]) ta_results);
        assertNotNull(ta_results);
    }

    @Test
    void testGetSpectatorSubsessionIds() {
        authenticate();
        SpectatorSubsessionIdsDto spectatorSubsessionIds = dataClient.getSpectatorSubsessionIds();
        assertNotNull(spectatorSubsessionIds);
        assertTrue(spectatorSubsessionIds.getSuccess());
        assertTrue(spectatorSubsessionIds.getSubsessionIds().length > 0);

        spectatorSubsessionIds = dataClient.getSpectatorSubsessionIds(5L);
        assertNotNull(spectatorSubsessionIds);
        assertTrue(spectatorSubsessionIds.getSuccess());
        assertTrue(spectatorSubsessionIds.getSubsessionIds().length > 0);
        log.info("ID's for race");
        Arrays.stream(spectatorSubsessionIds.getSubsessionIds()).forEach(id -> log.info(id.toString()));

        Long[] eventTypes = new Long[2];
        eventTypes[0] = 4L;
        eventTypes[1] = 5L;
        spectatorSubsessionIds = dataClient.getSpectatorSubsessionIds(eventTypes);
        assertNotNull(spectatorSubsessionIds);
        assertTrue(spectatorSubsessionIds.getSuccess());
        assertTrue(spectatorSubsessionIds.getSubsessionIds().length > 0);
        log.info("ID's for qualification and race");
        Arrays.stream(spectatorSubsessionIds.getSubsessionIds()).forEach(id -> log.info(id.toString()));
    }

    @Test
    void testGetMemberRecap() {
        authenticate();
        MemberRecapResultDto memberRecapResult = dataClient.getMemberRecap();
        assertNotNull(memberRecapResult);
        assertTrue(memberRecapResult.getSuccess());
        log.info("Current member recap: {}", memberRecapResult);

        memberRecapResult = dataClient.getMemberRecap(372473L);
        assertNotNull(memberRecapResult);
        assertTrue(memberRecapResult.getSuccess());
        log.info("Member {} recap: {}", 372473L, memberRecapResult);

        memberRecapResult = dataClient.getMemberRecap(229120L, 2022L);
        assertNotNull(memberRecapResult);
        assertTrue(memberRecapResult.getSuccess());
        log.info("Member {} recap for {}: {}", 229120L, 2022, memberRecapResult);

        memberRecapResult = dataClient.getMemberRecap(229120L, 2022L, 4L);
        assertNotNull(memberRecapResult);
        assertTrue(memberRecapResult.getSuccess());
        log.info("Member {} recap for {}/{}: {}", 229120L, 2022, 4, memberRecapResult);
    }

    @Test
    void testInvalidAuthenticationAndReauthentication() {
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
        if(log.isDebugEnabled()) {
            logSystemProperties();
        }
        if (!dataClient.isAuthenticated()) {
            LoginRequestDto dto = LoginRequestDto.builder()
                    .email(config.getUser())
                    .password(config.getPassword())
                    .build();
            dataClient.setLogResponseJson(config.getLogResponseJson());
            dataClient.setHashPassword(config.getHashPassword());
            AuthResponseDto authResponseDto = dataClient.authenticate(dto);
            log.info(authResponseDto.toString());
        }
    }

    @BeforeAll
    public static void proxyAuthentication() {
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("proxy", "proxy".toCharArray());
            }
        });

    }

    private void logSystemProperties() {
        System.getProperties().entrySet().stream()
                .sorted(Comparator.comparing(p-> p.getKey().toString()))
                .forEach(p -> log.debug("{}: {}", p.getKey(), p.getValue()));
    }
}

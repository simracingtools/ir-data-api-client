package de.bausdorf.simracing.irdataapi.client;

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

import de.bausdorf.simracing.irdataapi.model.*;
import de.bausdorf.simracing.irdataapi.model.search.LeagueSearchRequest;
import de.bausdorf.simracing.irdataapi.model.search.ResultSearchRequest;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public interface IrDataClient {
    void setLogResponseJson(@NonNull Boolean logResponse);

    boolean isLogResponseJson();

    void setHashPassword(@NonNull boolean hashPassword);

    boolean isHashPassword();

    AuthResponseDto authenticate(@NonNull LoginRequestDto requestDto);

    boolean isAuthenticated();

    MembersInfoDto getMembersInfo(@NonNull List<Long> custIds);

    UserInfoDto getUserInfo();

    MemberSummaryDto getMemberSummary();

    MemberSummaryDto getMemberSummary(@NonNull Long custId);

    MemberYearlyDto getMemberStatsYearly(@NonNull Long custId);

    MemberCareerDto getMemberCareer(@NonNull Long custId);

    MemberDivisonDto getMemberDivision(@NonNull Long seasonId, @NonNull Long eventType);

    MemberChartDataDto getMemberChartData(@NonNull Long custId, @NonNull CategoryType category, @NonNull ChartType chartType);

    DriverStandingsDto getSeasonDriverStandings(@NonNull Long seasonId, @NonNull Long carClassId);

    DriverStandingsDto getSeasonDriverStandings(@NonNull Long seasonId, @NonNull Long carClassId, @Nullable Long raceWeekNum);

    DriverStandingsDto getSeasonSupersessionStandings(@NonNull Long seasonId, @NonNull Long carClassId);

    DriverStandingsDto getSeasonSupersessionStandings(@NonNull Long seasonId, @NonNull Long carClassId, @Nullable Long raceWeekNum);

    DriverStandingsDto getSeasonTeamStandings(@NonNull Long seasonId, @NonNull Long carClassId);

    DriverStandingsDto getSeasonTimeTrialStandings(@NonNull Long seasonId, @NonNull Long carClassId, @Nullable Long raceWeekNum);

    DriverStandingsDto getSeasonTimeTrialStandings(@NonNull Long seasonId, @NonNull Long carClassId);

    DriverStandingsDto getSeasonTeamStandings(@NonNull Long seasonId, @NonNull Long carClassId, @Nullable Long raceWeekNum);

    DriverStandingsDto getSeasonTimeTrialResults(@NonNull Long seasonId, @NonNull Long carClassId, @NonNull Long raceWeekNum);

    DriverStandingsDto getSeasonQualifyResults(@NonNull Long seasonId, @NonNull Long carClassId, @NonNull Long raceWeekNum);

    MemberRecentRacesDto getMemberRecentRaces(@NonNull Long custId);

    MemberAwardDto[] getMemberAwards(@Nullable Long custId);

    CarInfoDto[] getCarInfo();

    CarClassDto[] getCarClasses();

    ConstantDto[] getDivisions();

    ConstantDto[] getCategories();

    ConstantDto[] getEventTypes();

    Map<Long, CarAssetDto> getCarAssets();

    Map<Long, TrackAssetDto> getTrackAssets();

    Map<Long, SeriesAssetDto> getSeriesAssets();

    LeagueInfoDto getLeagueInfo(long leagueId);

    SeasonDto[] getSeasonInfo(@NonNull Boolean includeSeries);

    SeriesInfoDto[] getSeriesStats();

    SeriesDto[] getSeries();

    SeriesPastSeasonsDto getSeriesPastSeasons(@NonNull Long seriesId);

    TrackInfoDto[] getTrackInfos();

    LicenseGroupDto[] getLicenseGroups();

    LookupDto[] getLookup(@NonNull List<LookupTypes> lookupTypes);

    ClubHistoryDto[] getClubHistory(@NonNull Long seasonYear, @NonNull Long seasonQuarter);

    CountryDto[] getCountries();

    SubsessionResultDto getSubsessionResult(@NonNull Long subsessionId);

    LapChartDto getLapChartData(@NonNull Long subsessionId, @NonNull Long simsessionNumber);

    LapDataDto getLapData(@NonNull Long subsessionId, @NonNull Long simsessionNumber);

    LapDataDto getLapData(@NonNull Long subsessionId, @NonNull Long simsessionNumber, @Nullable Long driverOrTeamId, boolean isTeamId);

    EventLogDto getEventLog(@NonNull Long subsessionId, @NonNull Long simsessionNumber);

    List<LapChartEntryDto> getLapEntries(@NonNull ChunkInfoDto chunkInfo);

    List<EventLogEntryDto> getEventLogEntries(@NonNull ChunkInfoDto chunkInfo);

    List<DriverStandingDto> getDriverStandingEntries(@NonNull ChunkInfoDto chunkInfo);

    List<TeamStandingDto> getTeamStandingEntries(@NonNull ChunkInfoDto chunkInfo);

    List<DriverTtStandingDto> getTimeTrialStandingEntries(@NonNull ChunkInfoDto chunkInfo);

    List<DriverQualifyStandingDto> getQualifyStandingEntries(@NonNull ChunkInfoDto chunkInfo);

    SeasonListDto getSeasonList(@NonNull Long seasonYear, @NonNull Long seasonQuarter);

    SeasonResultsDto getSeasonResults(@NonNull Long seasonId);

    SeasonResultsDto getSeasonResults(@NonNull Long seasonId, @NonNull Long eventType);

    SeasonResultsDto getSeasonResults(@NonNull Long seasonId, @Nullable Long eventType, @Nullable Long raceWeekNum);

    TeamInfoDto getTeamMembers(@NonNull Long teamId);

    CustLeagueSessionsDto getLeagueSessions(@NonNull Boolean mine);

    CustLeagueSessionsDto getLeagueSessions(@NonNull Boolean mine, @Nullable Long packageId);

    LeagueDirectoryDto searchLeagueDirectory(@NonNull LeagueSearchRequest searchRequest);

    LeaguePointSystemsDto getLeaguePointSystems(@NonNull Long leagueId, @Nullable Long seasonId);

    LeaguePointSystemsDto getLeaguePointSystems(@NonNull Long leagueId);

    LeagueSeasonsDto getLeagueSeasons(@NonNull Long leagueId, @Nullable Boolean retired);

    LeagueSeasonsDto getLeagueSeasons(@NonNull Long leagueId);

    SeasonStandingsDto getLeagueSeasonStandings(@NonNull Long leagueId, @NonNull Long seasonId, @Nullable Long carClassId, @Nullable Long carId);

    SeasonStandingsDto getLeagueSeasonStandings(@NonNull Long leagueId, @NonNull Long seasonId, @Nullable Long carClassId);

    SeasonStandingsDto getLeagueSeasonStandings(@NonNull Long leagueId, @NonNull Long seasonId);

    LeagueSeasonSessionsDto getLeagueSeasonSessions(@NonNull Long leagueId, @NonNull Long seasonId, @Nullable Boolean resultsOnly);

    LeagueSeasonSessionsDto getLeagueSeasonSessions(@NonNull Long leagueId, @NonNull Long seasonId);

    SearchResultDto searchHostedSeries(@NonNull ResultSearchRequest searchRequest);

    List<HostedSessionSearchResultDto> getHostedResultEntries(@NonNull ChunkInfoDto chunkInfo);

    SearchResultDto searchIRacingSeries(@NonNull ResultSearchRequest searchRequest);

    List<SeriesSessionSearchResultDto> getSeriesResultEntries(@NonNull ChunkInfoDto chunkInfo);

    MessagingDto<WorldRecordsDataDto> getWorldRecords(@NonNull Long carId, @NonNull Long trackId);

    MessagingDto<WorldRecordsDataDto> getWorldRecords(@NonNull Long carId, @NonNull Long trackId, @Nullable Long seasonYear, @Nullable Long seasonQuarter);

    List<DriverRecordDto> getDriverRecords(@NonNull ChunkInfoDto chunkInfo);

    LeagueMembershipDto[] getLeagueMembership();

    LeagueMembershipDto[] getLeagueMembership(@NonNull Boolean includeCompleteLeagueInfo);

    JoinableSessionsDto getJoinableHostedSessions();

    JoinableSessionsDto getJoinableHostedSessions(@NonNull Long packageId);

    JoinableSessionsDto getDrivableHostedSessions();

    RaceGuideDto getRaceGuide();

    RaceGuideDto getRaceGuide(@Nullable ZonedDateTime from);

    RaceGuideDto getRaceGuide(@Nullable ZonedDateTime from, @NonNull Boolean includeEndAfterFrom);

    MemberProfileDto getMemberProfile(@Nullable Long custId);

    MemberBestsDto getMemberBests(@Nullable Long custId, @Nullable Long carId);

    MemberInfoDto[] getDriverLookup(@NonNull String searchTerm);

    MemberInfoDto[] getDriverLookup(@NonNull String searchTerm, @Nullable Long leagueId);
}

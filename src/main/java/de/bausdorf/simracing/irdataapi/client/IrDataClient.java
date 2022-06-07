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
import de.bausdorf.simracing.irdataapi.model.web.LeagueSessionsDto;
import de.bausdorf.simracing.irdataapi.model.web.TeamMemberDto;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

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

    DriverStandingsDto getSeasonDriverStandings(@NonNull Long seasonId, @NonNull Long carClassId);

    DriverStandingsDto getSeasonDriverStandings(@NonNull Long seasonId, @NonNull Long carClassId, Long raceWeekNum);

    DriverStandingsDto getSeasonSupersessionStandings(@NonNull Long seasonId, @NonNull Long carClassId);

    DriverStandingsDto getSeasonSupersessionStandings(@NonNull Long seasonId, @NonNull Long carClassId, Long raceWeekNum);

    DriverStandingsDto getSeasonTeamStandings(@NonNull Long seasonId, @NonNull Long carClassId);

    DriverStandingsDto getSeasonTimeTrialStandings(@NonNull Long seasonId, @NonNull Long carClassId, Long raceWeekNum);

    DriverStandingsDto getSeasonTimeTrialStandings(@NonNull Long seasonId, @NonNull Long carClassId);

    DriverStandingsDto getSeasonTeamStandings(@NonNull Long seasonId, @NonNull Long carClassId, Long raceWeekNum);

    DriverStandingsDto getSeasonTimeTrialResults(@NonNull Long seasonId, @NonNull Long carClassId, @NonNull Long raceWeekNum);

    DriverStandingsDto getSeasonQualifyResults(@NonNull Long seasonId, @NonNull Long carClassId, @NonNull Long raceWeekNum);

    MemberRecentRacesDto getMemberRecentRaces(@NonNull Long custId);

    CarInfoDto[] getCarInfo();

    CarClassDto[] getCarClasses();

    DivisionDto[] getDivisions();

    Map<Long, CarAssetDto> getCarAssets();

    Map<Long, TrackAssetDto> getTrackAssets();

    LeagueInfoDto getLeagueInfo(long leagueId);

    SeasonDto[] getSeasonInfo(Boolean includeSeries);
    SeriesInfoDto[] getSeriesStats();
    TrackInfoDto[] getTrackInfos();

    LicenseGroupDto[] getLicenseGroups();

    LookupDto[] getLookup(List<LookupTypes> lookupTypes);

    SubsessionResultDto getSubsessionResult(@NonNull Long subsessionId);

    LapChartDto getLapChartData(@NonNull Long subsessionId, @NonNull Long simsessionNumber);

    LapDataDto getLapData(@NonNull Long subsessionId, @NonNull Long simsessionNumber);

    LapDataDto getLapData(@NonNull Long subsessionId, @NonNull Long simsessionNumber, @Nullable Long driverOrTeamId, boolean isTeamId);

    EventLogDto getEventLog(@NonNull Long subsessionId, @NonNull Long simsessionNumber);

    List<LapChartEntryDto> getLapEntries(@NonNull ChunkInfoDto chunkInfo);

    List<EventLogEntry> getEventLogEntries(@NonNull ChunkInfoDto chunkInfo);

    List<DriverStandingDto> getDriverStandingEntries(@NonNull ChunkInfoDto chunkInfo);

    List<TeamStandingDto> getTeamStandingEntries(@NonNull ChunkInfoDto chunkInfo);

    List<DriverTtStandingDto> getTimeTrialStandingEntries(@NonNull ChunkInfoDto chunkInfo);

    List<DriverQualifyStandingDto> getQualifyStandingEntries(@NonNull ChunkInfoDto chunkInfo);

    SeasonResultsDto getSeasonResults(@NonNull Long seasonId);

    SeasonResultsDto getSeasonResults(@NonNull Long seasonId, @NonNull Long eventType);

    SeasonResultsDto getSeasonResults(@NonNull Long seasonId, Long eventType, Long raceWeekNum);

    TeamMemberDto[] getTeamMembers(@NonNull Long teamId);

    LeagueSessionsDto getLeagueSessions();
}

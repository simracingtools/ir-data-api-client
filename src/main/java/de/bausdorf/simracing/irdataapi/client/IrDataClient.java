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
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Map;

public interface IrDataClient {
    void setLogResponseJson(@NonNull Boolean logResponse);

    boolean isLogResponseJson();

    AuthResponseDto authenticate(@NonNull LoginRequestDto requestDto);

    boolean isAuthenticated();

    MembersInfoDto getMembersInfo(@NonNull List<Long> custIds);

    MemberSummaryDto getMemberSummary();

    MemberSummaryDto getMemberSummary(@NonNull Long custId);

    MemberYearlyDto getMemberStatsYearly(@NonNull Long custId);

    MemberCareerDto getMemberCareer(@NonNull Long custId);

    MemberRecentRacesDto getMemberRecentRaces(@NonNull Long custId);

    CarInfoDto[] getCarInfo();

    CarClassDto[] getCarClasses();

    DivisionDto[] getDivisions();

    Map<Long, CarAssetDto> getCarAssets();

    Map<Long, TrackAssetDto> getTrackAssets();

    LeagueInfoDto getLeagueInfo(long leagueId);

    SeasonDto[] getSeasonInfo(Boolean includeSeries);

    TrackInfoDto[] getTrackInfos();

    LicenseGroupDto[] getLicenseGroups();

    SubsessionResultDto getSubsessionResult(@NonNull Long subsessionId);

    LapChartDto getLapChartData(@NonNull Long subsessionId, @NonNull Long simsessionNumber);

    LapDataDto getLapData(@NonNull Long subsessionId, @NonNull Long simsessionNumber);

    LapDataDto getLapData(@NonNull Long subsessionId, @NonNull Long simsessionNumber, @NonNull Long driverOrTeamId, boolean isTeamId);

    EventLogDto getEventLog(@NonNull Long subsessionId, @NonNull Long simsessionNumber);

    List<LapChartEntryDto> getLapEntries(@NonNull ChunkInfoDto chunkInfo);

    List<EventLogEntry> getEventLogEntries(@NonNull ChunkInfoDto chunkInfo);

    SeasonResultsDto getSeasonResults(@NonNull Long seasonId);

    SeasonResultsDto getSeasonResults(@NonNull Long seasonId, @NonNull Long eventType);

    SeasonResultsDto getSeasonResults(@NonNull Long seasonId, Long eventType, Long raceWeekNum);
}

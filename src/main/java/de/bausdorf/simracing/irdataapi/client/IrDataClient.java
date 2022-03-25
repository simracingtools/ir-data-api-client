package de.bausdorf.simracing.irdataapi.client;

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
}

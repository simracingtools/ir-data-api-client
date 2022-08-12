package de.bausdorf.simracing.irdataapi.client.impl;

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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import de.bausdorf.simracing.irdataapi.client.*;
import de.bausdorf.simracing.irdataapi.model.*;
import de.bausdorf.simracing.irdataapi.model.search.LeagueSearchRequest;
import de.bausdorf.simracing.irdataapi.model.search.ResultSearchRequest;
import de.bausdorf.simracing.irdataapi.tools.LoginHelper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.*;

@Slf4j
public class IrDataClientImpl implements IrDataClient {

    public static final String RETURNED_NULL_BODY = " returned null body";
    public static final String SUBSESSION_ID_URL_PARAM = "?subsession_id=";
    public static final String SIMSESSION_NUMBER_URL_PARAM = "&simsession_number=";
    public static final String SEASON_ID_URL_PARAM = "?season_id=";
    public static final String EVENT_TYPE_URL_PARAM = "&event_type=";
    public static final String RACE_WEEK_NUM_URL_PARAM = "&race_week_num=";
    public static final String CAR_CLASS_ID_URL_PARAM = "&car_class_id=";
    public static final String LEAGUE_ID_URL_PARAM = "?league_id=";
    public static final String SEASON_ID_URL_PARAM2 = "&season_id=";
    public static final String SEASON_YEAR_URL_PARAM = "?season_year=";
    public static final String SEASON_QUARTER_URL_PARAM = "&season_quarter=";
    private final RestTemplate restTemplate;
    private final StatefulRestTemplateInterceptor restTemplateInterceptor;
    private final IRacingObjectMapper mapper;

    private AuthResponseDto authResponse;
    private boolean logResponseJson = false;
    private boolean hashPassword = true;
    private final Logger jsonLogger = LoggerFactory.getLogger("JsonResponse");

    public IrDataClientImpl() {
        restTemplate = new RestTemplate();
        restTemplateInterceptor = new StatefulRestTemplateInterceptor();
        restTemplate.getInterceptors().add(restTemplateInterceptor);
        mapper = new IRacingObjectMapper();
        authResponse = null;
    }

    @Override
    public void setLogResponseJson(@NonNull Boolean logResponse) {
        this.logResponseJson = logResponse;
    }

    @Override
    public boolean isLogResponseJson() {
        return logResponseJson;
    }

    @Override
    public void setHashPassword(boolean hashPassword) {
        this.hashPassword = hashPassword;
    }

    @Override
    public boolean isHashPassword() {
        return hashPassword;
    }

    @Override
    public AuthResponseDto authenticate(@NonNull LoginRequestDto requestDto) {
        restTemplateInterceptor.flushCookies();
        ResponseEntity<String> response = restTemplate.postForEntity(DataApiConstants.AUTH_URL,
                hashPassword ? LoginHelper.hashPassword(requestDto) : requestDto,
                String.class);
        try {
            String responseBody = response.getBody();
            if (responseBody != null) {
                authResponse = mapper.readValue(responseBody, AuthResponseDto.class);
                if (authResponse.getAuthcode().equalsIgnoreCase("0")) {
                    throw new AuthorizationException(requestDto.getEmail() + " not authorized");
                }
                log.info("iRacing DataApi authenticated for custId: {}", authResponse.getCustId());
            } else {
                throw new DataApiException("Null body when authenticating, status code " + response.getStatusCode());
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return authResponse;
    }

    @Override
    public boolean isAuthenticated() {
        return authResponse != null;
    }

    @Override
    public MembersInfoDto getMembersInfo(@NonNull List<Long> custIds) {
        var uri = new StringBuilder(DataApiConstants.GET_MEMBERS_URL);
        uri.append("?cust_ids=");
        for (var i = 0; i < custIds.size(); i++) {
            uri.append(custIds.get(i));
            if (i < custIds.size() - 1) {
                uri.append(',');
            }
        }

        try {
            LinkResponseDto linkResponse = getLinkResponse(uri.toString());

            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MembersInfoDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_MEMBERS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public UserInfoDto getUserInfo() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_USERINFO_URL);

            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<UserInfoDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_USERINFO_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public MemberSummaryDto getMemberSummary() {
        return getMemberSummary(null);
    }

    @Override
    public MemberSummaryDto getMemberSummary(Long custId) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(custId != null
                    ? uriWithCustIdParameter(DataApiConstants.GET_MEMBER_SUMMARY_URL, custId)
                    : DataApiConstants.GET_MEMBER_SUMMARY_URL);

            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MemberSummaryDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_MEMBER_SUMMARY_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public MemberYearlyDto getMemberStatsYearly(@NonNull Long custId) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(uriWithCustIdParameter(DataApiConstants.GET_MEMBER_YEARLY_URL, custId));

            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MemberYearlyDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_MEMBER_YEARLY_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public MemberCareerDto getMemberCareer(@NonNull Long custId) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(uriWithCustIdParameter(DataApiConstants.GET_MEMBER_CAREER_URL, custId));

            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MemberCareerDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_MEMBER_CAREER_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public MemberChartDataDto getMemberChartData(Long custId, CategoryType category, ChartType chartType) {
        try {
            StringBuilder uri = new StringBuilder(uriWithCustIdParameter(DataApiConstants.GET_MEMBER_CHART_URL, custId));
            uri.append("&category_id=").append(category.toString());
            uri.append("&chart_type=").append(chartType.toString());

            LinkResponseDto linkResponse = getLinkResponse(uri.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MemberChartDataDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_MEMBER_CHART_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public MemberDivisonDto getMemberDivision(Long seasonId, Long eventType) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_MEMBER_DIVISION_URL
                    + SEASON_ID_URL_PARAM + seasonId.toString()
                    + EVENT_TYPE_URL_PARAM + eventType.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MemberDivisonDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_MEMBER_DIVISION_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public DriverStandingsDto getSeasonDriverStandings(Long seasonId, Long carClassId) {
        return getSeasonDriverStandings(seasonId, carClassId, null);
    }

    @Override
    public DriverStandingsDto getSeasonDriverStandings(Long seasonId, Long carClassId, Long raceWeekNum) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_DRIVER_STANDINGS_URL
                    + SEASON_ID_URL_PARAM + seasonId.toString()
                    + CAR_CLASS_ID_URL_PARAM + carClassId.toString()
                    + (raceWeekNum != null ? RACE_WEEK_NUM_URL_PARAM + raceWeekNum : ""));
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<DriverStandingsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_DRIVER_STANDINGS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public DriverStandingsDto getSeasonSupersessionStandings(Long seasonId, Long carClassId) {
        return getSeasonSupersessionStandings(seasonId, carClassId, null);
    }

    @Override
    public DriverStandingsDto getSeasonSupersessionStandings(Long seasonId, Long carClassId, Long raceWeekNum) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_SUPERSESSION_STANDINGS_URL
                    + SEASON_ID_URL_PARAM + seasonId.toString()
                    + CAR_CLASS_ID_URL_PARAM + carClassId.toString()
                    + (raceWeekNum != null ? RACE_WEEK_NUM_URL_PARAM + raceWeekNum : ""));
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<DriverStandingsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_SUPERSESSION_STANDINGS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public DriverStandingsDto getSeasonTeamStandings(Long seasonId, Long carClassId) {
        return getSeasonTeamStandings(seasonId, carClassId, null);
    }

    @Override
    public DriverStandingsDto getSeasonTimeTrialStandings(Long seasonId, Long carClassId, Long raceWeekNum) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_TT_STANDINGS_URL
                    + SEASON_ID_URL_PARAM + seasonId.toString()
                    + CAR_CLASS_ID_URL_PARAM + carClassId.toString()
                    + (raceWeekNum != null ? RACE_WEEK_NUM_URL_PARAM + raceWeekNum : ""));
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<DriverStandingsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_TT_STANDINGS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public DriverStandingsDto getSeasonTimeTrialResults(Long seasonId, Long carClassId, Long raceWeekNum) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_TT_RESULTS_URL
                    + SEASON_ID_URL_PARAM + seasonId.toString()
                    + CAR_CLASS_ID_URL_PARAM + carClassId.toString()
                    + RACE_WEEK_NUM_URL_PARAM + raceWeekNum.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<DriverStandingsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_TT_RESULTS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public DriverStandingsDto getSeasonQualifyResults(Long seasonId, Long carClassId, Long raceWeekNum) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_QUALIFY_RESULTS_URL
                    + SEASON_ID_URL_PARAM + seasonId.toString()
                    + CAR_CLASS_ID_URL_PARAM + carClassId.toString()
                    + RACE_WEEK_NUM_URL_PARAM + raceWeekNum.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<DriverStandingsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_QUALIFY_RESULTS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public DriverStandingsDto getSeasonTimeTrialStandings(Long seasonId, Long carClassId) {
        return getSeasonTimeTrialStandings(seasonId, carClassId, null);
    }

    @Override
    public DriverStandingsDto getSeasonTeamStandings(Long seasonId, Long carClassId, Long raceWeekNum) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_TEAM_STANDINGS_URL
                    + SEASON_ID_URL_PARAM + seasonId.toString()
                    + CAR_CLASS_ID_URL_PARAM + carClassId.toString()
                    + (raceWeekNum != null ? RACE_WEEK_NUM_URL_PARAM + raceWeekNum : ""));
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<DriverStandingsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_TEAM_STANDINGS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public MemberRecentRacesDto getMemberRecentRaces(@NonNull Long custId) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(uriWithCustIdParameter(DataApiConstants.GET_MEMBER_RECENT_RACES_URL, custId));

            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MemberRecentRacesDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_MEMBER_RECENT_RACES_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public CarInfoDto[] getCarInfo() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_CARS_URL);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<CarInfoDto[]>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_CARS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public CarClassDto[] getCarClasses() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_CAR_CLASSES_URL);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<CarClassDto[]>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_CAR_CLASSES_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public ConstantDto[] getDivisions() {
        try {
            return getStructuredData(DataApiConstants.GET_DIVISIONS_URL, new TypeReference<ConstantDto[]>() {
            });
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public ConstantDto[] getCategories() {
        try {
            return getStructuredData(DataApiConstants.GET_CATEGORIES_URL, new TypeReference<ConstantDto[]>() {
            });
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public ConstantDto[] getEventTypes() {
        try {
            return getStructuredData(DataApiConstants.GET_EVENT_TYPES_URL, new TypeReference<ConstantDto[]>() {
            });
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public Map<Long, CarAssetDto> getCarAssets() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_CAR_ASSETS_URL);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<HashMap<Long, CarAssetDto>>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_CAR_ASSETS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public Map<Long, TrackAssetDto> getTrackAssets() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_TRACK_ASSETS_URL);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<HashMap<Long, TrackAssetDto>>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_TRACK_ASSETS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public Map<Long, SeriesAssetDto> getSeriesAssets() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_SERIES_ASSETS_URL);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<HashMap<Long, SeriesAssetDto>>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_SERIES_ASSETS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LeagueInfoDto getLeagueInfo(long leagueId) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_LEAGUE_URL + LEAGUE_ID_URL_PARAM + leagueId);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LeagueInfoDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_LEAGUE_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public SeasonDto[] getSeasonInfo(Boolean includeSeries) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_SEASONS_URL + "?include_series=" + includeSeries.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<SeasonDto[]>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_SEASONS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public SeriesInfoDto[] getSeriesStats() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_SERIES_STATS_URL);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<SeriesInfoDto[]>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_SERIES_STATS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public SeriesDto[] getSeries() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_SERIES_URL);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<SeriesDto[]>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_SERIES_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public TrackInfoDto[] getTrackInfos() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_TRACKS_URL);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<TrackInfoDto[]>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_TRACKS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LicenseGroupDto[] getLicenseGroups() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_LICENSES_URL);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LicenseGroupDto[]>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_LICENSES_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LookupDto[] getLookup(List<LookupTypes> lookupTypes) {
        try {
            StringBuilder url = new StringBuilder(DataApiConstants.GET_LOOKUP_URL);
            for (int i = 0; i < lookupTypes.size(); i++) {
                if (i == 0) {
                    url.append('?');
                } else {
                    url.append('&');
                }
                url.append(lookupTypes.get(i).toUrlParameters());
            }
            LinkResponseDto linkResponse = getLinkResponse(url.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LookupDto[]>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_LOOKUP_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public ClubHistoryDto[] getClubHistory(Long seasonYear, Long seasonQuarter) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(
                    DataApiConstants.GET_CLUB_HISTORY_URL + SEASON_YEAR_URL_PARAM + seasonYear
                            + SEASON_QUARTER_URL_PARAM + seasonQuarter);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<ClubHistoryDto[]>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_CLUB_HISTORY_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public CountryDto[] getCountries() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_COUNTRIES_URL);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<CountryDto[]>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_COUNTRIES_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public SubsessionResultDto getSubsessionResult(Long subsessionId) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(
                    DataApiConstants.GET_SUBSESSION_RESULT_URL + SUBSESSION_ID_URL_PARAM + subsessionId.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<SubsessionResultDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_SUBSESSION_RESULT_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LapChartDto getLapChartData(Long subsessionId, Long simsessionNumber) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_LAP_CHART_DATA_URL
                    + SUBSESSION_ID_URL_PARAM + subsessionId.toString()
                    + SIMSESSION_NUMBER_URL_PARAM + simsessionNumber.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LapChartDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_LAP_CHART_DATA_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LapDataDto getLapData(Long subsessionId, Long simsessionNumber) {
        return getLapData(subsessionId, simsessionNumber, null, false);
    }

    @Override
    public LapDataDto getLapData(Long subsessionId, Long simsessionNumber, Long driverOrTeamId, boolean isTeamId) {
        try {
            StringBuilder uri = new StringBuilder(DataApiConstants.GET_LAP_DATA_URL)
                    .append(SUBSESSION_ID_URL_PARAM).append(subsessionId)
                    .append(SIMSESSION_NUMBER_URL_PARAM).append(simsessionNumber);
            if (driverOrTeamId != null) {
                if (isTeamId) {
                    uri.append("&team_id=").append(driverOrTeamId);
                } else {
                    uri.append("&cust_id=").append(driverOrTeamId);
                }
            }

            LinkResponseDto linkResponse = getLinkResponse(uri.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LapDataDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_LAP_DATA_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public EventLogDto getEventLog(Long subsessionId, Long simsessionNumber) {
        try {
            String uri = DataApiConstants.GET_EVENT_LOG_URL +
                    SUBSESSION_ID_URL_PARAM + subsessionId +
                    SIMSESSION_NUMBER_URL_PARAM + simsessionNumber;

            LinkResponseDto linkResponse = getLinkResponse(uri);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<EventLogDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_LAP_DATA_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public List<LapChartEntryDto> getLapEntries(@NonNull ChunkInfoDto chunkInfo) {
        return getChunkedEntries(chunkInfo, new TypeReference<LapChartEntryDto[]>() {
        });
    }

    @Override
    public List<EventLogEntryDto> getEventLogEntries(ChunkInfoDto chunkInfo) {
        return getChunkedEntries(chunkInfo, new TypeReference<EventLogEntryDto[]>() {
        });
    }

    @Override
    public List<DriverStandingDto> getDriverStandingEntries(ChunkInfoDto chunkInfo) {
        return getChunkedEntries(chunkInfo, new TypeReference<DriverStandingDto[]>() {
        });
    }

    @Override
    public List<TeamStandingDto> getTeamStandingEntries(ChunkInfoDto chunkInfo) {
        return getChunkedEntries(chunkInfo, new TypeReference<TeamStandingDto[]>() {
        });
    }

    @Override
    public List<DriverTtStandingDto> getTimeTrialStandingEntries(ChunkInfoDto chunkInfo) {
        return getChunkedEntries(chunkInfo, new TypeReference<DriverTtStandingDto[]>() {
        });
    }

    @Override
    public List<DriverQualifyStandingDto> getQualifyStandingEntries(ChunkInfoDto chunkInfo) {
        return getChunkedEntries(chunkInfo, new TypeReference<DriverQualifyStandingDto[]>() {
        });
    }

    @Override
    public SeasonListDto getSeasonList(Long seasonYear, Long seasonQuarter) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(
                    DataApiConstants.GET_SEASON_LIST_URL + SEASON_YEAR_URL_PARAM + seasonYear +
                            SEASON_QUARTER_URL_PARAM + seasonQuarter);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<SeasonListDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_SEASON_LIST_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public SeasonResultsDto getSeasonResults(Long seasonId) {
        return getSeasonResults(seasonId, null, null);
    }

    @Override
    public SeasonResultsDto getSeasonResults(Long seasonId, Long eventType) {
        return getSeasonResults(seasonId, eventType, null);
    }

    @Override
    public SeasonResultsDto getSeasonResults(Long seasonId, Long eventType, Long raceWeekNum) {
        try {
            StringBuilder uri = new StringBuilder(DataApiConstants.GET_SEASON_RESULTS_URL)
                    .append(SEASON_ID_URL_PARAM).append(seasonId);
            if (eventType != null) {
                uri.append(EVENT_TYPE_URL_PARAM).append(eventType);
            }
            if (raceWeekNum != null) {
                uri.append(RACE_WEEK_NUM_URL_PARAM).append(raceWeekNum);
            }

            LinkResponseDto linkResponse = getLinkResponse(uri.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<SeasonResultsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_SEASON_RESULTS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public TeamInfoDto getTeamMembers(Long teamId) {
        try {
            StringBuilder uri = new StringBuilder(DataApiConstants.GET_TEAM_MEMBERS_URL)
                    .append("?team_id=").append(teamId);
            LinkResponseDto linkResponse = getLinkResponse(uri.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<TeamInfoDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_TEAM_MEMBERS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public CustLeagueSessionsDto getLeagueSessions(@NonNull Boolean mine) {
        return getLeagueSessions(mine, null);
    }

    @Override
    public CustLeagueSessionsDto getLeagueSessions(@NonNull Boolean mine, @Nullable Long packageId) {
        try {
            StringBuilder uri = new StringBuilder(DataApiConstants.GET_CUST_LEAGUE_SESSIONS_URL)
                    .append("?mine=").append(mine);
            if (packageId != null) {
                uri.append("&package_id=").append(packageId);
            }
            LinkResponseDto linkResponse = getLinkResponse(uri.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<CustLeagueSessionsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_CUST_LEAGUE_SESSIONS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LeagueDirectoryDto searchLeagueDirectory(LeagueSearchRequest searchRequest) {
        try {
            String uri = DataApiConstants.SEARCH_LEAGUE_DIRECTORY_URL + searchRequest.toQueryString();
            LinkResponseDto linkResponse = getLinkResponse(uri);
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LeagueDirectoryDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.SEARCH_LEAGUE_DIRECTORY_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LeaguePointSystemsDto getLeaguePointSystems(Long leagueId, Long seasonId) {
        try {
            StringBuilder uri = new StringBuilder(DataApiConstants.GET_LEAGUE_POINT_SYSTEMS_URL)
                    .append(LEAGUE_ID_URL_PARAM).append(leagueId);
            if (seasonId != null) {
                uri.append(SEASON_ID_URL_PARAM2).append(seasonId);
            }
            LinkResponseDto linkResponse = getLinkResponse(uri.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LeaguePointSystemsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_LEAGUE_POINT_SYSTEMS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LeaguePointSystemsDto getLeaguePointSystems(Long leagueId) {
        return getLeaguePointSystems(leagueId, null);
    }

    @Override
    public LeagueSeasonsDto getLeagueSeasons(Long leagueId, Boolean retired) {
        try {
            StringBuilder uri = new StringBuilder(DataApiConstants.GET_LEAGUE_SEASONS_URL)
                    .append(LEAGUE_ID_URL_PARAM).append(leagueId);
            if (retired != null) {
                uri.append("&retired=").append(retired);
            }
            LinkResponseDto linkResponse = getLinkResponse(uri.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LeagueSeasonsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_LEAGUE_SEASONS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LeagueSeasonsDto getLeagueSeasons(Long leagueId) {
        return getLeagueSeasons(leagueId, null);
    }

    @Override
    public SeasonStandingsDto getLeagueSeasonStandings(Long leagueId, Long seasonId, Long carClassId, Long carId) {
        try {
            StringBuilder uri = new StringBuilder(DataApiConstants.GET_LEAGUE_SEASON_STANDINGS_URL)
                    .append(LEAGUE_ID_URL_PARAM).append(leagueId)
                    .append(SEASON_ID_URL_PARAM2).append(seasonId);
            if (carClassId != null) {
                uri.append(CAR_CLASS_ID_URL_PARAM).append(carClassId);
            }
            if (carId != null) {
                uri.append("&car_id=").append(carId);
            }
            LinkResponseDto linkResponse = getLinkResponse(uri.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<SeasonStandingsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_LEAGUE_SEASON_STANDINGS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public SeasonStandingsDto getLeagueSeasonStandings(Long leagueId, Long seasonId, Long carClassId) {
        return getLeagueSeasonStandings(leagueId, seasonId, carClassId, null);
    }

    @Override
    public SeasonStandingsDto getLeagueSeasonStandings(Long leagueId, Long seasonId) {
        return getLeagueSeasonStandings(leagueId, seasonId, null, null);
    }

    @Override
    public LeagueSeasonSessionsDto getLeagueSeasonSessions(Long leagueId, Long seasonId, Boolean resultsOnly) {
        try {
            StringBuilder uri = new StringBuilder(DataApiConstants.GET_LEAGUE_SESSIONS_URL)
                    .append(LEAGUE_ID_URL_PARAM).append(leagueId)
                    .append(SEASON_ID_URL_PARAM2).append(seasonId);
            if (resultsOnly != null) {
                uri.append("&results_only=").append(resultsOnly);
            }
            LinkResponseDto linkResponse = getLinkResponse(uri.toString());
            if (linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LeagueSeasonSessionsDto>() {
                });
            }
            throw new DataApiException(DataApiConstants.GET_LEAGUE_SESSIONS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LeagueSeasonSessionsDto getLeagueSeasonSessions(Long leagueId, Long seasonId) {
        return getLeagueSeasonSessions(leagueId, seasonId, null);
    }

    @Override
    public SearchResultDto searchHostedSeries(ResultSearchRequest searchRequest) {
        try {
            String uri = DataApiConstants.SEARCH_HOSTED_RESULTS_URL + searchRequest.toQueryString();
            return getStructuredData(uri, new TypeReference<SearchResultDto>() {
            });
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public List<HostedSessionSearchResultDto> getHostedResultEntries(ChunkInfoDto chunkInfo) {
        return getChunkedEntries(chunkInfo, new TypeReference<HostedSessionSearchResultDto[]>() {
        });
    }

    @Override
    public SearchResultDto searchIRacingSeries(ResultSearchRequest searchRequest) {
        try {
            String uri = DataApiConstants.SEARCH_SERIES_RESULTS_URL + searchRequest.toQueryString();
            return getStructuredData(uri, new TypeReference<SearchResultDto>() {
            });
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public List<SeriesSessionSearchResultDto> getSeriesResultEntries(ChunkInfoDto chunkInfo) {
        return getChunkedEntries(chunkInfo, new TypeReference<SeriesSessionSearchResultDto[]>() {
        });
    }

    @Override
    public MessagingDto<WorldRecordsDataDto> getWorldRecords(Long carId, Long trackId) {
        return getWorldRecords(carId, trackId, null, null);
    }

    @Override
    public MessagingDto<WorldRecordsDataDto> getWorldRecords(Long carId, Long trackId, Long seasonYear, Long seasonQuarter) {
        try {
            StringBuilder uri = new StringBuilder(DataApiConstants.GET_WORLD_RECORDS_URL)
                    .append("?car_id=").append(carId)
                    .append("&track_id=").append(trackId);
            if (seasonYear != null) {
                uri.append("&season_year=").append(seasonYear);
            }
            if (seasonQuarter != null) {
                uri.append(SEASON_QUARTER_URL_PARAM).append(seasonQuarter);
            }
            return getStructuredData(uri.toString(), new TypeReference<MessagingDto<WorldRecordsDataDto>>() {});
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public List<DriverRecordDto> getDriverRecords(ChunkInfoDto chunkInfo) {
        if(chunkInfo != null) {
            return getChunkedEntries(chunkInfo, new TypeReference<DriverRecordDto[]>() {
            });
        }
        return List.of();
    }

    public JsonNode getApiDocs() {
        try {
            return getStructuredData(DataApiConstants.GET_DOCS_URL, new TypeReference<JsonNode>() {
            });
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    private LinkResponseDto getLinkResponse(@NonNull String uri) throws IOException {
        String response = restTemplate.getForEntity(URI.create(uri), String.class).getBody();
        if (response != null && response.contains("Unauthorized")) {
            authResponse = null;
            throw new AuthorizationException("No longer authorized, call authenticate()");
        } else if (response == null) {
            throw new DataApiException("Null body from " + uri);
        }

        return mapper.readValue(response, LinkResponseDto.class);
    }

    private <T> T getStructuredData(@NonNull String link, @NonNull TypeReference<T> targetType) throws IOException {
        var uriBuilder = UriComponentsBuilder.fromUriString(link);
        ResponseEntity<String> infoResponse = restTemplate.getForEntity(uriBuilder.build(true).toUri(), String.class);
        String infoResponseBody = infoResponse.getBody();
        if (isLogResponseJson()) {
            jsonLogger.info("{}: {}", targetType.getType().getTypeName(), infoResponseBody);
        }
        if (infoResponseBody != null) {
            try {
                return mapper.readValue(infoResponseBody, targetType);
            } catch (UnrecognizedPropertyException e) {
                log.error(e.getMessage());
                log.info(infoResponseBody);
                return null;
            }
        } else {
            throw new DataApiException("Null body from AWS, status code " + infoResponse.getStatusCode());
        }
    }

    private <T> List<T> getChunkedEntries(ChunkInfoDto chunkInfo, TypeReference<T[]> targetType) {
        List<T> resultList = new ArrayList<>();
        Arrays.stream(chunkInfo.getChunkFileNames()).forEach(chunk -> {
            try {
                T[] chunkEntries = getStructuredData(chunkInfo.getBaseDownloadUrl() + chunk, targetType);
                resultList.addAll(List.of(chunkEntries));
            } catch (IOException e) {
                throw new DataApiException(e);
            }
        });
        return resultList;
    }

    private String uriWithCustIdParameter(@NonNull String baseUri, @NonNull Long custId) {
        return baseUri + "?cust_id=" + custId;
    }

    public static class StatefulRestTemplateInterceptor implements ClientHttpRequestInterceptor {
        private List<String> cookie;

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            if (cookie != null) {
                request.getHeaders().addAll(HttpHeaders.COOKIE, cookie);
            }

            HttpHeaders requestHeaders = request.getHeaders();
            log.debug("REQUEST-HEADERS");
            requestHeaders.forEach((k, v) -> log.debug("{}={}", k, v));
            log.debug("Request-Uri: {}", request.getURI());
            ClientHttpResponse response = execution.execute(request, body);

            if (cookie == null) {
                cookie = response.getHeaders().get(HttpHeaders.SET_COOKIE);
            }
            log.debug("RESPONSE-HEADERS");
            HttpHeaders responseHeaders = response.getHeaders();
            responseHeaders.forEach((k, v) -> log.debug("{}={}", k, v));
            return response;
        }

        public void flushCookies() {
            cookie = null;
        }
    }
}

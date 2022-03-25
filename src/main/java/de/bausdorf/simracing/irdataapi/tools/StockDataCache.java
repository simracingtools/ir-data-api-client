package de.bausdorf.simracing.irdataapi.tools;

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

import com.fasterxml.jackson.core.type.TypeReference;
import de.bausdorf.simracing.irdataapi.client.AuthorizationException;
import de.bausdorf.simracing.irdataapi.client.IrDataClient;
import de.bausdorf.simracing.irdataapi.client.impl.IRacingObjectMapper;
import de.bausdorf.simracing.irdataapi.model.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Map;

@Slf4j
@Getter
@Component
public class StockDataCache {
    public static final String TRACKS_JSON = "tracks.json";
    public static final String TRACK_ASSETS_JSON = "trackAssets.json";
    public static final String CARS_JSON = "cars.json";
    public static final String CAR_CLASSES_JSON = "carClasses.json";
    public static final String CAR_ASSETS_JSON = "carAssets.json";
    public static final String DIVISIONS_JSON = "divisions.json";
    public static final String LICENSE_GROUPS_JSON = "licenseGroups.json";
    private TrackInfoDto[] tracks;
    private Map<Long, TrackAssetDto> trackAssets;
    private CarInfoDto[] cars;
    private CarClassDto[] carClasses;
    private Map<Long, CarAssetDto> carAssets;
    private DivisionDto[] divisions;
    private LicenseGroupDto[] licenseGroups;

    @Setter
    private Path cacheDir;

    private final IRacingObjectMapper mapper = new IRacingObjectMapper();

    public StockDataCache(@NonNull String cacheDir) {
        this.cacheDir = Paths.get(cacheDir);
        try {
            fetchFromCache();
        } catch (IOException e) {
            log.warn("could not fetch data from cache directory {}: {}", cacheDir, e.getMessage());
        }
    }

    public boolean isInitialized() {
        return (tracks != null
                && trackAssets != null
                && cars != null
                && carClasses != null
                && carAssets != null
                && divisions != null
                && licenseGroups != null);
    }

    public boolean cacheExists() {
        return Files.exists(cacheDir);
    }

    public Long cacheLastModified() {
        if(cacheExists()) {
            File cacheFile = new File(cacheDir.toFile().getAbsolutePath() + File.separator + TRACKS_JSON);
            return cacheFile.lastModified();
        }
        return 0L;
    }

    public void fetchFromService(IrDataClient dataClient) {
        if(!dataClient.isAuthenticated()) {
            throw new AuthorizationException("StockDataCache cannot be fetched from unauthorized client");
        }
        tracks = dataClient.getTrackInfos();
        trackAssets = dataClient.getTrackAssets();
        cars = dataClient.getCarInfo();
        carClasses = dataClient.getCarClasses();
        carAssets = dataClient.getCarAssets();
        divisions = dataClient.getDivisions();
        licenseGroups = dataClient.getLicenseGroups();

        try {
            if(!cacheExists()) {
                Files.createDirectories(cacheDir);
            }
            writeToFile(cacheDir.toFile().getAbsolutePath() + File.separator + TRACKS_JSON, tracks);
            writeToFile(cacheDir.toFile().getAbsolutePath() + File.separator + TRACK_ASSETS_JSON, trackAssets);
            writeToFile(cacheDir.toFile().getAbsolutePath() + File.separator + CARS_JSON, cars);
            writeToFile(cacheDir.toFile().getAbsolutePath() + File.separator + CAR_CLASSES_JSON, carClasses);
            writeToFile(cacheDir.toFile().getAbsolutePath() + File.separator + CAR_ASSETS_JSON, carAssets);
            writeToFile(cacheDir.toFile().getAbsolutePath() + File.separator + DIVISIONS_JSON, divisions);
            writeToFile(cacheDir.toFile().getAbsolutePath() + File.separator + LICENSE_GROUPS_JSON, licenseGroups);
        } catch (IOException e) {
            log.error("Unable to write StockDataCache directory {}: {}", cacheDir, e.getMessage());
        }
    }

    public void fetchFromCache() throws IOException {
        tracks = readFromFile(cacheDir.toFile().getAbsolutePath() + File.separator + TRACKS_JSON, new TypeReference<TrackInfoDto[]>() {});
        trackAssets = readFromFile(cacheDir.toFile().getAbsolutePath() + File.separator + TRACK_ASSETS_JSON, new TypeReference<Map<Long, TrackAssetDto>>() {});
        cars = readFromFile(cacheDir.toFile().getAbsolutePath() + File.separator + CARS_JSON, new TypeReference<CarInfoDto[]>() {});
        carClasses = readFromFile(cacheDir.toFile().getAbsolutePath() + File.separator + CAR_CLASSES_JSON, new TypeReference<CarClassDto[]>() {});
        carAssets = readFromFile(cacheDir.toFile().getAbsolutePath() + File.separator + CAR_ASSETS_JSON, new TypeReference<Map<Long, CarAssetDto>>() {});
        divisions = readFromFile(cacheDir.toFile().getAbsolutePath() + File.separator + DIVISIONS_JSON, new TypeReference<DivisionDto[]>() {});
        licenseGroups = readFromFile(cacheDir.toFile().getAbsolutePath() + File.separator + LICENSE_GROUPS_JSON, new TypeReference<LicenseGroupDto[]>() {});
    }

    private <T> T readFromFile(String fileName, TypeReference<T> targetType) throws IOException {
        try(InputStream fis = new FileInputStream(fileName)) {
            return mapper.readValue(fis, targetType);
        }
    }

    private <T> void writeToFile(String fileName, T data) throws IOException {
        mapper.writeValue(new File(fileName), data);
    }
}

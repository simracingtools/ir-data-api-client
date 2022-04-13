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

import com.fasterxml.jackson.databind.JavaType;
import de.bausdorf.simracing.irdataapi.client.impl.IRacingObjectMapper;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Optional;

@Slf4j
public class JsonFileCache<T> {

    private final IRacingObjectMapper mapper = new IRacingObjectMapper();

    @Getter
    T cachedData;

    private final Path cacheDir;
    private final String cacheName;

    public JsonFileCache(@NonNull String cacheDir, @NonNull String cacheName) {
        this.cacheDir = Paths.get(cacheDir);
        this.cacheName = cacheName;
        try {
            cachedData = readFromFile(getFilePath());
        } catch (IOException | ClassNotFoundException e) {
            log.warn("could not fetch data from cache directory {}: {}", cacheDir, e.getMessage());
        }
    }

    public boolean cacheExists() {
        return Files.exists(cacheDir);
    }

    public long cacheLastModified() {
        if(cacheExists()) {
            File cacheFile = new File(getFilePath());
            return cacheFile.lastModified();
        }
        return 0L;
    }

    public void setCachedData(T data) {
        cachedData = data;
        try {
            WriteCacheWrapper<T> writeCacheWrapper = new WriteCacheWrapper<>();
            writeCacheWrapper.setData(data);
            if(data instanceof Collection<?>) {
                writeCacheWrapper.setCollectionTypeName(data.getClass().getName());
                Optional<?> firstElement = ((Collection<?>)data).stream().findFirst();
                firstElement.ifPresent(o -> writeCacheWrapper.setElementTypeName(o.getClass().getName()));
            } else {
                writeCacheWrapper.setElementTypeName(data.getClass().getName());
            }
            mapper.writeValue(new File(getFilePath()), writeCacheWrapper);
        } catch (IOException e) {
            log.error("Unable to write cache file {}: {}", getFilePath(), e.getMessage());
        }
    }

    private T readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try(InputStream fis = new FileInputStream(fileName)) {
            ReadCacheWrapper<T> cacheWrapper = mapper.readValue(fis, ReadCacheWrapper.class);
            Class<?> elementClass = Class.forName(cacheWrapper.getElementTypeName());
            if(cacheWrapper.getCollectionTypeName() == null) {
                return (T)mapper.convertValue(cacheWrapper.getData(), elementClass);
            } else {
                Class<? extends Collection> collectionClass =
                        (Class<? extends Collection>) Class.forName(cacheWrapper.getCollectionTypeName());
                JavaType targetType = mapper.getTypeFactory().constructCollectionType(
                        collectionClass, elementClass);
                return mapper.convertValue(cacheWrapper.getData(), targetType);
            }
        }
    }

    private String getFilePath() {
        return cacheDir.toFile().getAbsolutePath() + File.separator
                + cacheName + ".json";
    }

    @Data
    @NoArgsConstructor
    static class WriteCacheWrapper<T> {
        private String elementTypeName;
        private String collectionTypeName;
        private T data;
    }

    @Data
    @NoArgsConstructor
    static class ReadCacheWrapper<T> {
        private String elementTypeName;
        private String collectionTypeName;
        private T data;
    }
}

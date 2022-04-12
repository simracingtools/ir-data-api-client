package de.bausdorf.simracing.irdataapi.tools;

import com.fasterxml.jackson.core.type.TypeReference;
import de.bausdorf.simracing.irdataapi.client.impl.IRacingObjectMapper;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            cachedData = readFromFile(getFilePath(), new TypeReference<T>() {});
        } catch (IOException e) {
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
            mapper.writeValue(new File(getFilePath()), data);
        } catch (IOException e) {
            log.error("Unable to write cache file {}: {}", getFilePath(), e.getMessage());
        }
    }

    private T readFromFile(String fileName, TypeReference<T> targetType) throws IOException {
        try(InputStream fis = new FileInputStream(fileName)) {
            return mapper.readValue(fis, targetType);
        }
    }

    private String getFilePath() {
        return cacheDir.toFile().getAbsolutePath() + File.separator
                + cacheName + ".json";
    }
}

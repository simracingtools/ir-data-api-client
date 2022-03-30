package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChunkInfoDto {
    @JsonProperty("chunk_size")
    private Long chunkSize;
    @JsonProperty("num_chunks")
    private Long numChunks;
    @JsonProperty("rows")
    private Long rows;
    @JsonProperty("base_download_url")
    private String baseDownloadUrl;
    @JsonProperty("chunk_file_names")
    private String[] chunkFileNames;
}

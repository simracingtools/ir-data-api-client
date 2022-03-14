package de.bausdorf.simracing.irdataapi.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "irdataapi")
@Data
@NoArgsConstructor
public class ConfigProperties {
    private String user;
    private String password;
}

package de.bausdorf.simracing.irdataapi.client;

import de.bausdorf.simracing.irdataapi.client.impl.IrDataClientImpl;
import de.bausdorf.simracing.irdataapi.config.ConfigProperties;
import de.bausdorf.simracing.irdataapi.model.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = {AverageCalculationTest.class})
@EnableConfigurationProperties(value = ConfigProperties.class)
@TestPropertySource("classpath:application-test.properties")
@Slf4j
class AverageCalculationTest {
    @Autowired
    ConfigProperties config;

    IrDataClient dataClient = new IrDataClientImpl();

    static class Stintdata {
        @Getter
        private final Long custId;
        @Getter
        private final String name;
        private Duration fastestLap;
        private Duration slowestLap;
        private Duration lapsAccumulated = Duration.ZERO;
        @Getter
        private int lapCount;

        public Stintdata(Long custId, String name) {
            this.custId = custId;
            this.name = name;
        }

        public void addLap(Duration laptime) {
            if (fastestLap == null) {
                fastestLap = laptime;
            } else if (fastestLap.toNanos() > laptime.toNanos()) {
                fastestLap = laptime;
            }
            if (slowestLap == null) {
                slowestLap = laptime;
            } else if (slowestLap.toNanos() < laptime.toNanos()) {
                slowestLap = laptime;
            }

            lapsAccumulated = lapsAccumulated.plus(laptime);
            lapCount++;
        }

        public LocalTime getSlowestLapTime() {
            return LocalTime.of(0,0,0,0).plusNanos(slowestLap.toNanos());
        }

        public LocalTime getFastestLapTime() {
            return LocalTime.of(0,0,0,0).plusNanos(fastestLap.toNanos());
        }

        public LocalTime getAverageLapTime() {
            return LocalTime.of(0,0,0,0).plusNanos(lapsAccumulated.dividedBy(lapCount).toNanos());
        }
    }

    @Test
    void calcAverageTimesTest() {
        authenticate();
        LapChartDto lapData = dataClient.getLapChartData(50380624L, 0L);
        List<LapChartEntryDto> lapChartEntries = dataClient.getLapEntries(lapData.getChunkInfo());

        Map<Long, Stintdata> stints = new HashMap<>();
        lapChartEntries.forEach(entry -> {
            log.info("{} {} {} {} {}", entry.getLapNumber(), entry.getDisplayName(), entry.getLapTime(), entry.getIncident(), entry.getLapEvents());
            Stintdata stintdata = stints.get(entry.getCustId());
            if (stintdata == null) {
                stintdata = new Stintdata(entry.getCustId(), entry.getName());
            }
            if (entry.getLapTime() != -1) {
                stintdata.addLap(Duration.ofMillis(entry.getLapTime() / 10L));
            }
            stints.put(entry.getCustId(), stintdata);
        });

        stints.forEach((key, value) -> log.info("{} ({}): {} laps, slowestLap {}, fastestLap {}, averageLap {}",
                value.getName(), value.getCustId(), value.getLapCount(), value.getSlowestLapTime(), value.getFastestLapTime(), value.getAverageLapTime()));
    }

    private void authenticate() {
        if (!dataClient.isAuthenticated()) {
            LoginRequestDto dto = LoginRequestDto.builder()
                    .email(config.getUser())
                    .password(config.getPassword())
                    .build();
            dataClient.setLogResponseJson(config.getLogResponseJson());
            dataClient.setHashPassword(config.getHashPassword());
            AuthResponseDto authResponseDto = dataClient.authenticate(dto);
            log.info(authResponseDto.toString());
        }
    }
}

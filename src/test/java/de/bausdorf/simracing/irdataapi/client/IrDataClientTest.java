package de.bausdorf.simracing.irdataapi.client;

import de.bausdorf.simracing.irdataapi.config.ConfigProperties;
import de.bausdorf.simracing.irdataapi.model.AuthResponseDto;
import de.bausdorf.simracing.irdataapi.model.CarInfoDto;
import de.bausdorf.simracing.irdataapi.model.LoginRequestDto;
import de.bausdorf.simracing.irdataapi.model.MembersInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = {IrDataClientTest.class})
@EnableConfigurationProperties(value = ConfigProperties.class)
@TestPropertySource("classpath:application-test.properties")
@Slf4j
class IrDataClientTest {

    @Autowired
    ConfigProperties config;

    IrDataClient dataClient = new IrDataClient();

    @Test
    void testGetMembersInfo() {
        authenticate();
        List<String> ids = new ArrayList<>();
        ids.add("229120");

        MembersInfoDto membersInfoDto = dataClient.getMembersInfo(ids);
        log.info(membersInfoDto.toString());
    }

    @Test
    void testGetCarInfo() {
        authenticate();
        CarInfoDto[] carInfoDtos = dataClient.getCarInfo();
        Arrays.asList(carInfoDtos).forEach(s -> log.info(s.toString()));

        log.info("got {} car infos", carInfoDtos.length);
    }

    private void authenticate() {
        if (!dataClient.isAuthenticated()) {
            LoginRequestDto dto = LoginRequestDto.builder()
                    .email(config.getUser())
                    .password(config.getPassword())
                    .build();
            AuthResponseDto authResponseDto = dataClient.authenticate(dto);
            log.info(authResponseDto.toString());
        }
    }
}

package de.bausdorf.simracing.irdataapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDto {
    private String email;
    private String password;

    LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static LoginRequestDtoBuilder builder() {
        return new LoginRequestDtoBuilder();
    }
}

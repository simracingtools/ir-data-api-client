package de.bausdorf.simracing.irdataapi.tools;

import de.bausdorf.simracing.irdataapi.model.LoginRequestDto;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
public class LoginHelper {

    private LoginHelper() {
        super();
    }

    public static LoginRequestDto hashPassword(LoginRequestDto loginRequest) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest((loginRequest.getPassword() + loginRequest.getEmail().toLowerCase()).getBytes(StandardCharsets.UTF_8));
            loginRequest.setPassword(Base64.getEncoder().encodeToString(hash));
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }
        return loginRequest;
    }
}

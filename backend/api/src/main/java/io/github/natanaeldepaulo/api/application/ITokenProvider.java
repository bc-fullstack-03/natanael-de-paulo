package io.github.natanaeldepaulo.api.application;

import io.github.natanaeldepaulo.api.application.specification.UserDTO;

import java.util.UUID;

public interface ITokenProvider {
    String generateToken(UserDTO user);
    boolean isValidToken(String token, UUID userId0);
    String getSubject(String token);
}

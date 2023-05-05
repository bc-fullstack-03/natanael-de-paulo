package io.github.natanaeldepaulo.api.application;

import io.github.natanaeldepaulo.api.application.specification.UserResponse;

import java.util.UUID;

public interface IJwtService {
    String generateToken(UserResponse user);
    boolean isValidToken(String token, UUID userId0);
}

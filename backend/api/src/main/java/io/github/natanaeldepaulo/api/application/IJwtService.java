package io.github.natanaeldepaulo.api.application;

import io.github.natanaeldepaulo.api.application.models.user.UserDTO;

public interface IJwtService {
    String generateToken(UserDTO user);
}

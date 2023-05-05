package io.github.natanaeldepaulo.api.application;

import io.github.natanaeldepaulo.api.application.specification.UserRequest;
import io.github.natanaeldepaulo.api.application.specification.UserDTO;
import io.github.natanaeldepaulo.api.domain.entities.User;

public interface IUserService {
    UserDTO findUserById(String userId);
    String create(UserRequest request);
    User findUserByEmail(String email);
}

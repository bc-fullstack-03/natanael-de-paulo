package io.github.natanaeldepaulo.api.application.models.user;

import io.github.natanaeldepaulo.api.application.models.user.UserRequest;
import io.github.natanaeldepaulo.api.application.models.user.UserDTO;
import io.github.natanaeldepaulo.api.domain.entities.User;

public interface IUserService {
    UserDTO findUserById(String userId);
    String create(UserRequest request);
    User findUserByEmail(String email);
}

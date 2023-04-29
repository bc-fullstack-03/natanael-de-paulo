package io.github.natanaeldepaulo.api.application;

import io.github.natanaeldepaulo.api.application.data.CreateUserRequest;

public interface IUserService {
//    Optional<UserResponse> getUserById(String _id);
    String create(CreateUserRequest request);
}

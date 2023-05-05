package io.github.natanaeldepaulo.api.infrastructure;

import io.github.natanaeldepaulo.api.application.specification.UserDTO;
import io.github.natanaeldepaulo.api.domain.entities.User;

public interface IUserMapper {
    User toEntity(UserDTO userDTO);
    UserDTO toDTO(User user);
}

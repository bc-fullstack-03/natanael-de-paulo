package io.github.natanaeldepaulo.api.infrastructure;

import io.github.natanaeldepaulo.api.application.specification.UserDTO;
import io.github.natanaeldepaulo.api.domain.entities.User;
import io.github.natanaeldepaulo.api.infrastructure.config.ModelMapperConfig;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserMapper implements IUserMapper {
    @Autowired
    private ModelMapper _modelMapper;

    public User toEntity(UserDTO userDTO){
        return _modelMapper.map(userDTO, User.class);
    }
    public UserDTO toDTO(User user){
        return _modelMapper.map(user, UserDTO.class);
    }
}

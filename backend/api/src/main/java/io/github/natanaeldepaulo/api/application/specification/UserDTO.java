
package io.github.natanaeldepaulo.api.application.specification;
import io.github.natanaeldepaulo.api.domain.embedded.Profile;
import io.github.natanaeldepaulo.api.domain.entities.User;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class UserDTO {
    public UUID id;
    public String name;
    public String email;
    public Profile profile;

    public UserDTO(){}

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.profile = user.getProfile();
    }
}

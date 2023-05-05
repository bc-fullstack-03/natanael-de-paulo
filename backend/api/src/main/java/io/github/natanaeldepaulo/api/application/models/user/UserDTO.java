
package io.github.natanaeldepaulo.api.application.specification;
import io.github.natanaeldepaulo.api.domain.embedded.Profile;
import io.github.natanaeldepaulo.api.domain.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDTO {
    public UUID id;
    public String name;
    public String email;
    public Profile profile;
}

package io.github.natanaeldepaulo.api.domain.entities;

import io.github.natanaeldepaulo.api.application.models.user.UserDTO;
import io.github.natanaeldepaulo.api.domain.embedded.Profile;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
@Getter
public class User {
    @Id private UUID id;
    private String name;
    private String email;
    private String password;
    private Profile profile;

    private User(){};

    private User(String name, String email, String password, Profile profile){
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    //using factory method
    public static User create(String name, String email, String password, Profile profile){
        return new User(name, email, password, profile);
    }

    public static User userMapping(UserDTO userDTO){
        var user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(user.getPassword());
        user.setProfile(userDTO.getProfile());

        return user;
    }


    private void setId(UUID id){
        this.id = id;
    }

    private void setName(String name){
        this.name = name;
    }

    private void setEmail(String email){
        this.email = email;
    }

    private void setPassword(String password){
        this.id = id;
    }

    private void setProfile(Profile profile){
        this.profile = profile;
    }

}

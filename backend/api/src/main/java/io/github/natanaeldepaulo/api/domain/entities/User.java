package io.github.natanaeldepaulo.api.domain.entities;

import io.github.natanaeldepaulo.api.domain.embedded.Profile;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document(collection = "users")
@Getter
public class User {
    @Id @Field("_id")
    @Setter private UUID id;
    @Setter private String name;
    @Setter private String email;
    @Setter private String password;
    @Setter private Profile profile;

    private User(String name, String email, String password, Profile profile){
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    private User(){}

    //using factory method
    public static User create(String name, String email, String password, Profile profile){
        return new User(name, email, password, profile);
    }

    public static User emptyUser(){
        return new User();
    }
}

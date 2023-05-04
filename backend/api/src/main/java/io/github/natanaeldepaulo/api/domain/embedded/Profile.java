package io.github.natanaeldepaulo.api.domain.embedded;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Profile {
    @Id private UUID id;
    private String name;
    private Boolean image = false;
    private String imageURL;

    public Profile(){}

    private Profile(Profile profile){
        this.id = UUID.randomUUID();
        this.name = profile.name;
        this.image = profile.image;
        this.imageURL = profile.imageURL;
    }

    public static Profile create(Profile profile){
        return new Profile(profile);
    }

}

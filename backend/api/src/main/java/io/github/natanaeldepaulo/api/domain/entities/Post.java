package io.github.natanaeldepaulo.api.domain.entities;

import io.github.natanaeldepaulo.api.domain.embedded.Comment;
import io.github.natanaeldepaulo.api.domain.embedded.Likes;
import io.github.natanaeldepaulo.api.domain.embedded.Profile;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;

@Document(collection = "posts")
@Data
public class Post {
    @Id private final UUID id;
    private String title;
    private String description;
    private Boolean image = false;
    private String imageUrl;
    private UUID profile_id;
    private ArrayList<Comment> comment;
    private ArrayList<Likes> likes;

    public Post(String title, String description, Boolean image, String imageUrl, Profile profile){
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.image = image;
        this.imageUrl = imageUrl;
        this.profile_id = profile.getId();
        this.comment = new ArrayList<>();
        this.likes = new ArrayList<>();
    }
}

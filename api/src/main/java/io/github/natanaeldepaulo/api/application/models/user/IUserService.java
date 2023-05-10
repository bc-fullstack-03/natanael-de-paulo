package io.github.natanaeldepaulo.api.application.models.user;
import io.github.natanaeldepaulo.api.domain.entities.User;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService {
    UserDTO findUserById(String userId);
    String create(UserRequest request);
    User findUserByEmail(String email);
    String upload(MultipartFile file);
    String followUser(String userId);
}

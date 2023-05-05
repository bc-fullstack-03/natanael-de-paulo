package io.github.natanaeldepaulo.api.application.specification;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AccountCredentialsDTO {
    @Email(message = "email invalid")
    private String email;
    @NotNull(message = "required field")
    private String password;

    public AccountCredentialsDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

package io.github.natanaeldepaulo.api.application.utils;

import io.github.natanaeldepaulo.api.infrastructure.config.SecurityConfig;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PasswordEncoded {
    @Autowired
    private SecurityConfig securityConfig;
    public String encode(String password) {
        return securityConfig.passwordEncoder().encode(password);
    }

}
package br.java.social_network.presentation.controllers;

import br.java.social_network.application.models.auth.AuthRequest;
import br.java.social_network.application.models.infraInterfaces.ITokenProvider;
import br.java.social_network.application.models.user.IUserMapper;
import br.java.social_network.domain.entities.User;
import br.java.social_network.application.models.auth.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class AuthController {
    @Autowired
    private ITokenProvider _tokenProvider;

    @Autowired
    private IUserMapper _userMapper;
    @Autowired
    private AuthenticationManager _authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<AuthDTO> auth(@RequestBody AuthRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()
        );

        Authentication authenticate = this._authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var user = (User) authenticate.getPrincipal();
        var token = _tokenProvider.generateToken(_userMapper.toDTO(user));

        var response = new AuthDTO();
        response.setToken(token);
        return ResponseEntity.ok().body(response);
    }
}

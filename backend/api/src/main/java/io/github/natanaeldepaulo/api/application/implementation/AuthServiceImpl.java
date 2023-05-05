package io.github.natanaeldepaulo.api.application.implementation;

import io.github.natanaeldepaulo.api.application.IAuthService;
import io.github.natanaeldepaulo.api.application.ITokenProvider;
import io.github.natanaeldepaulo.api.application.IUserService;
import io.github.natanaeldepaulo.api.application.specification.AccountCredentialsDTO;
import io.github.natanaeldepaulo.api.application.specification.AuthResponse;
import io.github.natanaeldepaulo.api.application.utils.ConvertFormatId;
import io.github.natanaeldepaulo.api.infrastructure.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private IUserService _userService;
    @Autowired
    private ITokenProvider _tokenProvider;
    @Autowired
    private IUserMapper _userMapper;

    @Override
    public AuthResponse auth(AccountCredentialsDTO request) {
        try {
            var user = _userService.findUserByEmail(request.getEmail());
            if (user == null) throw new UsernameNotFoundException("Email " + request.getEmail() + " not found!");
            var token = _tokenProvider.generateToken(_userMapper.toDTO(user));
            var response = new AuthResponse();
            response.setToken(token);
            response.setUserId(ConvertFormatId.toString(user.getId()));
            return response;
        } catch (Exception e){
            throw new BadCredentialsException("Invalid email/password supplied!");
        }
    };
}

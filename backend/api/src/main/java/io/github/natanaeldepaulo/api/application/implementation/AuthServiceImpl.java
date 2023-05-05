//package io.github.natanaeldepaulo.api.application.implementation;
//
//import io.github.natanaeldepaulo.api.application.IAuthService;
//import io.github.natanaeldepaulo.api.application.IJwtService;
//import io.github.natanaeldepaulo.api.application.models.user.IUserService;
//import io.github.natanaeldepaulo.api.application.specification.AuthRequest;
//import io.github.natanaeldepaulo.api.application.specification.AuthResponse;
//import io.github.natanaeldepaulo.api.application.models.user.UserDTO;
//import io.github.natanaeldepaulo.api.domain.mappers.IUserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthServiceImpl implements IAuthService {
//    @Autowired
//    private IUserService _userService;
//    @Autowired
//    private IJwtService _jwtService;
//
//    @Autowired
//    private IUserMapper _userMapper;
//
//    @Override
//    public AuthResponse auth(AuthRequest request) {
//        var user = _userService.findUserByEmail(request.email);
//
//        if (user == null) return null;
//        if (!user.getPassword().equals(request.password)) return null;
//
//        var token = _jwtService.generateToken(_userMapper.toDTO(user));
//        var response = new AuthResponse();
//        response.setToken(token);
//        return response;
//    };
//}

//package io.github.natanaeldepaulo.api.infrastructure.config;
//
//import io.github.natanaeldepaulo.api.application.ITokenProvider;
//import io.github.natanaeldepaulo.api.application.utils.ConvertFormatId;
//import io.github.natanaeldepaulo.api.domain.interfaces.IUserRepository;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class JwtFilterToken extends OncePerRequestFilter {
//    @Autowired
//    private ITokenProvider _tokenProvider;
//    @Autowired
//    private IUserRepository _userRepository;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        var authHeader = request.getHeader("Authorization");
//        var token = !authHeader.isEmpty() ? authHeader.replace("Bearer ", "") : null;
//
//        if (token == null)  return;
//
//        try {
//            var sub = _tokenProvider.getSubject(token);
//            var user = _userRepository.findById(ConvertFormatId.toUUID(sub));
//            request.setAttribute("profileId", user.get().getProfile().getId());
//            filterChain.doFilter(request, response);
//        } catch (ServletException e) {
//            throw new ServletException(e);
//        } catch (IOException e) {
//            throw new IOException(e);
//        }
//    }
//}

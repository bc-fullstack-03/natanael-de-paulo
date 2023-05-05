package io.github.natanaeldepaulo.api.application.implementation;

import io.github.natanaeldepaulo.api.application.ITokenProvider;
import io.github.natanaeldepaulo.api.application.specification.UserDTO;
import io.github.natanaeldepaulo.api.application.utils.ConvertFormatId;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Service
public class TokenProvider implements ITokenProvider {
    @Override
    public String generateToken(UserDTO user){
        return Jwts
                .builder()
                .setSubject(ConvertFormatId.toString(user.getId()))
                .claim("profileId", user.getProfile().getId())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 7200000))
                .signWith(genSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean isValidToken (String token, UUID userId) {
        var claims = Jwts.parserBuilder().setSigningKey(genSignInKey()).build().parseClaimsJws(token).getBody();
        var sub = claims.getSubject();
        var tExpiration = claims.getExpiration();
        return (sub.equals(userId.toString()) && !tExpiration.before(new Date()));
    }

    private Key genSignInKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode("4D6250655368566D597133743677397A24432646294A404E635266546A576E5A"));
    }

    @Override
    public String getSubject(String token){
        var sub = Jwts.parserBuilder().setSigningKey(genSignInKey()).build().parseClaimsJws(token).getBody();
        return sub.getSubject();
    }
}

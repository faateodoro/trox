package com.ft.trox.configs.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.ft.trox.dtos.LoginDto;
import com.ft.trox.dtos.UserDto;
import com.ft.trox.models.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {

    private static final String ISSUER = "trox-comp";
    private static final String TOKEN_HEADER = "Bearer ";
    private static final String TOKEN_KEY = "01234567890123456789012345678901";
    private static final long ONE_SECOND = 1000;
    private static final long ONE_MINUTE = 60*ONE_SECOND;

    public static AuthToken encodeToken(LoginDto loginDto) {
        Key secretKey = Keys.hmacShaKeyFor(TOKEN_KEY.getBytes());
        String tokenJwt = Jwts.builder().setSubject(loginDto.email())
            .setIssuer(ISSUER)
            .setExpiration(new Date(System.currentTimeMillis() + ONE_MINUTE))
            .signWith(secretKey, SignatureAlgorithm.HS256).compact();
        
        AuthToken token = new AuthToken(TOKEN_HEADER + tokenJwt);
        return token;
    }

    public static Authentication decodeToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("Authorization");
        jwtToken = jwtToken.replace(TOKEN_HEADER, "");

        Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(TOKEN_KEY.getBytes()).build().parseClaimsJws(jwtToken);

        String subject = jwsClaims.getBody().getSubject();
        String issuer = jwsClaims.getBody().getIssuer();
        Date validUntil = jwsClaims.getBody().getExpiration();

        if (subject.length() > 0 && issuer.equals(ISSUER) && validUntil.after(new Date(System.currentTimeMillis())))
            return new UsernamePasswordAuthenticationToken("user", null, Collections.emptyList());
        return null;
    }
}

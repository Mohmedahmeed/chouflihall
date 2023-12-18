package com.example.stage4e.Configuration;

import com.example.stage4e.Repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {


    private final TokenRepository tokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String AuthHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;


        if (AuthHeader== null || !AuthHeader.startsWith("Bearer") )
        {
            return ;
        };
        jwt = AuthHeader.substring(7);
        var storedToken = tokenRepository.findByToken(jwt).orElse(null);
        if (storedToken!=null)
        {
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepository.save(storedToken);
            System.out.printf("Logged out successfully");
        }
    }
}

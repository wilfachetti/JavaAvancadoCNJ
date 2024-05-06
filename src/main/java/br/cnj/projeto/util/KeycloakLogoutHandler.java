package br.cnj.projeto.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class KeycloakLogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            if ("org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken".equals(auth.getClass().getName())) {
                auth.setAuthenticated(false);
                SecurityContextHolder.getContext().setAuthentication(null);
            }
        }
    }

}



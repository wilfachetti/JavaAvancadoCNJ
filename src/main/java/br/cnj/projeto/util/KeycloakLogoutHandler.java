package br.cnj.projeto.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class KeycloakLogoutHandler implements LogoutHandler {

    // private static final Logger logger = LoggerFactory.getLogger(KeycloakLogoutHandler.class); 
    // private final RestTemplate restTemplate;

    // public KeycloakLogoutHandler(RestTemplate restTemplate) {
    //     this.restTemplate = restTemplate;
    // }

    // @Override
    // public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    //     logoutFromKeycloak((OidcUser) authentication.getPrincipal());
    // }
    
    // private void logoutFromKeycloak(OidcUser user) {
    //     String endSessionEndpoint = user.getIssuer() + "/protocol/openid-connect/logout";
        
    //     UriComponentsBuilder builder = UriComponentsBuilder
    //             .fromUriString(endSessionEndpoint)
    //             .queryParam("id_token_hint", user.getIdToken().getTokenValue());

    //     ResponseEntity<String> logoutResponse = restTemplate.getForEntity(
    //         builder.toUriString(), String.class);
        
    //     if (logoutResponse.getStatusCode().is2xxSuccessful()) {
    //         logger.info("Successfulley logged out from Keucloak");
    //     } else {
    //         logger.error("Could not propagate logout to Keycloak");
    //     }
    // }
   
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            // Verifica se a autenticação é proveniente do Keycloak
            if ("org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken".equals(auth.getClass().getName())) {
                // Realiza o logout
                auth.setAuthenticated(false);
                SecurityContextHolder.getContext().setAuthentication(null);
            }
        }
    }

}



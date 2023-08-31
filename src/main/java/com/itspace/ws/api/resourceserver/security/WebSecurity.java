package com.itspace.ws.api.resourceserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // deprecated
public class WebSecurity {

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
        
        httpSecurity.authorizeHttpRequests(authz ->
                           authz
                              .requestMatchers(HttpMethod.GET, "/users/status/check")
//                                   .hasAuthority("SCOPE_profile")
                                   .hasRole("developer")
//                                   .hasAnyRole("developer")
//                                   .hasAnyAuthority("ROLE_developer")
                              .anyRequest().authenticated()
                           )

        .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter);

        return httpSecurity.build();
    }
}

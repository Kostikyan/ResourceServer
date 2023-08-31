package com.itspace.ws.api.resourceserver.endpoint;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenEndpoint {

    @GetMapping
    public Map<String, Jwt> getToken(@AuthenticationPrincipal Jwt jwt){
         return Collections.singletonMap("principal", jwt);
    }
}

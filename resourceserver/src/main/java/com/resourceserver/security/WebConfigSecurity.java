package com.resourceserver.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfigSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
return http.oauth2ResourceServer(j ->{
j.jwt().jwkSetUri("http://localhost:9000/oauth2/jwt").jwtAuthenticationConverter(jwtAuthenticationConverter());
}).authorizeHttpRequests().anyRequest().authenticated().and().build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter(){
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(jwt ->{
            List<String> authorities = jwt.getClaimAsStringList("user_roles"); 

            if(authorities == null){
                return Collections.emptyList();
            }
            JwtGrantedAuthoritiesConverter scopesConverter = new JwtGrantedAuthoritiesConverter();

            Collection<GrantedAuthority> grantedAuthorities = scopesConverter.convert(jwt);
            
            grantedAuthorities.addAll(authorities.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList()));
            return grantedAuthorities;
        });
        return converter;
    }
}

package com.authserver1.authserver1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .formLogin()
            .and()
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated();
            return http.build();
    }

    // @Bean
    // public UserDetailsService userDetailsService(){
    //     var user = User.withUsername("joao").password("1234").authorities("admin").build();

    //     var uds = new InMemoryUserDetailsManager();
    //     uds.createUser(user);
    //     return uds;
    // }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}

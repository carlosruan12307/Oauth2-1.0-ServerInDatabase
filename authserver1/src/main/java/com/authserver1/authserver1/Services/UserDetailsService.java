package com.authserver1.authserver1.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authserver1.authserver1.Models.UserModel;
import com.authserver1.authserver1.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = ur.findBynome(username).orElseThrow(() -> new UsernameNotFoundException(username + "nao encontrado"));
        return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
    }
    
}

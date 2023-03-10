package com.authserver1.authserver1.Run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.authserver1.authserver1.Models.UserModel;
import com.authserver1.authserver1.Repository.UserRepository;

@Component
public class Run implements ApplicationRunner {

    @Autowired
    private UserRepository ur;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(ur.findAll().isEmpty()){
            UserModel user = new UserModel("joao",passwordEncoder.encode("123"));
            ur.save(user);
        }
      

        
    }
    
}

package com.authserver1.authserver1.Run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.authserver1.authserver1.Enums.RoleEnum;
import com.authserver1.authserver1.Models.RoleModel;
import com.authserver1.authserver1.Models.UserModel;
import com.authserver1.authserver1.Repository.RoleRepository;
import com.authserver1.authserver1.Repository.UserRepository;

@Component
public class Run implements ApplicationRunner {

    @Autowired
    private UserRepository ur;


    @Autowired
    private RoleRepository rr;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (RoleEnum ro : RoleEnum.values()) {
            if(rr.findBynome(ro).isEmpty()){
                RoleModel role = new RoleModel(ro);
                rr.save(role);
                if(ro == RoleEnum.ROLE_ADMIN){
                    UserModel usuario = new UserModel("joao",passwordEncoder.encode("123"));
                    usuario.addRole(role);
                        ur.save(usuario);

                }
            }
        
       }
        
    }
    
}

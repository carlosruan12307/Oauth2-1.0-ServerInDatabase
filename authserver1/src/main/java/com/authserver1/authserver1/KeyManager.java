package com.authserver1.authserver1;

import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.nimbusds.jose.jwk.RSAKey;

@Component
public class KeyManager {
        public RSAKey rsaKey(){
            try {
              KeyPairGenerator g = KeyPairGenerator.getInstance("RSA");
              g.initialize(2048);
              var kp = g.generateKeyPair();
              RSAPublicKey rsaPublicKey = (RSAPublicKey) kp.getPublic();
              RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) kp.getPrivate();
              
              return new RSAKey.Builder(rsaPublicKey).privateKey(rsaPrivateKey).keyID(UUID.randomUUID().toString()).build();
            } catch (Exception e) {
                // TODO: handle exception
                throw new RuntimeException(":(");
            }
        }
}

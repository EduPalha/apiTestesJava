package com.cursotestesspringboot.config;

import com.cursotestesspringboot.domain.Users;
import com.cursotestesspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

//    @Bean
//    public void startDB(){
//        Users u1 = new Users(null, "EDUARDO", "edupalharini@hotmail.com", "1234");
//        Users u2 = new Users(null, "ISADORA", "isadora.rios2@gmail.com", "4321");
//
//        userRepository.saveAll(List.of(u1,u2));
//    }
}

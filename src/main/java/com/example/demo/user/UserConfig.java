package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository){
        return args ->{
            User wiktor = new User( "wiktork6", "wiktork6@gmail.com");
            User tomek = new User( "tom32", "tom32@gmail.com");
            repository.saveAll(List.of(wiktor,tomek));
        };
    }
}

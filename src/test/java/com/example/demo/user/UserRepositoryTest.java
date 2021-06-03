package com.example.demo.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDow(){
        underTest.deleteAll();
    }


    @Test
    void itShouldFindUserByEmail() {
        //given
        String email = "email@gmail.com";
        User user = new User(
                "login",
                email
        );
        underTest.save(user);
        //when
        Optional<User> userOptional = underTest.findUserByEmail(email);
        //then
        assertThat(userOptional.isPresent()).isTrue();
    }

    @Test
    void itShouldFindUserByLogin() {
        //given
        String email = "email@gmail.com";
        String login = "login";
        User user = new User(
                login,
                email
        );
        underTest.save(user);
        //when
        Optional<User> userOptional = underTest.findUserByLogin(login);
        //then
        assertThat(userOptional.isPresent()).isTrue();
    }
}
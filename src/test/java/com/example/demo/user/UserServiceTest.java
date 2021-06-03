package com.example.demo.user;

import com.example.demo.lecture.Lecture;
import com.example.demo.lecture.LectureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserService underTest;
    @Mock private UserRepository userRepository;
    @Mock private LectureRepository lectureRepository;
    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository, lectureRepository);
    }


    @Test
    void canGetAllUsers() {
        //when
        underTest.getUsers();
        //then
        verify(userRepository).findAll();
    }

    @Test
    @Disabled
    //Does not work
    void canGetUserByLogin() {
        //given
        String login = "login";
        User user = new User(login, "a@gmail.com");
        Lecture lecture1a = new Lecture("a","b","a","a","a",0);
        lectureRepository.save(lecture1a);
        underTest.addNewUser(user,1L);
        //when
        underTest.getUser(login);
        //then
        verify(userRepository).findUserByLogin(login).get();
    }

    @Test
    @Disabled
    //Does not work
    void canAddNewUser() {
        //given
        String email = "email@gmail.com";
        User user = new User("login", email);
        Lecture lecture1a = new Lecture("a","b","a","a","a",0);
        lectureRepository.save(lecture1a);
        //when
        underTest.addNewUser(user,1L);
        //then
        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);
        verify(userRepository)
                .save(userArgumentCaptor.capture());
        User capturedUser = userArgumentCaptor.getValue();

        assertThat(capturedUser).isEqualTo(user);

    }

    @Test
    @Disabled
    void deleteUser() {
    }

    @Test
    @Disabled
    void deleteLectureFromUser() {
    }

    @Test
    @Disabled
    void getLectures() {
    }

    @Test
    @Disabled
    void updateUser() {
    }
}
package com.example.demo.lecture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LectureServiceTest {


    @Mock
    private LectureRepository lectureRepository;
    private LectureService underTest;
    @BeforeEach
    void setUp() {
        underTest = new LectureService(lectureRepository);
    }

    @Test
    void canGetAllLectures() {
        //given
        underTest.getLectures();
        //then
        verify(lectureRepository).findAll();
    }

    @Test
    @Disabled
    void canGetLecture() {

    }
}
package com.example.demo.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;
    @Autowired
    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }
    public List<Lecture> getLectures(){
        return lectureRepository.findAll();
    }
    public Lecture getLecture(Long lectureId){
        return lectureRepository.findById(lectureId).get();
    }
}

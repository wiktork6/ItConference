package com.example.demo.lecture;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "lectures")
@CrossOrigin(origins = "http://localhost:3000")
public class LectureController {
    private final LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping
    public List<Lecture> getLectures() {
        return lectureService.getLectures();
    }

    @GetMapping(path = "{lectureId}")
    public Lecture getLecture(@PathVariable("lectureId") Long lectureId) {
        return lectureService.getLecture(lectureId);
    }
}


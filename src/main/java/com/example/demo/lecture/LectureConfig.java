package com.example.demo.lecture;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LectureConfig {
    @Bean
    CommandLineRunner commandLineRunnerLecture(LectureRepository repository){
        return args ->{
            Lecture lecture1a = new Lecture("2021-06-01:10:00","2021-06-01:11:45","Artificial Intelligence","History of AI","This is Lecture plan",0);
            Lecture lecture1b = new Lecture("2021-06-01:12:00","2021-06-01:13:45","Artificial Intelligence","Computer Vision","This is Lecture plan",0);
            Lecture lecture1c = new Lecture("2021-06-01:14:00","2021-06-01:15:45","Artificial Intelligence","Robotics","This is Lecture plan",0);
            Lecture lecture2a = new Lecture("2021-06-01:10:00","2021-06-01:11:45","Web Technologies","HTTP","This is Lecture plan",0);
            Lecture lecture2b = new Lecture("2021-06-01:12:00","2021-06-01:13:45","Web Technologies","Security","This is Lecture plan",0);
            Lecture lecture2c = new Lecture("2021-06-01:14:00","2021-06-01:15:45","Web Technologies","The World Wide Web: Past, Present and Future","This is Lecture plan",0);
            Lecture lecture3a = new Lecture("2021-06-01:10:00","2021-06-01:11:45","Embedded Systems","Microprocessors","This is Lecture plan",0);
            Lecture lecture3b = new Lecture("2021-06-01:12:00","2021-06-01:13:45","Embedded Systems","Embedded software architectures","This is Lecture plan",0);
            Lecture lecture3c = new Lecture("2021-06-01:14:00","2021-06-01:15:45","Embedded Systems","Microcontrollers","This is Lecture plan",0);
            repository.saveAll(List.of(
                    lecture1a,
                    lecture1b,
                    lecture1c,
                    lecture2a,
                    lecture2b,
                    lecture2c,
                    lecture3a,
                    lecture3b,
                    lecture3c));
        };
    }
}

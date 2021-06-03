package com.example.demo.user;

import com.example.demo.lecture.Lecture;
import com.example.demo.lecture.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    @Autowired
    public UserService(UserRepository userRepository, LectureRepository lectureRepository) {
        this.userRepository = userRepository;
        this.lectureRepository = lectureRepository;
    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUser(String login) {
        return userRepository.findUserByLogin(login).get();
    }

    public void addNewUser(User user, Long lectureId){
        Optional<User> userOptional = userRepository
                .findUserByLogin(user.getLogin());
        if(userOptional.isPresent() && !userOptional.get().getEmail().equals(user.getEmail())){
            throw new IllegalStateException("login taken");
        }
        Lecture lecture = lectureRepository.getById(lectureId);
        if(lecture.getRegisteredParticipants()==5){
            throw new IllegalStateException("Maximum number of participants was achieved");
        }
        if(!userOptional.isPresent()){
            lecture.setRegisteredParticipants(lecture.getRegisteredParticipants()+1);
            user.addLecture(lecture);
            createNotification(user, lecture);
            userRepository.save(user);
        }else{
            Set<Lecture> registeredLectures = userOptional.get().getRegisteredLectures();
            for(Lecture registeredLecture : registeredLectures){
                if(registeredLecture.getId()==lectureId){
                    throw new IllegalStateException("You are already registered");
                }
                if(registeredLecture.getEndDate().equals(lectureRepository.getById(lectureId).getEndDate())){
                    throw new IllegalStateException("You take part in simultaneous lecture");
                }
            }
            lecture.setRegisteredParticipants(lecture.getRegisteredParticipants()+1);
            userOptional.get().addLecture(lecture);
            createNotification(user, lecture);
            userRepository.save(userOptional.get());
        }
    }

    private void createNotification(User user, Lecture lecture){
        File file = new File("notifications.txt");
        String notification =
                        "\n" +
                        "Email sent on: " + LocalDateTime.now().toString() + ",\n" +
                        "to: " + user.getEmail() + "\n" +
                        "You have registered for \n" +
                        lecture.getTitle() + " - " + lecture.getSubject() + "\n" +
                        "which will take place on " +
                        lecture.getStartDate() + " \n";
        try{
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fileWriter);
            pw.write(notification);
            pw.close();
        }catch(IOException e){
        }
    }


    public void deleteUser(Long userId){
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException(
                    "User with id: " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    public void deleteLectureFromUser(String login, Long lectureId){
        User user = userRepository.findUserByLogin(login).get();
        Set<Lecture> lectures = user.getRegisteredLectures();
        for(Lecture lecture : lectures){
            if(lecture.getId()==lectureId){
                lectures.remove(lecture);
                lecture.setRegisteredParticipants(lecture.getRegisteredParticipants()-1);
                break;
            }
        }
        user.setRegisteredLectures(lectures);
        userRepository.save(user);
    }

    public Set<Lecture> getLectures(Long userId){
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException(
                    "User with id: " + userId + " does not exist");
        }
        User user = userRepository.getById(userId);
        return user.getRegisteredLectures();
    }

    @Transactional
    public void updateUser(String login, String email){
        User user = userRepository.findUserByLogin(login)
                .orElseThrow(()-> new IllegalStateException(
                        "User with login " + login + " does not exist"
                ));
        user.setEmail(email);
    }

}

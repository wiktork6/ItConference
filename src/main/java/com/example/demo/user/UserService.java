package com.example.demo.user;

import com.example.demo.lecture.Lecture;
import com.example.demo.lecture.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    //TODO Remove this and in body lecture
    private final LectureRepository lectureRepository;

    @Autowired
    public UserService(UserRepository userRepository, LectureRepository lectureRepository) {
        this.userRepository = userRepository;
        this.lectureRepository = lectureRepository;
    }


    public List<User> getUsers() {
        return userRepository.findAll();
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
            userRepository.save(user);
        }else{
            Set<Lecture> registeredLectures = userOptional.get().getRegisteredLectures();
            for(Lecture registeredLecture : registeredLectures){
                if(registeredLecture.getId()==lectureId){
                    throw new IllegalStateException("You are already registered");
                }
                if(registeredLecture.getEndDate().equals(lectureRepository.getById(lectureId).getEndDate())){
                    throw new IllegalStateException("You take part in similitanius lecture");
                }
            }
            lecture.setRegisteredParticipants(lecture.getRegisteredParticipants()+1);
            userOptional.get().addLecture(lecture);
            userRepository.save(userOptional.get());
        }
    }


    public void deleteUser(Long userId){
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException(
                    "user with id: " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    public Set<Lecture> getLectures(Long userId){
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException(
                    "user with id: " + userId + " does not exist");
        }
        User user = userRepository.getById(userId);
        return user.getRegisteredLectures();
    }

    @Transactional
    public void updateUser(Long userId, String email){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalStateException(
                        "User with id " + userId + " does not exist"
                ));
        user.setEmail(email);
    }

}

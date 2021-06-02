package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user){
        Optional<User> userOptional = userRepository
                .findUserByLogin(user.getLogin());
        if(userOptional.isPresent()){
            throw new IllegalStateException("login taken");
        }
        userRepository.save(user);
        System.out.println(user);
    }

    public void deleteUser(Long userId){
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException(
                    "user with id: " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
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

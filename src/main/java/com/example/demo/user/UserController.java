package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping(path = "{login}")
    public User getLectures(@PathVariable("login") String login){
        return userService.getUser(login);
    }

    @DeleteMapping(path = "{login}/{lectureId}")
    public void deleteLectureFromUser(@PathVariable("login")String login, @PathVariable Long lectureId){
        userService.deleteLectureFromUser(login, lectureId);
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user, Long lectureId){
        userService.addNewUser(user, lectureId);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long id){
        userService.deleteUser(id);
    }

    @PutMapping(path = "{userId}")
    public void updateStudent(
            @PathVariable("userId") Long userId,
            String email){
        userService.updateUser(userId, email);
    }

}

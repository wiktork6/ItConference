package com.example.demo.user;

import com.example.demo.lecture.Lecture;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String login;
    private String email;
    @JsonIgnoreProperties({"registeredUsers"})
    @ManyToMany
    @JoinTable(
            name = "participants",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id")
    )
    private Set<Lecture> registeredLectures= new HashSet<>();

    public User() {
    }

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public User(Long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Lecture> getRegisteredLectures() {
        return registeredLectures;
    }

    public void setRegisteredLectures(Set<Lecture> registeredLectures) {
        this.registeredLectures = registeredLectures;
    }

    public void addLecture(Lecture lecture){
        registeredLectures.add(lecture);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

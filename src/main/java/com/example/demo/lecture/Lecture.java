package com.example.demo.lecture;

import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Lecture {
    @Id
    @SequenceGenerator(
            name = "lecture_sequence",
            sequenceName = "lecture_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lecture_sequence"
    )
    private Long id;
    private String startDate;
    private String endDate;
    private String title;
    private String subject;
    private String lecturePlan;
    private int registeredParticipants;
    @JsonIgnoreProperties({"registeredLectures"})
    @ManyToMany(mappedBy = "registeredLectures")
    private Set<User> registeredUsers = new HashSet<>();

    public Lecture() {
    }

    public Lecture(Long id) {
        this.id = id;
    }

    public Lecture(String startDate, String endDate, String title, String subject, String lecturePlan, int registeredParticipants) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.subject = subject;
        this.lecturePlan = lecturePlan;
        this.registeredParticipants = registeredParticipants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLecturePlan() {
        return lecturePlan;
    }

    public void setLecturePlan(String lecturePlan) {
        this.lecturePlan = lecturePlan;
    }

    public int getRegisteredParticipants() {
        return registeredParticipants;
    }

    public void setRegisteredParticipants(int registeredParticipants) {
        this.registeredParticipants = registeredParticipants;
    }

    public void addParticipant(User user){
        registeredUsers.add(user);
    }

    public Set<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(Set<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", lecturePlan='" + lecturePlan + '\'' +
                ", registeredParticipants=" + registeredParticipants +
                '}';
    }
}

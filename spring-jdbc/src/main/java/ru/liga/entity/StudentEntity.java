package ru.liga.entity;

import java.time.LocalDate;

public class StudentEntity {
    private Long id;
    private String fio;
    private String gender;
    private Integer department_id;
    private Integer course;
    private LocalDate birthday;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String fio, String gender, Integer department_id, Integer course, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.department_id = department_id;
        this.course = course;
        this.birthday = birthday;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}

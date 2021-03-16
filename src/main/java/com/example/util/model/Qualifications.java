package com.example.util.model;

import javax.persistence.*;

@Entity
@Table(name = "qualifications")
public class Qualifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String collegeDegree;
    private String curses;
    private String languages;


    @OneToOne(mappedBy = "qualifications")
    private Employee employee;

    public Qualifications() {
    }

    public Qualifications(String collegeDegree, String curses, String languages) {
        this.collegeDegree = collegeDegree;
        this.curses = curses;
        this.languages = languages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollegeDegree() {
        return collegeDegree;
    }

    public void setCollegeDegree(String collegeDegree) {
        this.collegeDegree = collegeDegree;
    }

    public String getCurses() {
        return curses;
    }

    public void setCurses(String curses) {
        this.curses = curses;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Qualifications{" +
                "id=" + id +
                ", collegeDegree='" + collegeDegree + '\'' +
                ", curses='" + curses + '\'' +
                ", languages='" + languages + '\'' +
                ", employee=" + employee +
                '}';
    }
}

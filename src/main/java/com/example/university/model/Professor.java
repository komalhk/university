/*
 *
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here

package com.example.university.model;

import javax.persistence.*;
import com.example.university.model.*;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int professorId;

    @Column(name = "name")
    private String professorName;

    @Column(name = "department")
    private String department;

    @ManyToOne
    @JoinColumn(name = "courseid")
    private Course course;

    public Professor() {
    }

    public Professor(int professorId, String professorName, String department, Course course) {
        this.professorId = professorId;
        this.professorName = professorName;
        this.department = department;
        this.course = course;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
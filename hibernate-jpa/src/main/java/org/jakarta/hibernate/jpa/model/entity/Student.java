package org.jakarta.hibernate.jpa.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "under_name")
    private String underName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"}))
    private List<Course> courses;

    public Student() {
        this.courses = new ArrayList<>();
    }

    public Student(String name, String underName) {
        this();
        this.name = name;
        this.underName = underName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnderName() {
        return underName;
    }

    public void setUnderName(String underName) {
        this.underName = underName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.addStudents(this);
    }
}

package org.jakarta.hibernate.jpa.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "professor")
    private String professor;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {
        this.students = new ArrayList<>();
    }

    public Course(String title, String professor) {
        this();
        this.title = title;
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", professor='" + professor + '\'' +
                '}';
    }
}

package com.example.Weekly_Test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studId;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_age")
    private String age;
    @Column(name = "student_phone_number")
    private String phno;
    @Column(name = "student_branch")
    private String branch;
    @Column(name = "student_department")
    private String dept;


    @ManyToMany(mappedBy = "studentList")
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    @Embedded
    private Address address;

}

package com.example.Weekly_Test.repository;

import com.example.Weekly_Test.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}

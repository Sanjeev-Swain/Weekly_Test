package com.example.Weekly_Test.repository;

import com.example.Weekly_Test.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}

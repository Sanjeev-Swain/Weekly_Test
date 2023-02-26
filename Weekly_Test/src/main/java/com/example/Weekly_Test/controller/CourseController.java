package com.example.Weekly_Test.controller;

import com.example.Weekly_Test.model.Course;
import com.example.Weekly_Test.model.Laptop;
import com.example.Weekly_Test.service.CourseService;
import com.example.Weekly_Test.service.LaptopService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/course")
public class CourseController {


    @Autowired
    CourseService service;

    @PostMapping("/save-course")
    public ResponseEntity saveCourse(@RequestBody String courseData)
    {
        Course course = setCourse(courseData);
        int courseId = service.saveCourse(course);
        return new ResponseEntity("course saved with id - "+courseId , HttpStatus.CREATED);
    }


    @GetMapping("/get-course")
    public ResponseEntity getCourse(@Nullable @RequestParam String courseId)
    {
        JSONArray courseDetails = service.getCourse(courseId);
        return new ResponseEntity(courseDetails,HttpStatus.OK);
    }

    @PutMapping(value = "/course/{course_id}")
    public ResponseEntity<String> updateCourse(@PathVariable String courseId, @RequestBody String courseData)
    {
        Course course = setCourse(courseData);
        service.updateCourse(course,courseId);
        return new ResponseEntity("course updated", HttpStatus.CREATED);
    }

    private Course setCourse(String courseData)
    {
        JSONObject jsonObject =new JSONObject(courseData);
        Course course =new Course();
        course.setCourseTitle(jsonObject.getString("course_title"));
        course.setCourseDescription(jsonObject.getString("course_description"));
        course.setDuration(jsonObject.getString("course_duration"));
        return course;
    }

}

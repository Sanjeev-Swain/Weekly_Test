package com.example.Weekly_Test.service;

import com.example.Weekly_Test.model.Course;
import com.example.Weekly_Test.model.Laptop;
import com.example.Weekly_Test.repository.CourseRepository;
import com.example.Weekly_Test.repository.LaptopRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    @Autowired
    CourseRepository courseRepository;

    public int saveCourse(Course course) {
        Course courseObj = courseRepository.save(course);
        return courseObj.getCourseId();
    }

    public JSONArray getCourse(String courseId) {
        JSONArray courseArray = new JSONArray();
        if (null != courseId && courseRepository.findById(Integer.valueOf(courseId)).isPresent()) {
            Course course = courseRepository.findById(Integer.valueOf(courseId)).get();
            JSONObject userObj = setCourse(course);
            courseArray.put(userObj);
        } else {
            List<Course> courseList = courseRepository.findAll();
            for (Course course : courseList) {
                JSONObject courseObj = setCourse(course);
                courseArray.put(courseObj);
            }
        }
        return courseArray;
    }

    private JSONObject setCourse(Course course) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("courseID",course.getCourseId());
        jsonObject.put("courseID",course.getCourseTitle());
        jsonObject.put("courseID",course.getCourseDescription());
        jsonObject.put("course_duration",course.getDuration());
        return jsonObject;
    }

    public void updateCourse(Course newCourse, String courseId) {
        if (courseRepository.findById(Integer.valueOf(courseId)).isPresent()) {
            Course course = courseRepository.findById(Integer.valueOf(courseId)).get();
            course.setCourseTitle(newCourse.getCourseTitle());
            course.setCourseDescription(newCourse.getCourseDescription());
            course.setDuration(newCourse.getDuration());

            courseRepository.save(course);
        }


    }


}

package com.example.Weekly_Test.controller;

import com.example.Weekly_Test.model.Student;
import com.example.Weekly_Test.service.StudentService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentService service;


    @PostMapping("/save-student")
    public ResponseEntity saveUser(@RequestBody String studentData)
    {
        Student student = setStudent(studentData);
        int studentId = service.saveStudent(student);
        return new ResponseEntity("student saved with id - "+studentId , HttpStatus.CREATED);
    }


    @GetMapping("/get-student")
    public ResponseEntity getStudent(@Nullable @RequestParam String studId)
    {
        JSONArray studentDetails = service.getStudent(studId);
        return new ResponseEntity(studentDetails,HttpStatus.OK);
    }

    @PutMapping(value = "/student/{student_id}")
    public ResponseEntity<String> updateStudent(@PathVariable String studId,@RequestBody String studentData)
    {
        Student student = setStudent(studentData);
        service.updateStudent(student,studId);
        return new ResponseEntity("student updated", HttpStatus.CREATED);
    }

    private Student setStudent(String studentData)
    {
        JSONObject jsonObject =new JSONObject(studentData);
        Student student =new Student();
        student.setName(jsonObject.getString("name"));
        student.setAge(jsonObject.getString("age"));
        student.setPhno(jsonObject.getString("phno"));
        student.setBranch(jsonObject.getString("branch"));
        student.setDept(jsonObject.getString("dept"));
        return student;
    }


}

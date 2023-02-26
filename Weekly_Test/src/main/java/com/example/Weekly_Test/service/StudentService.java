package com.example.Weekly_Test.service;

import com.example.Weekly_Test.model.Student;
import com.example.Weekly_Test.repository.StudentRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public int saveStudent(Student student)
    {
        Student studentObj = studentRepository.save(student);
        return studentObj.getStudId();
    }

    public JSONArray getStudent(String studId)
    {
        JSONArray studentArray = new JSONArray();
        if(null != studId && studentRepository.findById(Integer.valueOf(studId)).isPresent())
        {
            Student student = studentRepository.findById(Integer.valueOf(studId)).get();
            JSONObject userObj = setStudent(student);
            studentArray.put(userObj);
        }

        else
        {
            List<Student> studentList = studentRepository.findAll();
            for (Student student: studentList)
            {
                JSONObject studentObj=setStudent(student);
                studentArray.put(studentObj);
            }
        }
        return studentArray;
    }

    private JSONObject setStudent(Student student)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId",student.getStudId());
        jsonObject.put("name",student.getName());
        jsonObject.put("age",student.getAge());
        jsonObject.put("phno",student.getPhno());
        jsonObject.put("branch",student.getBranch());
        jsonObject.put("dept",student.getDept());

        return jsonObject;
    }

    public void updateStudent(Student newStudent, String studId)
    {
        if(studentRepository.findById(Integer.valueOf(studId)).isPresent())
        {
            Student student = studentRepository.findById(Integer.valueOf(studId)).get();
            student.setName(newStudent.getName());
            student.setAge(newStudent.getAge());
            student.setPhno(newStudent.getPhno());
            student.setBranch(newStudent.getBranch());
            student.setDept(newStudent.getDept());


            studentRepository.save(student );
        }
    }
}

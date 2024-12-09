package com.springboot.springboot_restapi.controller;

import com.springboot.springboot_restapi.bean.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // Endpoint to fetch a single student (hardcoded example)
    // URL: http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Brahim", "Chabbya", "51024900");
    }

    // Endpoint to fetch a list of students
    // URL: http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Brahim", "Chabbyaa", "51024909"));
        students.add(new Student(2, "Zou", "Chabbyaz", "51024970"));
        students.add(new Student(3, "Toure", "Chabbyas", "51024400"));
        return students;
    }

    // Spring boot with RESTful API using PathVariable
    //localhost:8080/student/2/Zou
    //{id} is URL template variable
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        // You can later modify this to fetch the student details from a database.
        return new Student(id, "Zou", "Chabbyaz", "51024970");
    }

    @GetMapping("/student/{id}/{name}")
    public Student getStudentByIdAndName(@PathVariable("id") int id, @PathVariable("name") String name) {
        // You can later modify this to fetch the student details from a database.
        return new Student(id, name, "Chabbyaz", "51024970");
    }

    //Spring boot with RESTful API using PathVariable
    //http://localhost:8080/student/2
    //http://localhost:8080/student?id=2
    //?id=2 is request parameter


    @GetMapping("student/query")
    public Student studentRequestvariable(@RequestParam int id) {
        return new Student(id, "Zou", "Chabbyaz", "51024970");
    }
    //Spring boot Rest API that handles HTTP Post request
    //http://localhost:8080/student/create
    @PostMapping("student/create")
    public Student createStudent(@RequestBody Student student) {
        return student;
    }
}
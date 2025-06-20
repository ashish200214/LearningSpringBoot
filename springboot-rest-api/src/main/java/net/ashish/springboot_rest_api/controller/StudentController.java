package net.ashish.springboot_rest_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import net.ashish.springboot_rest_api.bean.Student;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent(){
        Student s = new Student(
            1,
            "Ashish",
             "Gavali"
        );
        return s;
    }

    //returning the list of student.
    @GetMapping("/list")
    public List<Student> getAllStudent(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Ashish", "Gavali"));
        studentList.add(new Student(2,"suyash" , "Gawali"));
        studentList.add(new Student(3,"sanjay","kulkarni"));

        return studentList;
    }

    //spring boot rest api using path variable
    
    //{id} is called URL template variable
    @GetMapping("/student/{id}/{fname}/{lname}")
    public Student createOneStudent(@PathVariable int id,@PathVariable String fname,@PathVariable String lname){
        return new Student(id,fname,lname);
    }

    //use of RequestParam : It is used to get the value from the user through request parameter.

    //localhost:8080/students/query?id=1&firstName=Ashish&lastName=gawali
    @GetMapping("students/query")
    public Student ss(@RequestParam  int id,@RequestParam String firstName,@RequestParam String lastName ){
        return new Student(id,firstName,lastName);
    }


}

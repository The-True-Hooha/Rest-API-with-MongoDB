package com.TheTrueHooha.Rest.API.with.MongoDB.Controller;

import com.TheTrueHooha.Rest.API.with.MongoDB.Services.StudentService;
import com.TheTrueHooha.Rest.API.with.MongoDB.User.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudent () {
        return studentService.getAllStudents();
    }
}

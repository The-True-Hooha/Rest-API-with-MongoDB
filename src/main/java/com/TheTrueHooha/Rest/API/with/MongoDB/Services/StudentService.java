package com.TheTrueHooha.Rest.API.with.MongoDB.Services;

import com.TheTrueHooha.Rest.API.with.MongoDB.Repository.StudentRepository;
import com.TheTrueHooha.Rest.API.with.MongoDB.User.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

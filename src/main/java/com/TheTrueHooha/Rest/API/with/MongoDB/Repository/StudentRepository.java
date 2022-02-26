package com.TheTrueHooha.Rest.API.with.MongoDB.Repository;

import com.TheTrueHooha.Rest.API.with.MongoDB.User.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface StudentRepository extends MongoRepository <Student, String>{

    //writing custom queries from method names
    Optional<Student> findStudentByEmail (String email);

}

package com.TheTrueHooha.Rest.API.with.MongoDB.Repository;

import com.TheTrueHooha.Rest.API.with.MongoDB.User.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <Student, String>{

    //writing custom queries from method names

}

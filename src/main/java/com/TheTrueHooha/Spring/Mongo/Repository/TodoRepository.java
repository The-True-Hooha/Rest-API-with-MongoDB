package com.TheTrueHooha.Spring.Mongo.Repository;

import com.TheTrueHooha.Spring.Mongo.Model.TodoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends MongoRepository<TodoDTO, String> {

    @Query("{'tasks': ?0}")
    Optional<TodoDTO> findByTasks(String tasks);
}

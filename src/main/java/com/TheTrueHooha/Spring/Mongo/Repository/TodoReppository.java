package com.TheTrueHooha.Spring.Mongo.Repository;

import com.TheTrueHooha.Spring.Mongo.Model.TodoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoReppository extends MongoRepository<TodoDTO, String> {
}

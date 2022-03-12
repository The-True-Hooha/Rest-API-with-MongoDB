package com.TheTrueHooha.Spring.Mongo.Controllers;

import com.TheTrueHooha.Spring.Mongo.Model.TodoDTO;
import com.TheTrueHooha.Spring.Mongo.Repository.TodoReppository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoReppository todoReppository;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllTodo() {
        List<TodoDTO> todoDTOS = todoReppository.findAll();
        if (todoDTOS.size() > 0) {
            return new ResponseEntity<List<TodoDTO>>(todoDTOS, HttpStatus.OK);
        }else {
            return new ResponseEntity<>
                    ("sorry, no tasks found, please get your tasks assigned", HttpStatus.NOT_FOUND);
        }

    }
}

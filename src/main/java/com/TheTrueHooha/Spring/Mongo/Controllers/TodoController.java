package com.TheTrueHooha.Spring.Mongo.Controllers;

import com.TheTrueHooha.Spring.Mongo.Model.TodoDTO;
import com.TheTrueHooha.Spring.Mongo.Repository.TodoReppository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/create-new")
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO todoDTO) {
        try {
            todoDTO.setCreatedAt(new Date(System.currentTimeMillis()));
            todoReppository.save(todoDTO);
            return new ResponseEntity<TodoDTO>(todoDTO, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-todo/{id}")
    public ResponseEntity<?> getTask(@PathVariable("id") String id) {
        Optional<TodoDTO> dto = todoReppository.findById(id);
        if (dto.isPresent()) {
            return new ResponseEntity<>(dto.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("sorry, cannot find task with ID " + id, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-todo/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") String id, @RequestBody TodoDTO todo) {
        Optional<TodoDTO> dto = todoReppository.findById(id);
        if (dto.isPresent()) {
            TodoDTO todoSave = dto.get();
            todoSave.setCompleted(todo.getCompleted() != null ? todo.getCompleted() : todoSave.getCompleted());
            todoSave.setTasks(todo.getTasks() != null ? todo.getTasks(): todoSave.getTasks());
            todoSave.setDescription(todo.getDescription() != null ? todo.getDescription() : todoSave.getDescription());
            todoSave.setCategory(todo.getCategory() != null ? todo.getCategory() : todoSave.getCategory());
            todoSave.setUpdatedAt(new Date(System.currentTimeMillis()));
            todoReppository.save(todoSave);
            return new ResponseEntity<>(todoSave, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("sorry, cannot find task with ID " + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-task{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        try {
            todoReppository.deleteById(id);
            return new ResponseEntity<>("successfully deleted tasks with id " + id, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}


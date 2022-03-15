package com.TheTrueHooha.Spring.Mongo.Controllers;

import com.TheTrueHooha.Spring.Mongo.Exception.TodoException;
import com.TheTrueHooha.Spring.Mongo.Model.TodoDTO;
import com.TheTrueHooha.Spring.Mongo.Repository.TodoRepository;
import com.TheTrueHooha.Spring.Mongo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolationException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllTodo() {
        List<TodoDTO> todos = todoService.getAllTasks();
       return new ResponseEntity<>(todos,todos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-new")
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO todoDTO) {
        try {
            //todoDTO.setCreatedAt(new Date(System.currentTimeMillis()));
            //todoRepository.save(todoDTO);
            todoService.createTasks(todoDTO);
            return new ResponseEntity<TodoDTO>(todoDTO, HttpStatus.OK);
        } catch (ConstraintViolationException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (TodoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get-todo/{id}")
    public ResponseEntity<?> getTask(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(todoService.getTask(id), HttpStatus.OK);
        } catch (TodoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-todo/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") String id, @RequestBody TodoDTO todo) {
        try {
            todoService.updateTask(id, todo);
            return new ResponseEntity<>("update todo with id " + id, HttpStatus.OK)
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (TodoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/delete-task{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        try {
            todoService.deleteTaskById(id);
            return new ResponseEntity<>("successfully deleted tasks with id " + id, HttpStatus.OK);
        }catch (TodoException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}


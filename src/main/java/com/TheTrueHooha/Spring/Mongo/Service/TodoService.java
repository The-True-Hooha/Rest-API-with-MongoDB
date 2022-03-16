package com.TheTrueHooha.Spring.Mongo.Service;


import com.TheTrueHooha.Spring.Mongo.Exception.TodoException;
import com.TheTrueHooha.Spring.Mongo.Model.TodoDTO;
import javax.validation.ConstraintViolationException;

import java.util.List;

public interface TodoService {

    void createTasks(TodoDTO todo) throws ConstraintViolationException, TodoException;

    List<TodoDTO> getAllTasks();

    TodoDTO getTask(String id) throws TodoException;

    void updateTask(String id, TodoDTO todoDTO) throws TodoException;

    void deleteTaskById(String id) throws TodoException;
}

//todo: connect to mongodb atlas online
// TODO: 15/03/2022 update pom.xml dependency

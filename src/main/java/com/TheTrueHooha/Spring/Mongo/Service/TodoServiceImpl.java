package com.TheTrueHooha.Spring.Mongo.Service;

import com.TheTrueHooha.Spring.Mongo.Exception.TodoException;
import com.TheTrueHooha.Spring.Mongo.Model.TodoDTO;
import com.TheTrueHooha.Spring.Mongo.Repository.TodoRepository;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    private TodoRepository todoRepo;
    @Override
    public void createTasks(TodoDTO todo) throws ConstraintViolationException, TodoException {
        Optional<TodoDTO> todoOptional = todoRepo.findByTasks(todo.getTasks());
        if (todoOptional.isPresent()) {
            throw new TodoException(TodoException.TodoAlreadyExist());
        } else {
            todo.setCreatedAt(new Date(System.currentTimeMillis()));
            todoRepo.save(todo);
        }
    }

    @Override
    public List<TodoDTO> getAllTasks() {
        List<TodoDTO> todoGetAll = todoRepo.findAll();
        if (todoGetAll.size() > 0 ) {
            return todoGetAll;
        } else {
            return new ArrayList<TodoDTO>();
        }
    }

    @Override
    public TodoDTO getTask(String id) throws TodoException {
        Optional<TodoDTO> todoOptional = todoRepo.findById(id);
        if (!todoOptional.isPresent()) {
            throw new TodoException(TodoException.NotFoundException(id));
        }else {
            return todoOptional.get();
        }
    }

    @Override
    public void updateTask(String id, TodoDTO todo) throws TodoException {
        Optional<TodoDTO> todoWithId = todoRepo.findById(id);
        Optional<TodoDTO> todoCheck = todoRepo.findByTasks(todo.getTasks());

        if (todoWithId.isPresent()) {

            if (todoCheck.isPresent() && todoCheck.get().getId().equals(id)) {
                throw new TodoException(TodoException.TodoAlreadyExist());
            }
            TodoDTO updateTodo = todoWithId.get();
            updateTodo.setTasks(todo.getTasks());
            updateTodo.setDescription(todo.getDescription());
            updateTodo.setCompleted(todo.getCompleted());
            updateTodo.setUpdatedAt(new Date(System.currentTimeMillis()));
            updateTodo.setCategory(todo.getCategory());
            todoRepo.save(updateTodo);
        } else {
            throw new TodoException(TodoException.NotFoundException(id));
        }
    }

    @Override
    public void deleteTaskById(String id) throws TodoException {
        Optional<TodoDTO> todoDelete = todoRepo.findById(id);
        if (!todoDelete.isPresent()) {
            throw new TodoException(TodoException.NotFoundException());
        } else {
            todoRepo.deleteById(id);
        }
    }
}

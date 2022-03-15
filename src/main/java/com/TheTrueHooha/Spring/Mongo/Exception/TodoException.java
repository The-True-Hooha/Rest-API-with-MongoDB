package com.TheTrueHooha.Spring.Mongo.Exception;

public class TodoException extends Exception{

    private static final long SerialVersionUID = 1L;

    public TodoException(String message) {
        super(message);
    }

    public static String NotFoundException(String id) {
        return "task with id " + id + " not found";
    }

    public static String TodoAlreadyExist() {
        return "tasks with given name already exist";
    }
}

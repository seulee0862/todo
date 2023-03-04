package com.todo.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoResult<T> {

    private boolean success;
    private String message;
    private T data;

    public TodoResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}

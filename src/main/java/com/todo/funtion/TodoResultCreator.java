package com.todo.funtion;

import com.todo.model.TodoResult;
import com.todo.model.Todo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TodoResultCreator {

    public TodoResult getTodoList(List<Todo> todoList) {

        String msg = "Todo list num is " + todoList.size();
        return new TodoResult(true, msg, todoList);
    }

    public TodoResult getTodo(Optional<Todo> todo) {

        String msg = todo.isPresent() ? "success" : "fail";
        boolean success = todo.isPresent() ? true : false;
        return new TodoResult(success, msg, todo);
    }

    public TodoResult createTodo(Boolean success) {

        String msg = success == true ? "success" : "fail";
        return new TodoResult(success, msg, null);
    }

    public TodoResult editTodo(Boolean success) {

        String msg = success == true ? "success" : "fail";
        return new TodoResult(success, msg, null);
    }

    public TodoResult deleteTodo(Boolean success) {

        String msg = success == true ? "success" : "fail";
        return new TodoResult(success, msg, null);
    }
}

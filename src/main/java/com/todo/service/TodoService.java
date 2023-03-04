package com.todo.service;

import com.todo.model.TodoResult;
import com.todo.model.Todo;
import com.todo.funtion.TodoCRUD;
import com.todo.funtion.TodoResultCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoCRUD todoCRUD;
    private final TodoResultCreator todoResultCreator;

    public TodoResult getTodoList() {

        return todoResultCreator.getTodoList(todoCRUD.findAllTodo());
    }

    public TodoResult getTodo(Long todoNum) {

        return todoResultCreator.getTodo(todoCRUD.getTodoById(todoNum));
    }

    public TodoResult createTodo(Todo todo) {

        return todoResultCreator.createTodo(todoCRUD.saveTodo(todo));
    }

    public TodoResult editTodo(Long todoNum,Todo todo) {

        return todoResultCreator.editTodo(todoCRUD.editTodo(todoNum, todo));
    }

    public TodoResult deleteTodo(Long todoNum) {

        return todoResultCreator.deleteTodo(todoCRUD.deleteTodoById(todoNum));
    }


}

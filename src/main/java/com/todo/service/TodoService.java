package com.todo.service;

import com.todo.Todo;
import com.todo.funtion.TodoFunction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoFunction todoFunction;

    public List<Todo> getTodoList() {

        return todoFunction.findAllTodo();
    }

    public Optional<Todo> getTodo(Long todoNum) {

        return todoFunction.getTodoById(todoNum);
    }

    public boolean createTodo(Todo newTodo) {

        return todoFunction.saveTodo(newTodo);
    }

    public boolean editTodo(Long todoNum, String todoContent, char todoSuccess) {

        return todoFunction.editTodo(todoNum, todoContent, todoSuccess);
    }

    public boolean deleteTodo(Long todoNum) {

        return todoFunction.deleteTodoById(todoNum);
    }


}

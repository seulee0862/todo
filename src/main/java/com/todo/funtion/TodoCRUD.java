package com.todo.funtion;

import com.todo.model.Todo;
import com.todo.respository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class TodoCRUD {

    private final TodoRepository todoRepository;

    public List<Todo> findAllTodo() {

        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long todoNum) {

        Optional<Todo> todo = todoRepository.findById(todoNum);

        return todo;
    }

    public boolean saveTodo(Todo newTodo) {

        Todo saveTodo = todoRepository.save(newTodo);
        if (saveTodo != null) return true;
        else return false;
    }

    public boolean editTodo(Long todoNum,Todo todo) {


        Todo currentTodo = getTodoById(todoNum).get();

        currentTodo.setTodoContent(todo.getTodoContent());
        currentTodo.setTodoSuccess(todo.getTodoSuccess());

        return saveTodo(currentTodo);
    }

    public boolean deleteTodoById(Long todoNum) {

        Optional<Todo> toDeleteTodo = getTodoById(todoNum);

        if (toDeleteTodo.isPresent()) {
            todoRepository.delete(toDeleteTodo.get());
            return true;
        }
        else {
            return false;
        }
    }
}

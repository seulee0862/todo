package com.todo.funtion;

import com.todo.Todo;
import com.todo.respository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class TodoFunction {

    private final TodoRepository todoRepository;

    public List<Todo> findAllTodo() {

        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long todoNum) {

        log.info("start getById");

        Optional<Todo> todo = todoRepository.findById(todoNum);
        if (todo.isEmpty()) throw new IllegalArgumentException();

        log.info("todoNum : {}, todoIsExists : {}", todoNum, todo.isPresent());
        log.info("end getById");

        return todo;
    }

    public boolean saveTodo(Todo newTodo) {

        Todo saveTodo = todoRepository.save(newTodo);
        if (saveTodo != null) return true;
        else return false;
    }

    public boolean editTodo(Long todoNum, String newTodoContent, char todoSuccess) {


        Todo currentTodo = getTodoById(todoNum).get();

        currentTodo.setTodoContent(newTodoContent);
        currentTodo.setTodoSuccess(todoSuccess);

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

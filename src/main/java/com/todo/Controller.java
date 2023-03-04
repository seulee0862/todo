package com.todo;

import com.todo.model.Todo;
import com.todo.model.TodoResult;
import com.todo.funtion.TodoValidator;
import com.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/todo")
@RestController
@RequiredArgsConstructor
public class Controller {

    private final TodoService todoService;
    private final TodoValidator todoValidator;

    @GetMapping("")
    public ResponseEntity<TodoResult> getTodoList(){

        TodoResult result = todoService.getTodoList();
        if (result.isSuccess()) {
            return ResponseEntity
                    .ok(result);
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body(new TodoResult(false, result.getMessage(), null));
        }
    };

    @GetMapping("/{todo_no}")
    public ResponseEntity<TodoResult> getTodo(@PathVariable(name = "todo_no") Long todoNum){

        TodoResult result = todoService.getTodo(todoNum);

        if (result.isSuccess()) {
            return ResponseEntity
                    .ok(result);
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body(new TodoResult(false, result.getMessage(), null));
        }
    };

    @PostMapping("")
    public ResponseEntity<TodoResult> createTodo(@RequestBody Todo todo){

        TodoValidator.TodoValidReturnValue valid = todoValidator.valid(todo, "createTodo");
        TodoResult result;
        if (valid.isSuccess()) {
            return ResponseEntity
                    .ok(todoService.createTodo(todo));
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body(new TodoResult(false, valid.getMsg(), null));
        }
    };

    @PatchMapping("/{todo_no}")
    public ResponseEntity<TodoResult> editTodo(@PathVariable(name = "todo_no") Long todoNum,
                            @RequestBody Todo todo){

        TodoResult result = todoService.editTodo(todoNum, todo);
        if (result.isSuccess()) {
            return ResponseEntity
                    .ok(result);
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body(result);
        }
    };

    @DeleteMapping("/{todo_no}")
    public ResponseEntity<TodoResult> deleteTodo(@PathVariable(name = "todo_no") Long todoNum){

        TodoResult result = todoService.deleteTodo(todoNum);
        if (result.isSuccess()) {
            return ResponseEntity
                    .ok(result);
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body(result);
        }
    };

}

package com.todo;

import com.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequestMapping("/todo")
@RestController
@RequiredArgsConstructor
public class Controller {

    /**
     * 할일 조회하기
     * 할일 만들기
     * 할일 수정하기
     *  할일 내용 수정 하기
     *  할일 달성 여부 체크하기
     * 할일 삭제하기
     * 예외 페이지 만들기
     */

    private final TodoService todoService;


    @GetMapping("")
    public List<Todo> getPlanList(){

        return todoService.getTodoList();
    };

    @GetMapping("/{todo_no}")
    public Optional<Todo> getPlan(@PathVariable(name = "todo_no") Long todoNum){

        return todoService.getTodo(todoNum);
    };

    @PostMapping("")
    public boolean createTodo(@RequestBody Todo newTodo){

        return todoService.createTodo(newTodo);
    };

    @PatchMapping("/{todo_no}")
    public boolean editTodo(@PathVariable(name = "todo_no") Long todoNum,
                            @RequestBody String todoContent,
                            @RequestBody char todoSuccess){

        log.info("/{todo_num} (Patcn), todo_no : {}, todoContent : {}, todoSuccess : {}",todoNum, todoContent, todoSuccess);

        return todoService.editTodo(todoNum, todoContent, todoSuccess);
    };

    @DeleteMapping("/{todo_no}")
    public boolean deleteTodo(@PathVariable(name = "todo_no") Long todoNum){

        return todoService.deleteTodo(todoNum);
    };

}

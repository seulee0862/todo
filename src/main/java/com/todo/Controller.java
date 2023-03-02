package com.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/")
    public void getPlanList(){};

    @GetMapping("/{todo_no}")
    public void getPlan(){};

    @PostMapping("/")
    public void createTodo(@RequestBody Todo todo){};

    @PatchMapping("/{todo_no}")
    public void updateTodo(@RequestBody String todoContent, boolean todoSuccess){};

    @DeleteMapping("/{todo_no}")
    public void deleteTodo(){};

}

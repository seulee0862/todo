package com.todo.model;

import lombok.*;

import javax.persistence.*;

@Getter @NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Todo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String todoName;

    @Column
    private String todoContent;

    @Column(columnDefinition = "char(1) default 'N'", nullable = false)
    private char todoSuccess;

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent;
    }

    public void setTodoSuccess(char todoSuccess) {
        this.todoSuccess = todoSuccess;
    }

    @Builder
    public Todo(Long id, String todoName, String todoContent, char todoSuccess) {
        this.id = id;
        this.todoName = todoName;
        this.todoContent = todoContent;
        this.todoSuccess = todoSuccess;
    }
}

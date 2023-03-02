package com.todo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String todoName;

    @Column
    private String todoContent;

    @Column
    private boolean todoSuccess;
}

package com.todo.funtion;

import com.todo.model.Todo;
import com.todo.respository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class TodoValidator {

    private final TodoRepository todoRepository;

    final String nameErrorMsg = "todoName cannot be empty";
    final String contentErrorMsg = "todoContent cannot be empty";
    final String successErrorMsg = "todoSuccess must be Y or B";

    public TodoValidReturnValue valid(Todo todo, String ControllerMethod){

        if (ControllerMethod.equals("createTodo")) {

            String msg = null;
            if (nameIsValid(todo.getTodoName()) == false) msg = nameErrorMsg;
            if (contentIsValid(todo.getTodoContent()) == false) msg = contentErrorMsg;

            if (msg != null) {
                return new TodoValidReturnValue(false, msg);
            }
        }

        if (ControllerMethod.equals("editTodo")) {

            String msg = null;
            if (nameIsValid(todo.getTodoName()) == false) msg = nameErrorMsg;
            if (contentIsValid(todo.getTodoContent()) == false) msg = contentErrorMsg;
            if (successIsValid(todo.getTodoSuccess()) == false) msg = successErrorMsg;

            if (msg != null) {
                return new TodoValidReturnValue(false, msg);
            }
        }

        return new TodoValidReturnValue(true, null);
    }

    public class TodoValidReturnValue {
        boolean success;
        String msg;

        public TodoValidReturnValue(boolean success, String msg) {
            this.success = success;
            this.msg = msg;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }


    public boolean nameIsValid(String todoName) {

        if (todoName == null || todoName.replace(" ","").length() == 0) {
            return false;
        }
        return true;
    }

    public boolean contentIsValid(String todoContent) {

        System.out.println(todoContent);
        if (todoContent == null || todoContent.replace(" ","").length() == 0) {
            return false;
        }
        return true;
    }


    public boolean successIsValid(char todoSuccess) {

        if (todoSuccess == 'Y' || todoSuccess == 'N') {
            return false;
        }
        return true;
    }
}

package com.ayush.todolist.Repository;

import com.ayush.todolist.Entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoRepository {

    private static List<Todo> todos = new ArrayList<>();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "ayush","Learn to Dance 2", new Date(), false ));
        todos.add(new Todo(++idCounter, "ayush","Learn about Microservices 2", new Date(), false ));
        todos.add(new Todo(++idCounter, "ayush","Learn about Angular", new Date(), false ));
        todos.add(new Todo(++idCounter, "ayush","Learn to Dance 2", new Date(), false ));
        todos.add(new Todo(++idCounter, "ayush","Learn about Microservices 2", new Date(), false ));
        todos.add(new Todo(++idCounter, "ayush","Learn about Angular", new Date(), false ));
        todos.add(new Todo(++idCounter, "ayush","Learn to Dance 2", new Date(), false ));
        todos.add(new Todo(++idCounter, "ayush","Learn about Microservices 2", new Date(), false ));
        todos.add(new Todo(++idCounter, "ayush","Learn about Angular", new Date(), false ));
    }

    public List<Todo> findAll() {

        return todos;
    }

    public Todo findById(long id){
        for(Todo todo: todos){
            if(todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo saveTodo(Todo todo) {
        if(todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
        } else {
            deleteById(todo.getId());
        }
         todos.add(todo);
        return todo;
    }

    public Todo deleteById(long id){
        Todo todo = findById(id);
        if (todo == null)
            return null;
        else
           {
               todos.remove(todo);
              return todo;
           }
    }
}

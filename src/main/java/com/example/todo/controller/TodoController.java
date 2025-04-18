package com.example.todo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final List<String> todos = new ArrayList<>(List.of(
        "📌 Learn GitHub Actions",
        "🚀 Deploy to Kubernetes via Minikube",
        "✅ Add root endpoint for health check"
    ));

    @GetMapping
    public List<String> getTodos() {
        return todos;
    }

    @PostMapping
    public String addTodo(@RequestBody String todo) {
        todos.add(todo);
        return "Added: " + todo;
    }
}

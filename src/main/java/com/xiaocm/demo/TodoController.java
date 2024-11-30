package com.xiaocm.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TodoController {

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos() {

        Todo todo1 = new Todo();
        todo1.setId("1");
        todo1.setTitle("Buy milk");
        todo1.add(Link.of("/todos/1").withSelfRel());
        Todo todo2 = new Todo();
        todo2.setId("2");
        todo2.setTitle("Buy eggs");
        todo2.add(Link.of("/todos/2").withSelfRel());
        return ResponseEntity.ok(Arrays.asList(todo1, todo2));
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<EntityModel<Todo>> getTodo(@PathVariable String id) {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setTitle("Buy milk");
        todo.add(Link.of("/todos/" + id).withSelfRel());
        return ResponseEntity.ok(EntityModel.of(todo));
    }
}

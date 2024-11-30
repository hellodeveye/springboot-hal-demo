package com.xiaocm.demo;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Todo extends RepresentationModel<Todo> {
    private String id;
    private String title;
}   

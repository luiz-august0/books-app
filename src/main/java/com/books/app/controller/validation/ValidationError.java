package com.books.app.controller.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ValidationError {
    
    private String error;
    
    private int order;
    
}

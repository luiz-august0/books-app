package com.books.app.controller.validation.interfaces;

import com.books.app.controller.validation.ValidationError;

@FunctionalInterface
public interface IFieldValidation {
    
    ValidationError validate(Object value); 
    
}

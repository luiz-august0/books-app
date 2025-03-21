package com.books.app.controller.abstracts;

import com.books.app.controller.validation.ValidationError;
import com.books.app.controller.validation.interfaces.IFieldValidation;
import com.books.app.model.enums.EnumBookColumn;
import com.books.core.dto.BookDTO;
import com.books.utils.DateUtil;
import com.books.utils.NumericUtil;
import com.books.utils.enums.EnumDateFormat;

import java.util.*;

public abstract class BookAdvisorController {

    private static final Map<String, IFieldValidation> validationsMap = new HashMap<>();

    static {
        validationsMap.put(EnumBookColumn.TITLE.getFieldName(), (value) -> {
            if (value.toString().isEmpty()) {
                return new ValidationError("Título é obrigatório", 0);
            }

            return null;
        });

        validationsMap.put(EnumBookColumn.AUTHORS.getFieldName(), (value) -> {
            if (value.toString().isEmpty()) {
                return new ValidationError("Autores é obrigatório", 1);
            }

            return null;
        });

        validationsMap.put(EnumBookColumn.PUBLISH_DATE.getFieldName(), (value) -> {
            if (value.toString().replaceAll("/", "").trim().isEmpty()) {
                return new ValidationError("Data de publicação é obrigatório", 2);
            }

            if (!DateUtil.isValidDate(value.toString(), EnumDateFormat.DDMMYYYY)) {
                return new ValidationError("Data de publicação é invalida", 2);
            }

            return null;
        });

        validationsMap.put(EnumBookColumn.PUBLISHER.getFieldName(), (value) -> {
            if (value.toString().isEmpty()) {
                return new ValidationError("Editora é obrigatório", 3);
            }

            return null;
        });
    }

    protected List<ValidationError> getValidationErrors(Map<String, Object> values) {
        List<ValidationError> errors = new ArrayList<>();

        values.forEach((field, value) -> {
            IFieldValidation fieldValidation = validationsMap.get(field);

            if (fieldValidation != null) {
                ValidationError validationError = fieldValidation.validate(value);

                if (validationError != null)
                    errors.add(validationError);
            }
        });

        errors.sort(Comparator.comparing(ValidationError::getOrder));

        return errors;
    }

    protected BookDTO getBookFromValues(Map<String, Object> values) {
        return BookDTO.builder()
                .title(values.get("title").toString())
                .authors(values.get("authors").toString())
                .publishDate(DateUtil.formatStringToDate(values.get("publishDate").toString(), EnumDateFormat.DDMMYYYY))
                .isbn(NumericUtil.parseLong(values.get("isbn").toString().replaceAll("-", "").trim()))
                .publisher(values.get("publisher").toString())
                .similarBooks(values.get("similarBooks").toString())
                .build();
    }

}

package com.books.app.controller;

import com.books.app.controller.validation.ValidationError;
import com.books.app.controller.validation.interfaces.IFieldValidation;
import com.books.app.view.BookView;
import com.books.core.dto.BookDTO;
import com.books.core.factory.FactoryResource;
import com.books.core.resource.BookResource;
import com.books.utils.DateUtil;
import com.books.utils.NumericUtil;
import com.books.utils.enums.EnumDateFormat;
import lombok.Setter;

import javax.swing.*;
import java.util.*;

public class BookController {

    private static final Map<String, IFieldValidation> validationsMap = new HashMap<>();
    private final BookView bookView;
    private final BookResource bookResource;

    @Setter
    private Integer bookId = null;

    static {
        validationsMap.put("title", (value) -> {
            if (value.toString().isEmpty()) {
                return new ValidationError("Título é obrigatório", 0);
            }

            return null;
        });

        validationsMap.put("authors", (value) -> {
            if (value.toString().isEmpty()) {
                return new ValidationError("Autores é obrigatório", 1);
            }

            return null;
        });

        validationsMap.put("publishDate", (value) -> {
            if (value.toString().replaceAll("/", "").trim().isEmpty()) {
                return new ValidationError("Data de publicação é obrigatório", 2);
            }

            if (!DateUtil.isValidDate(value.toString(), EnumDateFormat.DDMMYYYY)) {
                return new ValidationError("Data de publicação é invalida", 2);
            }

            return null;
        });

        validationsMap.put("publisher", (value) -> {
            if (value.toString().isEmpty()) {
                return new ValidationError("Editora é obrigatório", 3);
            }

            return null;
        });
    }

    public BookController(BookView bookView) {
        this.bookView = bookView;
        this.bookResource = (BookResource) FactoryResource.getInstance().get(BookResource.class);
    }

    public void onSave() {
        Map<String, Object> values = new HashMap<>();

        values.put("title", bookView.getJTitleField().getText());
        values.put("authors", bookView.getJAuthorsField().getText());
        values.put("publishDate", bookView.getJPublishDateField().getText());
        values.put("isbn", bookView.getJISBNField().getText());
        values.put("publisher", bookView.getJPublisherField().getText());
        values.put("similarBooks", bookView.getJSimilarBooksField().getText());

        save(values);
    }

    public void onSearchISBN() {
        try {
            BookDTO bookDTO = bookResource.searchByISBN(NumericUtil.parseLong(
                    bookView.getJISBNSearchField().getText().replaceAll("-", ""))
            );

            setFieldsByBook(bookDTO);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(bookView, "Ocorreu um erro ao buscar o livro pelo código ISBN");
        }
    }

    private void setFieldsByBook(BookDTO bookDTO) {
        bookView.getJTitleField().setText(bookDTO.getTitle());
        bookView.getJAuthorsField().setText(bookDTO.getAuthors());
        bookView.getJPublishDateField().setText(DateUtil.formatDDMMYYYY(bookDTO.getPublishDate()));
        bookView.getJISBNField().setText(bookDTO.getIsbn().toString());
        bookView.getJPublisherField().setText(bookDTO.getPublisher());
        bookView.getJSimilarBooksField().setText(bookDTO.getSimilarBooks());
    }

    private void save(Map<String, Object> values) {
        if (validate(values)) {
            try {
                BookDTO book = BookDTO.builder()
                        .title(values.get("title").toString())
                        .authors(values.get("authors").toString())
                        .publishDate(DateUtil.formatStringToDate(values.get("publishDate").toString(), EnumDateFormat.DDMMYYYY))
                        .isbn(NumericUtil.parseLong(values.get("isbn").toString().replaceAll("-", "").trim()))
                        .publisher(values.get("publisher").toString())
                        .similarBooks(values.get("similarBooks").toString())
                        .build();

                if (bookId != null) {
                    bookResource.updateBook(bookId, book);
                } else {
                    bookResource.createBook(book);
                }

                JOptionPane.showMessageDialog(bookView, "Livro salvo com sucesso ");
                bookView.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(bookView, "Ocorreu um erro ao salvar o livro: " + e.getMessage());
            }
        }
    }

    private boolean validate(Map<String, Object> values) {
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

        if (!errors.isEmpty()) {
            JOptionPane.showMessageDialog(bookView, String.join("\n", errors.stream().map(ValidationError::getError).toList()));
            return false;
        }

        return true;
    }

}

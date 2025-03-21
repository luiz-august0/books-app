package com.books.app.controller;

import com.books.app.controller.abstracts.BookAdvisorController;
import com.books.app.controller.validation.ValidationError;
import com.books.app.model.enums.EnumBookColumn;
import com.books.app.view.BookView;
import com.books.core.dto.BookDTO;
import com.books.core.factory.FactoryResource;
import com.books.core.resource.BookResource;
import com.books.utils.DateUtil;
import com.books.utils.NumericUtil;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookController extends BookAdvisorController {

    private final BookView bookView;
    private final BookResource bookResource;
    private BookDTO editBook = null;

    public BookController(BookView bookView) {
        this.bookView = bookView;
        this.bookResource = (BookResource) FactoryResource.getInstance().get(BookResource.class);
    }

    public void onSave() {
        Map<String, Object> values = new HashMap<>();

        values.put(EnumBookColumn.TITLE.getFieldName(), bookView.getJTitleField().getText());
        values.put(EnumBookColumn.AUTHORS.getFieldName(), bookView.getJAuthorsField().getText());
        values.put(EnumBookColumn.PUBLISH_DATE.getFieldName(), bookView.getJPublishDateField().getText());
        values.put(EnumBookColumn.ISBN.getFieldName(), bookView.getJISBNField().getText());
        values.put(EnumBookColumn.PUBLISHER.getFieldName(), bookView.getJPublisherField().getText());
        values.put(EnumBookColumn.SIMILAR_BOOKS.getFieldName(), bookView.getJSimilarBooksField().getText());

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

    public void onEditBook(BookDTO book) {
        this.editBook = book;
        setFieldsByBook(book);
    }

    private void setFieldsByBook(BookDTO bookDTO) {
        bookView.getJTitleField().setText(bookDTO.getTitle());
        bookView.getJAuthorsField().setText(bookDTO.getAuthors());
        bookView.getJPublishDateField().setText(DateUtil.formatDDMMYYYY(bookDTO.getPublishDate()));
        bookView.getJISBNField().setText(bookDTO.getIsbn() != null ? bookDTO.getIsbn().toString() : null);
        bookView.getJPublisherField().setText(bookDTO.getPublisher());
        bookView.getJSimilarBooksField().setText(bookDTO.getSimilarBooks());
    }

    private void save(Map<String, Object> values) {
        if (validate(values)) {
            try {
                BookDTO book = getBookFromValues(values);

                if (editBook != null) {
                    bookResource.updateBook(editBook.getId(), book);
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
        List<ValidationError> errors = getValidationErrors(values);

        if (!errors.isEmpty()) {
            JOptionPane.showMessageDialog(bookView, String.join("\n", errors.stream().map(ValidationError::getError).toList()));
            return false;
        }

        return true;
    }

}

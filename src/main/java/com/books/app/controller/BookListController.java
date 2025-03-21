package com.books.app.controller;

import com.books.app.constants.FormTitleConstants;
import com.books.app.model.BookListModel;
import com.books.app.view.BookListView;
import com.books.app.view.BookView;
import com.books.core.dto.BookDTO;
import com.books.core.factory.FactoryResource;
import com.books.core.resource.BookResource;
import com.books.utils.DateUtil;
import com.books.utils.NumericUtil;
import com.books.utils.enums.EnumDateFormat;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.util.ArrayList;
import java.util.List;

public class BookListController {

    private final BookListView bookListView;

    private final BookResource bookResource;

    private final List<BookDTO> bookList = new ArrayList<>();

    public BookListController(BookListView bookListView) {
        this.bookListView = bookListView;
        this.bookResource = (BookResource) FactoryResource.getInstance().get(BookResource.class);
        updateBookTableList();
    }

    private void updateBookTableList() {
        getBookList();
        BookListModel bookListModel = new BookListModel(bookList);
        bookListView.getJListTable().setModel(bookListModel);
    }

    private void getBookList() {
        bookList.clear();
        bookList.addAll(bookResource.list(
                BookDTO.builder()
                        .title(bookListView.getJTitleField().getText())
                        .authors(bookListView.getJAuthorsField().getText())
                        .publisher(bookListView.getJPublisherField().getText())
                        .publishDate(!bookListView.getJPublishDateField().getText().replaceAll("/", "").trim().isEmpty() ?
                                DateUtil.formatStringToDate(bookListView.getJPublishDateField().getText(), EnumDateFormat.DDMMYYYY) :
                                null)
                        .isbn(NumericUtil.parseLong(bookListView.getJISBNField().getText().replaceAll("-", "").trim()))
                        .similarBooks(bookListView.getJSimilarBooksField().getText())
                        .build()
        ));
    }

    public void delete() {
        BookDTO selectedBook = getSelectedBook();

        if (selectedBook == null) return;

        int dialogIndex = JOptionPane.showConfirmDialog(bookListView, "Deseja realmente excluir o livro: " + selectedBook.getId());

        if (dialogIndex == 0) {
            try {
                bookResource.deleteBook(selectedBook.getId());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(bookListView, "Ocorreu um erro ao excluir o livro: " + e.getMessage());
            }
        }

        updateBookTableList();
    }

    public void search() {
        updateBookTableList();
    }

    public void clean() {
        cleanFields();
        updateBookTableList();
    }

    public void edit() {
        BookDTO selectedBook = getSelectedBook();

        if (selectedBook == null) return;

        BookView bookView = new BookView(selectedBook);
        bookView.setTitle(String.format(FormTitleConstants.EDIT_FORM_TITLE, selectedBook.getId()));

        createBookView(bookView);
    }

    public void createNewBook() {
        BookView bookView = new BookView();
        bookView.setTitle(FormTitleConstants.CREATE_FORM_TITLE);

        createBookView(bookView);
    }

    private void createBookView(BookView bookView) {
        bookListView.add(bookView);
        bookListView.setComponentZOrder(bookView, 0);

        bookView.setVisible(true);

        bookView.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                updateBookTableList();
            }
        });
    }

    private void cleanFields() {
        bookListView.getJTitleField().setText("");
        bookListView.getJAuthorsField().setText("");
        bookListView.getJPublisherField().setText("");
        bookListView.getJPublishDateField().setText("");
        bookListView.getJISBNField().setText("");
        bookListView.getJSimilarBooksField().setText("");
    }

    private BookDTO getSelectedBook() {
        int row = bookListView.getJListTable().getSelectedRow();

        if (row >= 0) {
            return bookList.get(row);
        }

        return null;
    }

}

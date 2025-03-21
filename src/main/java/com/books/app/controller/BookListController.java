package com.books.app.controller;

import com.books.app.model.BookListModel;
import com.books.app.view.BookListView;
import com.books.core.dto.BookDTO;
import com.books.core.factory.FactoryResource;
import com.books.core.resource.BookResource;

import java.util.List;

public class BookListController {

    private final BookListView bookListView;

    private final BookResource bookResource;

    public BookListController(BookListView bookListView) {
        this.bookListView = bookListView;
        this.bookResource = (BookResource) FactoryResource.getInstance().get(BookResource.class);
        updateBookTableList();
    }

    private void updateBookTableList() {
        BookListModel bookListModel = new BookListModel(getBookList());
        bookListView.getJListTable().setModel(bookListModel);
    }

    private List<BookDTO> getBookList() {
        return bookResource.list(BookDTO.builder().build());
    }

}

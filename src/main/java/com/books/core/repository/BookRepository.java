package com.books.core.repository;

import com.books.core.domain.Book;

import java.util.List;

public interface BookRepository {

    Book save(Book book);

    Book findById(Integer id);

    List<Book> findAll(Book book);

    void remove(Integer id);

    int countByISBNAndIdIsNot(Long isbn, Integer id);

}

package com.books.core.repository;

import java.util.List;

import com.books.core.domain.Book;

public interface BookRepository {
	
	Book save(Book book);
	
	Book findById(Integer id);
	
	List<Book> findAll();
	
	void remove(Integer id);

}

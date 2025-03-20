package com.books.core.resource;

import java.util.List;

import com.books.core.dto.BookDTO;

public interface BookResource {
	
	BookDTO createBook(BookDTO book);
	
	BookDTO updateBook(Integer id, BookDTO book);
	
	void deleteBook(Integer id);
	
	List<BookDTO> list();
	
}

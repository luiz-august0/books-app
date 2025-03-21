package com.books.core.resource;

import java.util.List;

import com.books.core.domain.Book;
import com.books.core.dto.BookDTO;

public interface BookResource {
	
	void createBook(BookDTO book);
	
	void updateBook(Integer id, BookDTO book);
	
	void deleteBook(Integer id);
	
	List<BookDTO> list(BookDTO book);

	BookDTO searchByISBN(Long isbn);
	
}

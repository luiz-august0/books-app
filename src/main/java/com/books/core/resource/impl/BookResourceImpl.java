package com.books.core.resource.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.books.core.domain.Book;
import com.books.core.dto.BookDTO;
import com.books.core.factory.FactoryRepository;
import com.books.core.repository.BookRepository;
import com.books.core.resource.BookResource;

public class BookResourceImpl implements BookResource {
	
	private final BookRepository bookRepository;
	
	public BookResourceImpl() {
		this.bookRepository = (BookRepository) FactoryRepository.getInstance(BookRepository.class);
	}

	@Override
	public BookDTO createBook(BookDTO book) {
		return mapToDTO(bookRepository.save(mapToDomain(book))); 
	}

	@Override
	public BookDTO updateBook(Integer id, BookDTO book) {
		book.setId(id);
		
		return mapToDTO(bookRepository.save(mapToDomain(book))); 
	}

	@Override
	public void deleteBook(Integer id) {
		bookRepository.remove(id);		
	}

	@Override
	public List<BookDTO> list() {
		return bookRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	private BookDTO mapToDTO(Book book) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(book, BookDTO.class);
	}
	
	private Book mapToDomain(BookDTO book) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(book, Book.class);
	}

}

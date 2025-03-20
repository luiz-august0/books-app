package com.books.core.factory;

import java.util.HashMap;
import java.util.Map;

import com.books.core.repository.BookRepository;
import com.books.core.repository.impl.BookRepositoryImpl;

public class FactoryRepository extends Factory {
	
	static {
		implementations.put(BookRepository.class, BookRepositoryImpl.getInstance());
	}
	
}

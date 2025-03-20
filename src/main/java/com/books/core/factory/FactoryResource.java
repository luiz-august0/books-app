package com.books.core.factory;

import java.util.HashMap;
import java.util.Map;

import com.books.core.repository.impl.BookRepositoryImpl;
import com.books.core.resource.BookResource;
import com.books.core.resource.impl.BookResourceImpl;

public class FactoryResource extends Factory {
	
	static {
		implementations.put(BookResource.class, new BookResourceImpl());
	}
	
}

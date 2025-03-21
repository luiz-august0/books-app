package com.books.core.factory;

import com.books.core.repository.BookRepository;
import com.books.core.repository.impl.BookRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

public class FactoryRepository extends Factory {

    private static FactoryRepository instance;

    @Override
    public Map<Class<?>, Object> getImplementations() {
        Map<Class<?>, Object> implementations = new HashMap<>();
        implementations.put(BookRepository.class, BookRepositoryImpl.getInstance());

        return implementations;
    }

    public static synchronized FactoryRepository getInstance() {
        if (instance == null)
            instance = new FactoryRepository();

        return instance;
    }

}

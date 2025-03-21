package com.books.core.factory;

import com.books.core.resource.BookResource;
import com.books.core.resource.impl.BookResourceImpl;

import java.util.HashMap;
import java.util.Map;

public class FactoryResource extends Factory {

    private static FactoryResource instance;

    @Override
    public Map<Class<?>, Object> getImplementations() {
        Map<Class<?>, Object> implementations = new HashMap<>();
        implementations.put(BookResource.class, new BookResourceImpl());

        return implementations;
    }

    public static synchronized FactoryResource getInstance() {
        if (instance == null)
            instance = new FactoryResource();

        return instance;
    }

}

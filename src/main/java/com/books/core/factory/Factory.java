package com.books.core.factory;

import java.util.Map;

public abstract class Factory {

    public abstract Map<Class<?>, Object> getImplementations();

    public Object get(Class<?> clazz) {
        try {
            return getImplementations().get(clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

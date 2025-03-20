package com.books.core.factory;

import java.util.HashMap;
import java.util.Map;

public abstract class Factory {
	
	protected static final Map<Class<?>, Object> implementations = new HashMap<>();
	
	public static Object getInstance(Class<?> clazz) {
		try {
			return implementations.get(clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

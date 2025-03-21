package com.books.app.model.interfaces;

import com.books.core.dto.BookDTO;

@FunctionalInterface
public interface BookColumnValueGetter {

    Object getValue(BookDTO book);

}

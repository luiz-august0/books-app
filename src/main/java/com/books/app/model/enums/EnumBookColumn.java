package com.books.app.model.enums;

import com.books.app.model.interfaces.BookColumnValueGetter;
import com.books.core.dto.BookDTO;
import com.books.utils.DateUtil;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum EnumBookColumn {

    ID(0, "Cód.", "id", BookDTO::getId),
    TITLE(1, "Título", "title", BookDTO::getTitle),
    AUTHORS(2, "Autores", "authors", BookDTO::getAuthors),
    PUBLISH_DATE(3, "Data de publicação", "publishDate", (book ->
            book.getPublishDate() != null ? DateUtil.formatDDMMYYYY(book.getPublishDate()) : null)),
    ISBN(4, "ISBN", "isbn", BookDTO::getIsbn),
    PUBLISHER(5, "Editora", "publisher", BookDTO::getPublisher),
    SIMILAR_BOOKS(6, "Livros semelhantes", "similarBooks", BookDTO::getSimilarBooks);

    private final Integer column;

    private final String headerName;

    private final String fieldName;

    private final BookColumnValueGetter valueGetter;

    EnumBookColumn(Integer column, String headerName, String fieldName, BookColumnValueGetter valueGetter) {
        this.column = column;
        this.headerName = headerName;
        this.fieldName = fieldName;
        this.valueGetter = valueGetter;
    }

    public static EnumBookColumn getByColumn(Integer columnIndex) {
        return Arrays.stream(EnumBookColumn.values())
                .filter(enumBookColumn -> Objects.equals(enumBookColumn.getColumn(), columnIndex))
                .findFirst()
                .orElse(null);
    }

}

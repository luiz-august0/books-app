package com.books.app.model.enums;

import com.books.app.model.interfaces.BookColumnValueGetter;
import com.books.core.dto.BookDTO;
import com.books.utils.DateUtil;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum EnumBookColumn {

    ID(0, "Cód.", BookDTO::getId),
    TITLE(1, "Título", BookDTO::getTitle),
    PUBLISHER(2, "Editora", BookDTO::getPublisher),
    AUTHORS(3, "Autores", BookDTO::getAuthors),
    ISBN(4, "ISBN", BookDTO::getIsbn),
    PUBLISH_DATE(5, "Data de publicação", (book -> DateUtil.formatDDMMYYYY(book.getPublishDate()))),
    SIMILAR_BOOKS(6, "Livros semelhantes", BookDTO::getSimilarBooks);

    private final Integer column;

    private final String headerName;

    private final BookColumnValueGetter valueGetter;

    EnumBookColumn(Integer column, String headerName, BookColumnValueGetter valueGetter) {
        this.column = column;
        this.headerName = headerName;
        this.valueGetter = valueGetter;
    }

    public static EnumBookColumn getByColumn(Integer columnIndex) {
        return Arrays.stream(EnumBookColumn.values())
                .filter(enumBookColumn -> Objects.equals(enumBookColumn.getColumn(), columnIndex))
                .findFirst()
                .orElse(null);
    }

}

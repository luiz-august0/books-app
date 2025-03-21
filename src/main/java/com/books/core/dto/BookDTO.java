package com.books.core.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private Integer id;

    private String title;

    private String authors;

    private Date publishDate;

    private Long isbn;

    private String publisher;

    private String similarBooks;

}

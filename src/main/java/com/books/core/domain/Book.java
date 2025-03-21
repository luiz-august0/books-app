package com.books.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "authors", nullable = false)
    private String authors;

    @Column(name = "publish_date", nullable = false)
    private Date publishDate;

    @Column(name = "isbn")
    private Long isbn;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "similar_books")
    private String similarBooks;

}

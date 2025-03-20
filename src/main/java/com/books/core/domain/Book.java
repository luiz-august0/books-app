package com.books.core.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
	private Integer isbn;
	
	@Column(name = "publisher", nullable = false)
	private String publisher;
	
	@Column(name = "similar_books")
	private String similarBooks;
	
}

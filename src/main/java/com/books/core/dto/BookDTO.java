package com.books.core.dto;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookDTO {
	
	private Integer id;
	
	private String title;
	
	private String authors;
	
	private Date publishDate;
	
	private Integer isbn;
	
	private String publisher;
	
	private String similarBooks;
	
}

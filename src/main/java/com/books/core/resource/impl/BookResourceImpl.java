package com.books.core.resource.impl;

import com.books.core.domain.Book;
import com.books.core.dto.BookAuthorSearchDTO;
import com.books.core.dto.BookDTO;
import com.books.core.dto.BookISBNSearchDTO;
import com.books.core.factory.FactoryRepository;
import com.books.core.infrastructure.HttpTemplate;
import com.books.core.repository.BookRepository;
import com.books.core.resource.BookResource;
import com.books.utils.DateUtil;
import com.books.utils.enums.EnumDateFormat;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookResourceImpl implements BookResource {

    private final BookRepository bookRepository;
    private static final String OPEN_LIBRARY_URL = "https://openlibrary.org";
    private static final String ISBN_PATH = "/isbn";

    public BookResourceImpl() {
        this.bookRepository = (BookRepository) FactoryRepository.getInstance().get(BookRepository.class);
    }

    @Override
    public void createBook(BookDTO book) {
        validateISBN(book);

        bookRepository.save(mapToDomain(book));
    }

    @Override
    public void updateBook(Integer id, BookDTO book) {
        book.setId(id);
        validateISBN(book);

        bookRepository.save(mapToDomain(book));
    }

    @Override
    public void saveBookFromImport(BookDTO book) {
        if (book.getIsbn() != null) {
            Book bookByISBN = bookRepository.findByISBN(book.getIsbn());

            if (bookByISBN != null) {
                book.setId(bookByISBN.getId());
            }
        }

        if (book.getId() != null) {
            updateBook(book.getId(), book);
        } else {
            createBook(book);
        }
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.remove(id);
    }

    @Override
    public List<BookDTO> list(BookDTO book) {
        return bookRepository.findAll(mapToDomain(book))
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO searchByISBN(Long isbn) {
        List<String> authors = new ArrayList<>();

        BookISBNSearchDTO isbnSearchDTO = new HttpTemplate<>(BookISBNSearchDTO.class).get(
                OPEN_LIBRARY_URL + ISBN_PATH + "/" + isbn + ".json"
        );

        isbnSearchDTO.getAuthors().forEach(authorsMap -> {
            authors.addAll(authorsMap.values().stream()
                    .map(authorUrl -> {
                        return new HttpTemplate<>(BookAuthorSearchDTO.class)
                                .get(OPEN_LIBRARY_URL + "/" + authorUrl + ".json")
                                .getName();
                    })
                    .toList());
        });

        return BookDTO.builder()
                .title(isbnSearchDTO.getTitle())
                .isbn(isbn)
                .authors(String.join(",", authors))
                .publishDate(DateUtil.formatStringToDate(isbnSearchDTO.getPublishDate(), EnumDateFormat.EXTENSIVE))
                .publisher(String.join(",", isbnSearchDTO.getPublishers()))
                .build();
    }

    private BookDTO mapToDTO(Book book) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(book, BookDTO.class);
    }

    private Book mapToDomain(BookDTO book) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(book, Book.class);
    }

    private void validateISBN(BookDTO book) {
        if (book.getIsbn() != null) {
            int countByISBN = bookRepository.countByISBNAndIdIsNot(
                    book.getIsbn(), book.getId() != null ? book.getId() : -1
            );

            if (countByISBN > 0) {
                throw new RuntimeException("Já existe um livro com este código ISBN cadastrado");
            }
        }
    }

}

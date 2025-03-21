package com.books.core.repository.impl;

import com.books.core.domain.Book;
import com.books.core.repository.BookRepository;
import com.books.utils.NumericUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private static BookRepositoryImpl instance;
    private EntityManager entityManager;

    public static BookRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BookRepositoryImpl();
        }

        return instance;
    }

    private BookRepositoryImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernatePU");

        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    @Override
    public Book findById(Integer id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> findAll(Book book) {
        StringBuilder sql = new StringBuilder("" +
                " select b from Book b where 1 > 0"
        );

        if (book.getTitle() != null) {
            sql.append(" and function('lower', b.title) like '%").append(book.getTitle()).append("%' ");
        }

        if (book.getIsbn() != null) {
            sql.append(" and b.isbn = ").append(book.getIsbn());
        }

        if (book.getAuthors() != null) {
            sql.append(" and function('lower', b.authors) like '%").append(book.getAuthors()).append("%' ");
        }

        if (book.getPublisher() != null) {
            sql.append(" and function('lower', b.publisher) like '%").append(book.getPublisher()).append("%' ");
        }

        if (book.getSimilarBooks() != null) {
            sql.append(" and function('lower', b.similarBooks) like '%").append(book.getSimilarBooks()).append("%' ");
        }

        if (book.getPublishDate() != null) {
            sql.append(" and b.publishDate = :publishDate ");
        }

        Query query = entityManager.createQuery(sql.toString(), Book.class);

        if (book.getPublishDate() != null) {
            query.setParameter("publishDate", book.getPublishDate());
        }

        return query.getResultList();
    }

    @Override
    public Book save(Book book) {
        try {
            entityManager.getTransaction().begin();

            if (book.getId() != null) {
                entityManager.merge(book);
            } else {
                entityManager.persist(book);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

        return book;
    }

    @Override
    public void remove(Integer id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(findById(id));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countByISBNAndIdIsNot(Long isbn, Integer id) {
        Query query = entityManager.createQuery("" +
                " select count(b) from Book b" +
                "  where b.isbn = :isbn " +
                "    and b.id <> :id ", Integer.class);

        query.setParameter("isbn", isbn);
        query.setParameter("id", id);

        return NumericUtil.parseInt(query.getSingleResult());
    }

}

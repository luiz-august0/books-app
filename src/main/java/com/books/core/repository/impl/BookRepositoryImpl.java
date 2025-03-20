package com.books.core.repository.impl;

import java.util.List;

import com.books.core.domain.Book;
import com.books.core.repository.BookRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BookRepositoryImpl implements BookRepository {

	 private static BookRepositoryImpl instance;
     private EntityManager entityManager;
     
     public static BookRepositoryImpl getInstance(){
       if (instance == null){
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
     public List<Book> findAll() {
       return entityManager.createQuery("FROM " + Book.class.getName()).getResultList();
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

}

package org.acumen.training.codes.dao;

import java.util.List;

import org.acumen.training.codes.model.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

public class BookDao {
    private EntityManager em;

    public BookDao(String pu) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(pu);
        em = factory.createEntityManager();
    }
    //insert book
    @Transactional
    public boolean insert(Book book) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(book);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    
 // Select all books
    @Transactional
    public List<Book> selectAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }
    
    // Delete book by title
    @Transactional
    public boolean deleteByTitle(String title) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Book> query = cb.createQuery(Book.class);
            Root<Book> root = query.from(Book.class);
            query.select(root).where(cb.equal(root.get("title"), title));
            
            Book book = em.createQuery(query).getSingleResult();
            if (book != null) {
                em.remove(book);
            }
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    
    //update transaction by isbn
    @Transactional
    public boolean updateByIsbn(String isbn, Book updatedBook) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Book> query = cb.createQuery(Book.class);
            Root<Book> root = query.from(Book.class);
            query.select(root).where(cb.equal(root.get("isbn"), isbn));
            
            Book book = em.createQuery(query).getSingleResult();
            
            if (book != null) {
                
                if (updatedBook.getTitle() != null && !updatedBook.getTitle().isEmpty()) {
                    book.setTitle(updatedBook.getTitle());
                }
                if (updatedBook.getAuthor() != null && !updatedBook.getAuthor().isEmpty()) {
                    book.setAuthor(updatedBook.getAuthor());
                }
                if (updatedBook.getPrice() != null) {
                    book.setPrice(updatedBook.getPrice());
                }
                if (updatedBook.getQuantity() != null) {
                    book.setQuantity(updatedBook.getQuantity());
                }
                
                em.merge(book);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

}

package org.acumen.training.codes.test;

import org.acumen.training.codes.dao.BookDao;
import org.acumen.training.codes.model.Book;
import org.junit.jupiter.api.Test;

import java.util.List;



public class TestBookDao {
    @Test
    public void testInsert() {
        BookDao dao = new BookDao("bookstore_pu");
        Book book = new Book();
        
        book.setIsbn("999-8-77-666666-5");
        book.setTitle("Ang Panday");
        book.setAuthor("Coco Martin");
        book.setPrice(12.1);
        book.setQuantity(100);
        dao.insert(book);
        System.out.println("Inserted 1 record");
    }

    @Test
    public void testSelectAll() {
        BookDao dao = new BookDao("bookstore_pu");
        List<Book> books = dao.selectAll();
        System.out.println("Total books: " + books.size());
        
    }

    @Test
    public void testDeleteByTitle() {
        BookDao dao = new BookDao("bookstore_pu");
        boolean deleted = dao.deleteByTitle("Ang Panday");
        System.out.println("Delete status: " + deleted);
    }
}

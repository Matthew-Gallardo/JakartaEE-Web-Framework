package org.acumen.training.codes.handler;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.acumen.training.codes.dao.BookDao;
import org.acumen.training.codes.model.Book;

@WebServlet(name = "BookEntryHandler", urlPatterns = "/book/handler/save")
public class BookEntryHandler extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(BookEntryHandler.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String isbn = (String) request.getAttribute("isbn");
        String title = (String) request.getAttribute("title");
        String author = (String) request.getAttribute("author");
        double price = (Double) request.getAttribute("price");
        int qty = (Integer) request.getAttribute("qty");

        LOGGER.info("Creating book object with ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Price: " + price + ", Quantity: " + qty);
        
        
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        book.setQuantity(qty);

       
        BookDao bookDao = new BookDao("bookstore_pu");
        boolean success = bookDao.insert(book);

        if (success) {
            LOGGER.info("Book inserted successfully.");
            response.sendRedirect("/gallardoweb3/book/list_books.jsp");
        } else {
            LOGGER.warning("Failed to insert the book.");
            response.sendRedirect("/gallardoweb3/error/book/insertion_error.jsp");
        }
    }
}

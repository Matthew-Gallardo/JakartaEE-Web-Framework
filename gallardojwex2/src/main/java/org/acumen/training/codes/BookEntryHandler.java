package org.acumen.training.codes;

import org.acumen.training.codes.services.BookFileSaveService;
import org.acumen.training.codes.services.RetrieveBooksService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "BookEntryHandler", urlPatterns = "/book/handler/save")
public class BookEntryHandler extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private final BookFileSaveService bookFileSaveService = new BookFileSaveService();
    private final RetrieveBooksService retrieveBooksService = new RetrieveBooksService();
    private static final Logger LOGGER = Logger.getLogger(BookEntryHandler.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
      
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String qty = request.getParameter("qty");
        
        LOGGER.info("Received book entry with ISBN: %s, title: %s, Author: %s, Price: %s, Quantity: %s"
        		.formatted(isbn,title,author,price,qty));
       
        String record = String.join(",", isbn, title, author, price, qty);
        bookFileSaveService.appendToFile(record);
        LOGGER.info("Book record saved successfully: %s".formatted(record));
       
        List<String[]> bookList = retrieveBooksService.retrieveBooks();
        LOGGER.info("Number of books retrieved after saving: %s".formatted(bookList.size()));
       
        request.setAttribute("bookList", bookList);
        
        request.getRequestDispatcher("/WEB-INF/jsp/book/list_books.jsp").forward(request, response);
        LOGGER.info("Forwarded to list_books.jsp with updated book list.");
    }
}

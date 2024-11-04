package org.acumen.training.codes;

import org.acumen.training.codes.services.RetrieveBooksService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name ="BookListServlet", urlPatterns =  "/book/list_books.jsp") 
public class BookListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final RetrieveBooksService retrieveBooksService = new RetrieveBooksService();
    private static final Logger LOGGER = Logger.getLogger(BookListServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        LOGGER.info("Received request to retrieve book list.");
        
        List<String[]> bookList = retrieveBooksService.retrieveBooks();
        LOGGER.info("Number of books retrieved: %s".formatted(bookList != null ? bookList.size() : 0));

        request.setAttribute("bookList", bookList);
        
        LOGGER.info("Forwarding to list_books.jsp with book list.");
        request.getRequestDispatcher("/WEB-INF/jsp/book/list_books.jsp").forward(request, response);
    }
}

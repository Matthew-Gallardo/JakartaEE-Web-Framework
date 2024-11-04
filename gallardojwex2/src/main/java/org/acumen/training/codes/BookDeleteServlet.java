
package org.acumen.training.codes;

import org.acumen.training.codes.services.BookFileDeleteService;
import org.acumen.training.codes.services.RetrieveBooksService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "BookDeleteServlet", urlPatterns = "/book/delete_book")
public class BookDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RetrieveBooksService retrieveBooksService = new RetrieveBooksService();
    private final BookFileDeleteService bookFileDeleteService = new BookFileDeleteService();
    private static final Logger LOGGER = Logger.getLogger(BookDeleteServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	LOGGER.info("Received GET request for deleting a book");
        List<String[]> bookList = retrieveBooksService.retrieveBooks();
           
           if (bookList.isEmpty()) {
               LOGGER.warning("Book list is empty, no books to display for deletion.");
           } else {
               LOGGER.info("Fetched book list successfully with %d entries.".formatted(bookList.size()));
           }
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/WEB-INF/jsp/book/delete_book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titleToDelete = request.getParameter("title");
        LOGGER.info("Received POST request to delete book with title: %s".formatted(titleToDelete));
        // Using service to delete by title
        bookFileDeleteService.deleteBookByTitle(titleToDelete);

        // retrieving updated book list and forward to list_books.jsp
        List<String[]> bookList = retrieveBooksService.retrieveBooks();
        LOGGER.info("Fetched updated book list after deletion attempt.");
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/WEB-INF/jsp/book/list_books.jsp").forward(request, response);
    }
}

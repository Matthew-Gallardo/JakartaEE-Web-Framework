package org.acumen.training.codes;

import org.acumen.training.codes.dao.BookDao;
import org.acumen.training.codes.model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "BookUpdateServlet", urlPatterns = "/book/update_book")
public class BookUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(BookUpdateServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookDao bookDao = new BookDao("bookstore_pu");
        List<Book> bookList = bookDao.selectAll();
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/WEB-INF/jsp/book/update_book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Double price = request.getParameter("price").isEmpty() ? null : Double.parseDouble(request.getParameter("price"));
        Integer quantity = request.getParameter("quantity").isEmpty() ? null : Integer.parseInt(request.getParameter("quantity"));

        BookDao bookDao = new BookDao("bookstore_pu");
        Book updatedBook = new Book();
        updatedBook.setTitle(title);
        updatedBook.setAuthor(author);
        updatedBook.setPrice(price);
        updatedBook.setQuantity(quantity);

        LOGGER.info("Attempting to update book with ISBN: " + isbn);

        boolean success = bookDao.updateByIsbn(isbn, updatedBook);
        
        if (success) {
            LOGGER.info("Book update successful.");
        } else {
            LOGGER.warning("Book update failed.");
        }

        
        List<Book> bookList = bookDao.selectAll();
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/WEB-INF/jsp/book/list_books.jsp").forward(request, response);
    }
}

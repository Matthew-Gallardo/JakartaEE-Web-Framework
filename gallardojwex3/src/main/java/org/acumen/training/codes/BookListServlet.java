package org.acumen.training.codes;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.acumen.training.codes.dao.BookDao;
import org.acumen.training.codes.model.Book;

@WebServlet(name ="BookListServlet", urlPatterns = "/book/list_books.jsp") 
public class BookListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(BookListServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        BookDao bookDao = new BookDao("bookstore_pu");
        List<Book> bookList = bookDao.selectAll();

        request.setAttribute("bookList", bookList);

        LOGGER.info("Forwarding to list_books.jsp with book list.");
        request.getRequestDispatcher("/WEB-INF/jsp/book/list_books.jsp").forward(request, response);
    }
}

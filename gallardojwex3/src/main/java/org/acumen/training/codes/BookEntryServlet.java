package org.acumen.training.codes;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name ="BookEntryServlet", urlPatterns =  "/book/entry")
public class BookEntryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(BookEntryServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String priceStr = request.getParameter("price");
        String qtyStr = request.getParameter("qty");

 
        LOGGER.info("Received book entry with ISBN: %s, Title: %s, Author: %s, Price: %s, Quantity: %s"
        		.formatted(isbn,title,author,priceStr,qtyStr));

        
        if (!isNotEmpty(isbn) || !isNotEmpty(title) || !isNotEmpty(author) || 
                !isNotEmpty(priceStr) || !isNotEmpty(qtyStr)) {
            LOGGER.warning("Validation failed: One or more fields are empty.");
            response.sendRedirect("/gallardoweb3/error/book/empty_field_error.jsp");
            return;
        }
        if (!isValidISBN(isbn)) {
            LOGGER.warning("Validation failed: Invalid ISBN - %s".formatted(isbn));
            response.sendRedirect("/gallardoweb3/error/book/invalid_isbn.jsp");
            return;
        }
        if (!isValidPrice(priceStr)) {
            LOGGER.warning("Validation failed: Invalid price format - %s".formatted(priceStr));
            response.sendRedirect("/gallardoweb3/error/book/invalid_price.jsp");
            return;
        }
        if (!isValidQuantity(qtyStr)) {
            LOGGER.warning("Validation failed: Invalid quantity format - %s".formatted(qtyStr));
            response.sendRedirect("/gallardoweb3/error/book/invalid_quantity.jsp");
            return;
        }

        
        double price = Double.parseDouble(priceStr);
        int qty = Integer.parseInt(qtyStr);

        LOGGER.info("Validation successful: Price parsed as " + price + " and Quantity parsed as " + qty);
      

        
        request.setAttribute("isbn", isbn);
        request.setAttribute("title", title);
        request.setAttribute("author", author);
        request.setAttribute("price", price);
        request.setAttribute("qty", qty);
        LOGGER.info("Forwarding request to BookEntryHandler servlet.");
        request.getRequestDispatcher("/book/handler/save").forward(request, response);
    }

    private boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }

    private boolean isValidISBN(String isbn) {
        return isNotEmpty(isbn) && isbn.length() <= 20;
    }

    private boolean isValidPrice(String priceStr) {
        return priceStr != null && priceStr.matches("\\d+(\\.\\d{1,2})?");
    }

    private boolean isValidQuantity(String qtyStr) {
        return qtyStr != null && qtyStr.matches("\\d+");
    }
}

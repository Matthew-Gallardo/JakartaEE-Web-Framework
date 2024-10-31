package org.acumen.training.codes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

@WebServlet(name = "MenuController", urlPatterns = "/login")
public class MenuController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(MenuController.class.getName());
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Received GET request for /login");
        req.getRequestDispatcher("/page/login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LOGGER.log(Level.INFO, "Received POST request for login with username: {0}", username);

        String validation = validateCredentials(username, password);

        if (validation != null) {
            LOGGER.warning("Login validation failed: %s".formatted(validation));
            resp.sendRedirect("/gallardoweb1/page/error.html");
        } else {
            LOGGER.info("Login successful for username: %s".formatted(username));
            resp.setContentType("text/html");
            renderMenuForm(resp.getWriter());
        }
    }
    
    

    private String validateCredentials(String username, String password) {
        if (!Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$").matcher(username).matches()) {
            LOGGER.warning("Invalid email format for username: %s".formatted(username));
            return "Invalid Email Address!";
        }

        if (password.chars().anyMatch(Character::isDigit)) {
            LOGGER.warning("Password contains numbers for username: %s".formatted(username));
            return "Password cannot contain numbers!";
        }

        if (username.equals(password)) {
            LOGGER.warning("Username and Password are the same for username: %s".formatted(username));
            return "Username and Password cannot be the same!";
        }

        return null; 
    }



    private void renderMenuForm(PrintWriter out) {
        out.println("""
                <style>
                    body {
                        background-color: #e0f7fa; 
                        font-family: Arial, sans-serif;
                        color: #004d40; 
                        text-align: center;
                    }
                    h1 {
                        color: #00796b; 
                    }
                    form {
                        background-color: #ffffff; 
                        border: 1px solid #00796b; 
                        border-radius: 5px;
                        padding: 20px;
                        display: inline-block;
                        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                    }
                    input[type="text"], textarea {
                        padding: 10px;
                        margin: 10px 0;
                        border: 1px solid #00796b; 
                        border-radius: 3px;
                        width: 200px;
                    }
                    input[type="submit"] {
                        background-color: #00796b; 
                        color: white;
                        padding: 10px 15px;
                        border: none;
                        border-radius: 3px;
                        cursor: pointer;
                    }
                    input[type="submit"]:hover {
                        background-color: #004d40; 
                    }
                </style>
        		""");

        out.println("<h1>Menu Form</h1>");
        out.println("<form action='/gallardoweb1/addMenu' method='POST'>");
        out.println("Menu Name: <input type='text' name='menuName' required><br/>");
        out.println("File Name: <input type='text' name='fileName' required><br/>");
        out.println("Comment: <textarea name='comment' rows='4' cols='50'></textarea><br/>");
        out.println("Menu: <input type='text' name='menu' required><br/>");
        out.println("Order: <input type='text' name='order' required><br/>");
        out.println("<input type='submit' value='Add Menu'>");
        out.println("</form>");
        out.println("<br/><a href='/gallardoweb1/login'>Back to Login</a>");
        out.println("</body></html>");

        LOGGER.info("Menu form served successfully");
    }

}

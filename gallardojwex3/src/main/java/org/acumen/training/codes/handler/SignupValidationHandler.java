package org.acumen.training.codes.handler;

import java.io.IOException;
import java.util.logging.Logger;

import org.acumen.training.codes.dao.UserDao;
import org.acumen.training.codes.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "SignupValidationHandler", urlPatterns = "/book/signupValidation")
public class SignupValidationHandler extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(SignupValidationHandler.class.getName());
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		  
        String firstName = (String) req.getAttribute("first_name");
        String lastName = (String) req.getAttribute("last_name");
        String email = (String) req.getAttribute("email");
        String password = (String) req.getAttribute("password");
        String confirmPassword = (String) req.getAttribute("confirmPassword");

        
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            resp.sendRedirect("/gallardoweb3/error/book/empty_field_error.jsp");
            LOGGER.warning("Empty field error by the user");
            return;
        }

        // Validate email format (at least one special character and one number)
        String emailRegex = "^(?=.*[!@#$%^&*])(?=.*\\d).+@.+\\..+$";
        if (!email.matches(emailRegex)) {
            resp.sendRedirect("/gallardoweb3/error/book/invalid_email.jsp");
            LOGGER.warning("Invalid Email use 1 special character and 1 number");
            return;
        }

        // Confirm password matching
        if (!password.equals(confirmPassword)) {
        	resp.sendRedirect("/gallardoweb3/error/book/password_mismatch.jsp");
        	LOGGER.warning("The password is not matched");
            return;
        }

        try {
        	UserDao dao= new UserDao("bookstore_pu");
		    User user = new User();
		    user.setEmail(email);
		    user.setFirstName(firstName);
		    user.setLastName(lastName);
		    user.setPassword(password);
		    dao.insert(user);
		    resp.sendRedirect("/gallardoweb3/book/login_form");
		    LOGGER.warning("SignUp Succesful");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
		
}



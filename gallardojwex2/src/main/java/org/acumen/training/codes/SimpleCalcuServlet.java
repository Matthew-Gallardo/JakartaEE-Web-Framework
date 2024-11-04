package org.acumen.training.codes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.acumen.training.codes.services.CalculatorService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SimpleCalcuServlet", urlPatterns = "/calculator")
public class SimpleCalcuServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(SimpleCalcuServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.info("Forwarding to calculator form page.");
        request.getRequestDispatcher("/WEB-INF/jsp/calculator_form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operand1Str = request.getParameter("operand1");
        String operand2Str = request.getParameter("operand2");
        String operator = request.getParameter("operator");

        if (isEmpty(operand1Str) || isEmpty(operand2Str)) {
            LOGGER.warning("Empty operand detected.");
            response.sendRedirect("/gallardoweb2/error/empty_operand_error.jsp");
            return;
        }

        CalculatorService calculatorService = new CalculatorService();

        try {
            double operand1 = Double.parseDouble(operand1Str);
            double operand2 = Double.parseDouble(operand2Str);

            checkLimits(operand1, operand2);

            if (!validateDecimalPlaces(operand1Str) || !validateDecimalPlaces(operand2Str)) {
                LOGGER.warning("Decimal places exceeded for operands.");
                response.sendRedirect("/gallardoweb2/error/decimal_error.jsp");
                return;
            }

            calculatorService.setOperand1(operand1);
            calculatorService.setOperand2(operand2);
            calculatorService.setOperator(operator);

            calculatorService.calculate();
            LOGGER.info("Calculation successful.");

        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Invalid operand format: not a number.", e);
            response.sendRedirect("/gallardoweb2/error/operand_type_error.jsp");
            return;
        } catch (LimitExceededException e) {
            LOGGER.log(Level.WARNING, "Operand limits exceeded.", e);
            response.sendRedirect("/gallardoweb2/error/limit_error.jsp");
            return;
        } catch (ArithmeticException e) {
            LOGGER.log(Level.SEVERE, "Arithmetic error, possibly division by zero.", e);
            response.sendRedirect("/gallardoweb2/error/division_by_zero_error.jsp");
            return;
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, "Illegal argument encountered.", e);
            response.sendRedirect("/gallardoweb2/error/operand_type_error.jsp");
            return;
        }

        request.setAttribute("calculatorService", calculatorService);
        request.getRequestDispatcher("/WEB-INF/jsp/calculator_result.jsp").forward(request, response);
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private void checkLimits(double operand1, double operand2) throws LimitExceededException {
        if (operand1 < -1000000.0 || operand1 > 1000000.0 || operand2 < -1000000.0 || operand2 > 1000000.0) {
            throw new LimitExceededException("Operands must be between -1,000,000 and 1,000,000 inclusive.");
        }
    }

    private boolean validateDecimalPlaces(String operandStr) {
        return operandStr.matches("^-?\\d*\\.?\\d{0,3}$");
    }

    public class LimitExceededException extends Exception {
        private static final long serialVersionUID = 1L;

        public LimitExceededException(String message) {
            super(message);
        }
    }
}

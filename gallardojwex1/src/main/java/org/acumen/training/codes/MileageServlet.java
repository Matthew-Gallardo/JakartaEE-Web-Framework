package org.acumen.training.codes;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MileageServlet", urlPatterns = "/mileage")
public class MileageServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(MileageServlet.class.getName());
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Received POST request for mileage calculation");

        try {
            String name = request.getParameter("name");
            double pricePerGallon = Double.parseDouble(request.getParameter("pricePerGallon"));
            double totalAmountPaid = Double.parseDouble(request.getParameter("totalAmountPaid"));
            int initialOdometer = Integer.parseInt(request.getParameter("initialOdometer"));
            int finalOdometer = Integer.parseInt(request.getParameter("finalOdometer"));

            LOGGER.log(Level.INFO, "Calculating mileage for {0}", name);

            double[] mileageDetails = computeMileage(initialOdometer, finalOdometer, pricePerGallon, totalAmountPaid);

            request.setAttribute("name", name);
            request.setAttribute("milesDriven", (int) mileageDetails[0]);
            request.setAttribute("gallonsUsed", mileageDetails[1]);
            request.setAttribute("milesPerGallon", mileageDetails[2]);

            LOGGER.info("Mileage calculation successful, forwarding to result page");
            request.getRequestDispatcher("/WEB-INF/jsp/mileageResult.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Error parsing numeric parameters: ", e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input for numeric fields.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Received GET request for mileage form");
        request.getRequestDispatcher("/WEB-INF/jsp/mileageForm.jsp").forward(request, response);
    }

    
    private double[] computeMileage(int initialOdometer, int finalOdometer, double pricePerGallon, double totalAmountPaid) {
        int milesDriven = finalOdometer - initialOdometer;
        double gallonsUsed = totalAmountPaid / pricePerGallon;
        double milesPerGallon = milesDriven / gallonsUsed;

        return new double[]{milesDriven, gallonsUsed, milesPerGallon};
    }
}

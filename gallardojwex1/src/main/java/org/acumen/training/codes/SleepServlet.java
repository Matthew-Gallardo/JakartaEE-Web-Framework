package org.acumen.training.codes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SleepServlet", urlPatterns = "/sleep")
public class SleepServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(SleepServlet.class.getName());
    private static final long serialVersionUID = 1L;
    private static final int SLEEP_PER_NIGHT_HOURS = 8;
    private static final String DATE_FORMAT = "MMMM d, yyyy";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Received GET request for sleep calculation form");
        req.getRequestDispatcher("/WEB-INF/jsp/sleepForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String birthdateInput = req.getParameter("birthdate");
        String todayInput = req.getParameter("today");
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);

        LOGGER.log(Level.INFO, "Received POST request for sleep calculation with birthdate: {0} and today: {1}", 
                   new Object[]{birthdateInput, todayInput});

        try {
            Date birthDate = dateFormat.parse(birthdateInput);
            Date todayDate = dateFormat.parse(todayInput);
            
            long[] sleepDetails = computeSleepDetails(birthDate, todayDate);
            req.setAttribute("totalDaysAlive", sleepDetails[0]);
            req.setAttribute("totalSleepHours", sleepDetails[1]);
         

            LOGGER.info("Sleep calculation successful, forwarding to result page ");
            req.getRequestDispatcher("/WEB-INF/jsp/sleepResult.jsp").forward(req, resp);
        } catch (ParseException e) {
            LOGGER.log(Level.WARNING, "Date parsing failed for inputs birthdate: " + birthdateInput + " and today: " + todayInput, e);
            req.setAttribute("error", "Invalid date format. Please use 'MONTH DAY, YEAR format (October 30, 2024)'.");
            req.getRequestDispatcher("/WEB-INF/jsp/sleepForm.jsp").forward(req, resp);
        }

    }

    private long[] computeSleepDetails(Date birthDate, Date todayDate) {
        long totalMillisecondsAlive = todayDate.getTime() - birthDate.getTime();
        long totalDaysAlive = TimeUnit.DAYS.convert(totalMillisecondsAlive, TimeUnit.MILLISECONDS);
        long totalSleepHours = totalDaysAlive * SLEEP_PER_NIGHT_HOURS;
        return new long[]{totalDaysAlive, totalSleepHours};
    }
}

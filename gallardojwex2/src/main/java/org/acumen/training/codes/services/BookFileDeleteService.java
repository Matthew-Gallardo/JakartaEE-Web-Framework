package org.acumen.training.codes.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BookFileDeleteService {

    private static final String FILE_PATH = "C:\\Users\\222152\\Desktop\\Training\\Demo\\7Track\\gallardojwex2\\src\\main\\resources\\bookdb.txt";
    private static final Logger LOGGER = Logger.getLogger(BookFileDeleteService.class.getName());

    public void deleteBookByTitle(String titleToDelete) throws IOException {
        LOGGER.info("Starting deletion process for book title: " + titleToDelete);
        List<String> updatedLines;

        // Reading file and filtering out the specified title
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            updatedLines = reader.lines()
                .filter(line -> !line.split(",")[1].equals(titleToDelete))
                .collect(Collectors.toList());
            LOGGER.info("Finished reading file. Books remaining after filter: " + updatedLines.size());
        } catch (IOException e) {
            LOGGER.severe("Error reading file for deletion process: " + e.getMessage());
            throw e;
        }

        // Writing back the filtered list to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : updatedLines) {
                writer.write(line);
                writer.newLine();
            }
            LOGGER.info("Deletion completed. Updated book list written to file.");
        } catch (IOException e) {
            LOGGER.severe("Error writing to file after deletion: " + e.getMessage());
            throw e;
        }
    }
}

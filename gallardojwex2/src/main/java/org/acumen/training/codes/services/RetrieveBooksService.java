package org.acumen.training.codes.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RetrieveBooksService {
    
    private static final String FILE_NAME = "C:\\Users\\222152\\Desktop\\Training\\Demo\\7Track\\gallardojwex2\\src\\main\\resources\\bookdb.txt";
    private static final Logger LOGGER = Logger.getLogger(RetrieveBooksService.class.getName());

    public List<String[]> retrieveBooks() {
        List<String[]> bookList = new ArrayList<>();
        LOGGER.info("Starting to retrieve books from file: " + FILE_NAME);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                bookList.add(parts);
            }
            LOGGER.info("Successfully retrieved " + bookList.size() + " books from file.");
        } catch (IOException e) {
            LOGGER.severe("Error reading the book database: " + e.getMessage());
        }
        
        return bookList;
    }
}

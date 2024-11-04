package org.acumen.training.codes.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class BookFileSaveService {
    private static final Logger LOGGER = Logger.getLogger(BookFileSaveService.class.getName());

    public void appendToFile(String data) throws IOException {
        String filePath = "C:\\Users\\222152\\Desktop\\Training\\Demo\\7Track\\gallardojwex2\\src\\main\\resources\\bookdb.txt";
        LOGGER.info("Starting to append data to file: " + filePath);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data);
            writer.newLine();
            LOGGER.info("Data successfully appended to file: " + data);
        } catch (IOException e) {
            LOGGER.severe("Failed to append data to file. Error: " + e.getMessage());
            throw e;
        }
    }
}

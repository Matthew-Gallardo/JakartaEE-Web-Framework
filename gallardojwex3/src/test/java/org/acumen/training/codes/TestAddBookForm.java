// TestAddBookForm.java

package org.acumen.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class TestAddBookForm {

    private WebTester tester;

    @BeforeEach
    public void setup() {
        tester = new WebTester();
        tester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
        tester.setBaseUrl("http://localhost:8080/gallardoweb3");
        tester.beginAt("/book/add_book");
    }

    @AfterEach
    public void teardown() {
        tester = null;
    }

    @Test
    public void testAddPageLoad() {
        tester.assertTitleEquals("Insert Book Record");
        tester.assertFormPresent();
    }

    @Test
    public void testAddBookWithValidData() {
       
        tester.setTextField("isbn", "978-3-16-148410-2");
        tester.setTextField("title", "Effective Java");
        tester.setTextField("author", "Joshua Bloch");
        tester.setTextField("price", "45.50");
        tester.setTextField("qty", "10");

        tester.submit();

        tester.assertTitleEquals("List of Books");
    }

    @Test
    public void testAddBookWithMissingFields() {
        
        tester.setTextField("isbn", "978-3-16-148410-0");
        tester.setTextField("price", "45.50");
        tester.setTextField("qty", "10");

        tester.submit();
        
        tester.assertTextPresent("Error: Empty Fields\r\n"
        		+ "Please fill in all required fields.\r\n"
        		+ "Go Back");
       
    }

    @Test
    public void testAddBookWithInvalidISBN() {
    	
    	tester.setTextField("isbn", "978-3-16-148410-0-11111111");
    	tester.setTextField("title", "New Book");
    	tester.setTextField("author", "John Doe");
    	tester.setTextField("price", "1.0");
    	tester.setTextField("qty", "1");
    	
    	tester.submit();
    	
    	tester.assertTextPresent("Error: Invalid ISBN\r\n"
    			+ "The ISBN should be a non-empty value with a maximum of 20 characters.\r\n"
    			+ "Go Back");
    	
    }
    @Test
    public void testAddBookWithInvalidPrice() {
        
        tester.setTextField("isbn", "978-3-16-148410-0");
        tester.setTextField("title", "New Book");
        tester.setTextField("author", "John Doe");
        tester.setTextField("price", "abc");
        tester.setTextField("qty", "1");

        tester.submit();

        tester.assertTextPresent("Error: Invalid Price\r\n"
        		+ "The price must be a valid double value at most 2 decimal places (e.g., 10.99).\r\n"
        		+ "Go Back");
       
    }
    @Test
    public void testAddBookWithInvalidQty() {
    	
    	tester.setTextField("isbn", "978-3-16-148410-0");
    	tester.setTextField("title", "New Book");
    	tester.setTextField("author", "John Doe");
    	tester.setTextField("price", "1.1");
    	tester.setTextField("qty", "abc");
    	
    	tester.submit();
    	
    	tester.assertTextPresent("Error: Invalid Quantity\r\n"
    			+ "The quantity must be a valid integer.\r\n"
    			+ "Go Back");
    	
    }
}

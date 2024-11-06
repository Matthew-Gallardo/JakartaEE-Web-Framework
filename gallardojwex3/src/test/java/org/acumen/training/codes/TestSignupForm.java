package org.acumen.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class TestSignupForm {

    private WebTester tester;

    @BeforeEach
    public void setup() {
        tester = new WebTester();
        tester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
        tester.setBaseUrl("http://localhost:8080/gallardoweb3");
        tester.beginAt("/book/signup");
    }

    @AfterEach
    public void teardown() {
        tester = null;
    }

    @Test
    public void testPageFormHead() {
        tester.assertTitleEquals("Sign Up Form");
    }

    @Test
    public void testSignupPageForm() {
        tester.assertFormPresent("signupForm");
        tester.assertCheckboxPresent("terms");
        tester.assertButtonPresent("signup-btn");
    }

    @Test
    public void testEmptyFormSubmission() {
        tester.submit();
        tester.assertTextPresent("Error: Empty Fields\r\n"
        		+ "Please fill in all required fields.\r\n"
        		+ "Go Back"); 
    }

    @Test
    public void testInvalidEmailFormat() {
        tester.setTextField("first_name", "John");
        tester.setTextField("last_name", "Doe");
        tester.setTextField("email", "invalid-email");
        tester.setTextField("password", "password123");
        tester.setTextField("confirmPassword", "password123");
        tester.checkCheckbox("terms");

        tester.submit();
        tester.assertTextPresent("Error: Invalid Email\r\n"
        		+ "The username should be a valid email address with one special character and one number\r\n"
        		+ "Go Back"); 
    }

    @Test
    public void testPasswordMismatch() {
        tester.setTextField("first_name", "John");
        tester.setTextField("last_name", "Doe");
        tester.setTextField("email", "john.doe@example.com");
        tester.setTextField("password", "password123");
        tester.setTextField("confirmPassword", "password124");
        tester.checkCheckbox("terms");

        tester.submit();
        tester.assertTextPresent("Error: Invalid Email\r\n"
        		+ "The username should be a valid email address with one special character and one number\r\n"
        		+ "Go Back"); 
    }

    @Test
    public void testSuccessfulSignup() {
        tester.setTextField("first_name", "John");
        tester.setTextField("last_name", "Doe");
        tester.setTextField("email", "john.doe@example.com");
        tester.setTextField("password", "password123");
        tester.setTextField("confirmPassword", "password123");
        tester.checkCheckbox("terms");

        tester.submit();
        tester.assertTitleEquals("Login Form");
        
    }

}

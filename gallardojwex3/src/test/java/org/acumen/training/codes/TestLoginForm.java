package org.acumen.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class TestLoginForm {

    private WebTester tester;

    @BeforeEach
    public void setup() {
        tester = new WebTester();
        tester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
        tester.setBaseUrl("http://localhost:8080/gallardoweb3");
        tester.beginAt("/book/login");
    }

    @AfterEach
    public void teardown() {
        tester = null;
    }

    @Test
    public void testLoginFormPage() {
        tester.assertTitleEquals("Login Form");
        tester.assertFormPresent();
        tester.assertButtonPresent("login-btn");
    }

   
    @Test
    public void testInvalidCredentials() {
        tester.setTextField("email", "john.doe@example.com");
        tester.setTextField("password", "wrongPassword");
        tester.submit();
        tester.assertTextPresent("Wrong Password\r\n"
        					 + "Please Try Again\r\n"
        					 	+ "Go Back");
    }

    @Test
    public void testSuccessfulLogin() {
        // this data is in the database
        tester.setTextField("email", "kaisotto8@gmail.com");
        tester.setTextField("password", "iloveph");
        tester.submit();
        tester.assertTitleEquals("Bookstore Management System"); 
    }
}

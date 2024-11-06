package org.acumen.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class TestUpdateForm {

    private WebTester tester;

    @BeforeEach
    public void setup() {
        tester = new WebTester();
        tester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
        tester.setBaseUrl("http://localhost:8080/gallardoweb3");
        tester.beginAt("/book/update_book");
    }

    @AfterEach
    public void teardown() {
        tester = null;
    }

    @Test
    public void testPageLoad() {
        tester.assertTitleEquals("Update Book");
        tester.assertFormPresent();
    }


    @Test
    public void testBackToMainMenuLink() {
        tester.assertLinkPresentWithText("Back to Main Menu");
        tester.clickLink("back");
        tester.assertTitleEquals("Bookstore Management System");
    }
}
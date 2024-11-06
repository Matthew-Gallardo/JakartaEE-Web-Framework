// TestDeleteBookForm.java

package org.acumen.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class TestDeleteBookForm {

    private WebTester tester;

    @BeforeEach
    public void setup() {
        tester = new WebTester();
        tester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
        tester.setBaseUrl("http://localhost:8080/gallardoweb3");
        tester.beginAt("/book/delete_book");
    }

    @AfterEach
    public void teardown() {
        tester = null;
    }

    @Test
    public void testDeletePageLoad() {
        tester.assertTitleEquals("Delete Book Record");
        tester.assertFormPresent();
        tester.assertSelectOptionPresent("title", "Where the Crawdads Sing"); 
    }

    @Test
    public void testDeleteBookSubmission() {
        tester.selectOption("title", "Where the Crawdads Sing");
        tester.submit();
    }

}

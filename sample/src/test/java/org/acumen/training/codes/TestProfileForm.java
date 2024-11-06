package org.acumen.training.codes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

public class TestProfileForm {
	private WebTester tester;
	
	@BeforeEach
	public void setup() {
		tester= new WebTester();
		tester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
		tester.setBaseUrl("http://localhost:8080/gallardoweb1");
	}
	@AfterEach
	public void teardown() {
		tester=null;
	}
	
	@Test
	public void testPageFormHead() {
		tester.beginAt("/jsp/profile_form.html");
		tester.assertTitleEquals("Profile Form Page");
	}
	
	@Test
	public void testProfileFormPageForm() {

		tester.beginAt("/jsp/profile_form.html");
		tester.assertFormPresent("form1");
		tester.setIgnoreFailingStatusCodes(true);
		
		tester.setTextField("id", "101");
        tester.setTextField("firstname", "Juan");
        tester.setTextField("lastname", "Luna");
        tester.setTextField("salary", "50000.00");       
        tester.submit("form1sub");
		tester.assertTitleEquals("Profile Result");
	}
	
	@Test
	public void testLinkProfile() {
		tester.beginAt("/jsp/profile_form.html");
		tester.assertLinkPresent("hyper1");
		tester.setIgnoreFailingStatusCodes(true);
		tester.clickLink("hyper1");
		tester.assertTitleEquals("Insert title here");
		
	}
}

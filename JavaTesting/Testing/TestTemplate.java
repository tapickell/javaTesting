import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestTemplate {
	
	private Template template;

	@Before
	public void setUp() throws Exception {
		template = new Template("${one}, ${two}, ${three}");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testsMultipleVariables() throws Exception {
		assertTemplateEvaluatesTo("1, 2, 3");
	}
	

	@Test
	public void testsUnkownVariablesAreIgnaored() throws Exception {
		template.set("doesnotexist", "Hi");
		assertTemplateEvaluatesTo("1, 2, 3");
	}
	
	@Test
	public void testsMissingValueRaisesException() throws Exception {
		try {
			new Template("${foo}").evaluate();
			fail ("evaluate() should throw an exception if a variable was left without value!");
		} catch (MissingValueException expected) {
			assertEquals("No value for ${foo}", expected.getMessage());
		}
	}
	
	private void assertTemplateEvaluatesTo(String expected) {
		assertEquals(expected, template.evaluate());
	} 
}








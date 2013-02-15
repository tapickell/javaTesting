import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author toddpickell
 *
 */
public class TestVariableSegment {
	
	private Map<String, String> variables;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		variables = new HashMap<String, String>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testsVariableEvaluatesToItsValue() throws Exception {
		String name = "myvar";
		String value = "myvalue";
		variables.put(name,  value);
		assertEquals(value, new Variable(name).evaluate(variables));
	}

	@Test
	public void testsMissingVariableRaisesException() throws Exception {
		String name = "myvar";
		try {
			new Variable(name).evaluate(variables);
			fail("Missing variable value should raise an exception");
		} catch (MissingValueException expected) {
			assertEquals("No value for ${" + name + "}", expected.getMessage());
		}
	}
}

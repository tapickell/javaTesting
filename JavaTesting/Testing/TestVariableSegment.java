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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testsVariableEvaluatesToItsValue() throws Exception {
		Map<String, String> variables = new HashMap<String, String>();
		String name = "myvar";
		String value = "myvalue";
		variables.put(name,  value);
		assertEquals(value, new Variable(name).evaluate(variables));
	}

}

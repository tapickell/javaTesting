import static org.junit.Assert.*;

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
public class TestAddSomeNumbers {

	private AddSomeNumbers adder;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		adder = new AddSomeNumbers();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testsAddingTwoSmallPositiveNumbers() throws Exception {
		Integer actual = adder.add(2, 3);
		Integer expected = 5;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testsAddingOneNegativeAndOnePositiveNumber() throws Exception {
		Integer actual = adder.add(-2, 3);
		Integer expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testsAddingThreePositiveNumbers() throws Exception {
		Integer actual = adder.add(2, 3, 4);
		Integer expected = 9;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testsAddingFourPositiveNumbers() throws Exception {
		Integer actual = adder.add(2, 3, 4, 5);
		Integer expected = 14;
		assertEquals(expected, actual);
	}

}

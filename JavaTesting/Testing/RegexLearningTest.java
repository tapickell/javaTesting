import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class RegexLearningTest {

	private Matcher matcher;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String haystack = "The needle shop sells needles";
		String regex = "(needle)";
		matcher = Pattern.compile(regex).matcher(haystack);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testsHowGroupCountWorks() throws Exception {
		
		assertEquals(1, matcher.groupCount());
	}

	@Test
	public void testsFindStartAndEnd() throws Exception {
		
		assertTrue(matcher.find());
		assertEquals("Wrong start index of 1st match", 4, matcher.start());
		assertEquals("Wrong end index of 1st match", 10, matcher.end());
		
		assertTrue(matcher.find());
		assertEquals("Wrong start index of 2nd match", 22, matcher.start());
		assertEquals("Wrong end index of 2nd match", 28, matcher.end());
		
		assertFalse("Should not have any more matches", matcher.find());
	}
	
}

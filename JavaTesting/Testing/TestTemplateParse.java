import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

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
public class TestTemplateParse {
	
	private TemplateParse parse;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parse = new TemplateParse();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testsEmptyTemplateRendersAsEmptyString() throws Exception {
		List<String> segments = parse("");
		assertSegments(segments, "");
	}

	@Test
	public void testsTemplateWithOnlyPlainText() throws Exception {
		List<String> segments = parse("plain text only");
		assertSegments(segments, "plain text only");
	}
	
	@Test
	public void testsParsingMultipleValues() throws Exception {
		List<String> segments = parse("${a}:${b}:${c}");
		assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
	}


	@Test
	public void testsParsingTemplateIntoSegmentObjects() throws Exception {
		List<Segment> segments = parse.parseSegments("a ${b} c ${d}");
		assertSegments(segments, new PlainText("a "), new Variable("b"),
								new PlainText(" c "), new Variable("d"));
	}
	
	
	private void assertSegments(List<? extends Object> actual, Object... expected) {
		assertEquals("Number of segments", expected.length, actual.size());
		assertEquals(Arrays.asList(expected), actual);
	}
	
	private List<String> parse(String template) {
		return new TemplateParse().parse(template);
	}
	
}

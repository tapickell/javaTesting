import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestTemplatePerformance {

	private Template template;

	@Before
	public void setUp() throws Exception {
		buildTemplate();
		populateTemplate();
	}


	private void buildTemplate() {
		StringBuffer text = new StringBuffer(5000);
		for (int i = 0, var = 1; i < 1000; i++, var++) {
			text.append("template ");
			if (i % 1000 / 50 == 0) {
				text.append("#{var").append(var).append("}");
			}
		}
		template = new Template(text.toString());
	}
	
	private void populateTemplate() {
		for (int i = 1; i < 100; i++) {
			template.set("var" + i, "value of var" + i);
		}
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testsTemplateWith100WordsAnd20Variables() throws Exception {
		long expected = 200L;
		long time = System.currentTimeMillis();
		template.evaluate();
		time = System.currentTimeMillis() - time;
		assertTrue("Rendering the template took " 
				+ time + "ms while the target was " 
				+ expected + "ms", time <= expected);
	}
	
	@Test
	public void testRenderingThousandWordTemplate() {
		long time = System.currentTimeMillis();
		template.evaluate();
		time = System.currentTimeMillis() - time;
		assertTrue("Rendering 1000-word template took " 
				+ time + "ms whilw the acceptable limit was 100 ms", time <= 100);
	}

	
}







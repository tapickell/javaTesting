import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author toddpickell
 *
 */
public class Template {

	private String templateText;
	private HashMap<String, String> variables;
	
	public Template(String templateText) {
		this.variables = new HashMap<String, String>();
		this.templateText = templateText;
	}
	
	public void set(String name, String value) {
		this.variables.put(name, value);
	}
	
	public String evaluate() {
		TemplateParse parser = new TemplateParse();
		List<String> segments = parser.parse(templateText);
		return concactenate(segments);
	}

	private String concactenate(List<String> segments) {
		StringBuilder result = new StringBuilder();
		for (String segment : segments) {
			append(segment, result);
		}
		return result.toString();
	}

	private void append(String segment, StringBuilder result) {
		if (isVariable(segment)) {
			evaluateVariable(segment, result);
		} else {
			result.append(segment);
		}
		
	}

	private void evaluateVariable(String segment, StringBuilder result) {
		String var = segment.substring(2,  segment.length() -1);
		if (!variables.containsKey(var)) {
			throw new MissingValueException("No value for " + segment);
		}
		result.append(variables.get(var));
	}

	private boolean isVariable(String segment) {
		return segment.startsWith("${") && segment.endsWith("}");
	}

}






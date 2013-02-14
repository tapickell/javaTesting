import java.util.HashMap;
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
		String result = replaceVariables();
		checkForMissingValues(result);
		return result;
	}

	private String replaceVariables() {
		String result = templateText;
		for (Entry<String, String> entry : variables.entrySet()) {
			String regex = "\\$\\{" + entry.getKey() + "\\}";
			result = result.replaceAll(regex, entry.getValue());
		}
		return result;
	}

	private void checkForMissingValues(String result) {
		Matcher m = Pattern.compile("\\$\\{.+\\}").matcher(result);
		if (m.find()) {
			throw new MissingValueException("No value for " + m.group());
		}
	}
}






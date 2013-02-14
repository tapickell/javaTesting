import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author toddpickell
 *
 */
public class TemplateParse {

	public List<String> parse(String template) {
		List<String> segments = new ArrayList<String>();
		int index = collectionSegments(segments, template);
		addTail(segments, template, index);
		addEmptyStringIfTemplateWasEmpty(segments);
		return segments;
	}

	
	private int collectionSegments(List<String> segments, String template) {
		Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
		Matcher matcher = pattern.matcher(template);
		int index = 0;
		while (matcher.find()) {
			addPrecedingPlainText(segments, template, matcher, index);
			addVariable(segments, template, matcher);
			index = matcher.end();
		}
		return index;
	}
	
	private void addTail(List<String> segments, String template, int index) {
		if (index < template.length()) {
			segments.add(template.substring(index));
		}
		
	}
	
	private void addVariable(List<String> segments, String template,
			Matcher matcher) {
		segments.add(template.substring(matcher.start(), matcher.end()));
		
	}

	private void addPrecedingPlainText(List<String> segments, String template,
			Matcher matcher, int index) {
		if (index != matcher.start()) {
			segments.add(template.substring(index, matcher.start()));
		}
		
	}
	
	private void addEmptyStringIfTemplateWasEmpty(List<String> segments) {
		if (segments.isEmpty()) {
			segments.add("");
		}
		
	}

}

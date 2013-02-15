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


	public List<Segment> parseSegments(String template) {
		List<Segment> segments = new ArrayList<Segment>();
		List<String> strings = parse(template);
		for (String s : strings) {
			if (Template.isVariable(s)) {
				String name = s.substring(2, s.length() - 1);
				segments.add(new Variable(name));
			} else {
				segments.add(new PlainText(s));
			}
		}
		return segments;
	}

}

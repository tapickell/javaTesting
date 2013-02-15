/**
 * 
 */

/**
 * @author toddpickell
 *
 */
public class AddSomeNumbers {


	public Integer add(Integer... numbers) {
		Integer result = 0;
		for (Integer integer : numbers) {
			result += integer;
		}
		return result;
	}
}

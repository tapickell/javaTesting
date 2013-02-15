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
public class TestEmpoyee {

	private Employee employee;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		employee = new Employee();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test 
	public void testsCreatingEmployeeWithNameAndIDAndJobTitle() throws Exception {
		Employee otherEmployee = new Employee("Bob", 12345, "Programmer");
		assertEquals("Bob", otherEmployee.getName());
		assertTrue(otherEmployee.getID() == 12345);
		assertEquals("Programmer", otherEmployee.getJob());
	}

	@Test
	public void testsSettingJobTitle() {
		employee.setJob("Programmer");
		assertEquals("Programmer", employee.getJob());
	}

}

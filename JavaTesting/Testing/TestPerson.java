import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestPerson {

	private Person person;

	@Before
	public void setUp() throws Exception {
		person = new Person();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testsCreatingPersonWithNameAndNumber() throws Exception {
		Person newPerson = new Person("Bob", 12345);
		assertEquals("Bob", newPerson.getName());
		assertTrue(newPerson.getID() == 12345);
	}

	@Test
	public void testsSettingPersonsName() throws Exception {
		person.setName("Bob");
		assertEquals("Bob", person.getName());
	}
	
	@Test
	public void testsSettingPersonsID() throws Exception {
		person.setID(12345);
		assertTrue(person.getID() == 12345);
	}

}

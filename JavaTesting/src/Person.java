
public class Person {

	public String name;
	public Integer ID;
	
	public Person() {
		
	}
	
	public Person(String name, Integer id) {
		this.name = name;
		ID = id;
	}

	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}


public class Employee extends Person {
	
	private String job;

	
	public Employee() {
		super();
	}
	
	public Employee(String name, Integer id, String job) {
		super(name, id);
		this.job = job;
	}
	
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

}

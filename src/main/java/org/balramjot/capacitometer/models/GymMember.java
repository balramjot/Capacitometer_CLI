package main.java.org.balramjot.capacitometer.models;


/**
 * Base class - GymMember that includes class variables
 * for creating a gym member
 * @author saini
 *
 */
public class GymMember {

	private int id;
	private String firstName;
	private String lastName;
	private int status;
	
	public GymMember() { 
	}
	
	public GymMember(int id, String firstName, String lastName, int status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStringValueOfId() {
		return String.valueOf(id);
	}
}

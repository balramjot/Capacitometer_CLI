package main.java.org.balramjot.capacitometer.models;

import java.io.Serializable;

/**
 * Class containing member variables to handle
 * maximum gym capacity
 * @author saini
 *
 */
public class MaxGymCapacity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int capacity;
	
	public MaxGymCapacity() {
	}
	
	public MaxGymCapacity(int id, int capacity) {
		super();
		this.id = id;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}

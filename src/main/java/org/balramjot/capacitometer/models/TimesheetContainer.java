package main.java.org.balramjot.capacitometer.models;

/**
 * generic class - extends all the classes that has
 * Timesheet as parent class or Timesheet class
 * @author saini
 * @param <T>
 */
public class TimesheetContainer<T extends Timesheet> {
	private T timesheet;
	
	public TimesheetContainer(T timesheet) {
		this.timesheet = timesheet;
	}
	
	public T getTimesheet() {
		return timesheet;
	}
}

package main.java.org.balramjot.capacitometer.models;

/**
 * abstract class to use same method in other classes
 * @author saini
 *
 */
public abstract class DisplayFactory {
	/**
	 * using varargs to print output
	 * @param s
	 */
	public abstract void output(String... s);
	
	public void printBlankLine() {
		System.out.println();
	}
}

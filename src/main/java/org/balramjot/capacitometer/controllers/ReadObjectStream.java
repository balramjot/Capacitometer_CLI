package main.java.org.balramjot.capacitometer.controllers;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Class to read .dat file using streams
 * @author saini
 *
 */
public class ReadObjectStream {
	
	/**
	 * This method reads the input file using object and
	 * returns as class object
	 * @param <T> generic class
	 * @param path file path
	 * @return generic class variable
	 */
	@SuppressWarnings("unchecked")
	public static <T> T readInputDatFile(String path) {
		Object value = null;
		try {
			@SuppressWarnings("resource")
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
			value = input.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) value;
	}
}

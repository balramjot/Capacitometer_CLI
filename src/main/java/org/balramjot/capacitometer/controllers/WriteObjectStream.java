package main.java.org.balramjot.capacitometer.controllers;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * This class writes data to .dat file
 * @author saini
 *
 */
public class WriteObjectStream {
	
	/**
	 * Method writes the class object
	 * to output file
	 * @param <T>
	 * @param path file path
	 * @param object generic class
	 */
	public static <T> void writeOutputDatFile(String path, T object) {
		try {
			@SuppressWarnings("resource")
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path));
			output.writeObject(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

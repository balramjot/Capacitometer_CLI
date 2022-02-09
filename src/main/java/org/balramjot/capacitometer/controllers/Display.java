package main.java.org.balramjot.capacitometer.controllers;

import main.java.org.balramjot.capacitometer.models.DisplayFactory;

/**
 * Class to display general output
 * such as printing list
 * @author saini
 *
 */
public class Display extends DisplayFactory {

	@Override
	public void output(String... s) {
		if(s.length > 0 || s != null || s.equals("")) {
			for(String ss: s) {
				System.out.print(ss);
			}
		}
	}
}

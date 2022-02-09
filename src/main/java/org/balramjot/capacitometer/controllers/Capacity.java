package main.java.org.balramjot.capacitometer.controllers;

import java.util.HashMap;

import main.java.org.balramjot.capacitometer.models.Timesheet;

/**
 * Functional Interface to calculate real-time capacity
 * @author saini
 *
 */
public interface Capacity {
	
	/**
	 * This method calculate capacity of the gym
	 * @param maxCapacity, maximum capacity of the gym
	 * @param timeMap, member list tracking
	 * @return, calculated capacity in decimals
	 */
	public double computeCapacity(int maxCapacity, HashMap<Integer, Timesheet> timeMap);
}

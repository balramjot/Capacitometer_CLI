package main.java.org.balramjot.capacitometer.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;

import main.java.org.balramjot.capacitometer.models.DisplayFactory;
import main.java.org.balramjot.capacitometer.models.Timesheet;

/**
 * This class calculates the real-time
 * gym capacity
 * @author saini
 *
 */
public class CalculateCapacity extends DisplayFactory{

	// class member variable
	private int count = 0;
	
	/**
	 * Functional interface to calculate gym capacity
	 */
	Capacity getGymCapacity = (maxCapacity, timeMap) -> {
			if(timeMap != null) {
			
			timeMap.forEach((k,v) -> {
					if(v.getStatus() == 1) {
						count += 1;
					}
			});
			
			double capacityPercentage = (count * 100)/maxCapacity;
			return capacityPercentage;
		}
		return 0;
	};
	
	/**
	 * This method uses functional interface to compute gym capacity
	 * @param maxCapacity
	 * @param timeMap
	 * @return
	 */
	public double processGymCapacity (int maxCapacity, HashMap<Integer, Timesheet> timeMap) {
		return getGymCapacity.computeCapacity(maxCapacity, timeMap);
	}
	/**
	 * This method calculates the gym capacity
	 * based upon maximum gym capacity and
	 * number of members whose status is 1 or
	 * currently in checked-in state
	 */
//	@Override
//	public double computeCapacity(int maxCapacity, HashMap<Integer, Timesheet> timeMap) {
//		if(timeMap != null) {
//			
//			timeMap.forEach((k,v) -> {
//					if(v.getStatus() == 1) {
//						count += 1;
//					}
//			});
//			
//			double capacityPercentage = (count * 100)/maxCapacity;
//			return capacityPercentage;
//		}
//		return 0;
//	}

	@Override
	public void output(String... s) {
		// TODO Auto-generated method stub
		
	}
	
	// method overloading
	public void output(LocalDateTime timeNow, double calculatedCapacity) {
		System.out.println("Current gym capacity as of " + timeNow + " is " + calculatedCapacity + "%");
	}
}

package main.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import main.java.org.balramjot.capacitometer.controllers.CalculateCapacity;
import main.java.org.balramjot.capacitometer.controllers.CheckIn;
import main.java.org.balramjot.capacitometer.controllers.CheckOut;
import main.java.org.balramjot.capacitometer.models.Timesheet;

class CalculateCapacityTest {
	
	@Test
	public void testComputeCapacity() {
		int maxCapacity = 100;
		HashMap<Integer, Timesheet> map = new HashMap<>();
		LocalDateTime timeNow = LocalDateTime.now();
		
		CheckIn checkIn = new CheckIn();
		checkIn.setId(1);
		checkIn.setMemberId(111);
		checkIn.setStatus(1);
		checkIn.setPunchTime(timeNow);
		
		CheckIn checkIn1 = new CheckIn();
		checkIn1.setId(2);
		checkIn1.setMemberId(112);
		checkIn1.setStatus(1);
		checkIn1.setPunchTime(timeNow);
		
		CheckOut checkOut = new CheckOut();
		checkOut.setId(3);
		checkOut.setMemberId(112);
		checkOut.setStatus(2);
		checkOut.setPunchTime(timeNow);
		
		map.put(1, checkIn);
		map.put(2, checkIn1);
		map.put(3, checkOut);
		
		CalculateCapacity capacity = new CalculateCapacity();
		double result = capacity.processGymCapacity(maxCapacity, map);
		assertEquals(2.0, result);
	}

}

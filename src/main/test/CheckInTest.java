package main.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import main.java.org.balramjot.capacitometer.controllers.CheckIn;
import main.java.org.balramjot.capacitometer.models.TimesheetContainer;

class CheckInTest {

	@Test
	public void testCheckIn() {
		LocalDateTime t = LocalDateTime.now();
		TimesheetContainer<CheckIn> checkin = new TimesheetContainer<CheckIn>(new CheckIn());
    	checkin.getTimesheet().setId(1);
    	checkin.getTimesheet().setMemberId(111);
    	checkin.getTimesheet().setStatus(1);
    	checkin.getTimesheet().setPunchTime(t);
    	
		assertEquals(checkin.getTimesheet().getCheckInTime(), t);
	}

}

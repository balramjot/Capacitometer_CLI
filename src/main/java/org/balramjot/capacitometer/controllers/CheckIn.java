package main.java.org.balramjot.capacitometer.controllers;

import java.time.LocalDateTime;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.org.balramjot.capacitometer.models.Timesheet;
import main.java.org.balramjot.capacitometer.models.TimesheetContainer;

/**
 * This class sets the check-in time
 * for gym member
 * @author saini
 *
 */
public class CheckIn extends Timesheet {

	public CheckIn() {
		super();
	}
	@Override
	public void setPunchTime(LocalDateTime t) {
		setCheckInTime(t);
	}

	@Override
	public void output(String...s) {
		// TODO Auto-generated method stub
	}
	
	// method overloading
	public void output(String firstName, LocalDateTime checkedInTime) {
		System.out.println(firstName + " successfully checked in on " + checkedInTime);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void convertClassToJsonObject(TimesheetContainer<?> t) {

		JSONObject checkInJson = new JSONObject();
		checkInJson.put("id", t.getTimesheet().getId());
		checkInJson.put("memberid", t.getTimesheet().getMemberId());
		checkInJson.put("status", t.getTimesheet().getStatus());
		checkInJson.put("checkInTime", t.getTimesheet().getCheckInTime());
		checkInJson.put("checkOutTime", t.getTimesheet().getCheckOutTime());
		
		JSONObject checkInObject = new JSONObject();
		checkInObject.put("Timesheet", checkInJson);
		
		JSONArray checkInArray = new JSONArray();
		checkInArray.add(checkInObject);
		
		WriteJsonFile.writeOutputJsonFile(checkInArray, "src/main/resources/ioFiles/Timesheet.json");

	}
}

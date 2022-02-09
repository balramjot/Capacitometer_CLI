package main.java.org.balramjot.capacitometer.controllers;

import java.time.LocalDateTime;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.org.balramjot.capacitometer.models.Timesheet;
import main.java.org.balramjot.capacitometer.models.TimesheetContainer;

/**
 * This class sets the check-out
 * time for gym members
 * @author saini
 *
 */
public class CheckOut extends Timesheet {
	
	public CheckOut() {
		super();
	}
	
	@Override
	public void setPunchTime(LocalDateTime t) {
		setCheckOutTime(t);
	}

	@Override
	public void output(String...s) {
		// TODO Auto-generated method stub
	}
	
	// method overloading
	public void output(String firstName, LocalDateTime checkedOutTime) {
		System.out.println(firstName + " successfully checked out on " + checkedOutTime);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void convertClassToJsonObject(TimesheetContainer<?>  t) {
		JSONObject checkOutJson = new JSONObject();
		checkOutJson.put("id", t.getTimesheet().getId());
		checkOutJson.put("memberid", t.getTimesheet().getMemberId());
		checkOutJson.put("status", t.getTimesheet().getStatus());
		checkOutJson.put("checkInTime", t.getTimesheet().getCheckInTime());
		checkOutJson.put("checkOutTime", t.getTimesheet().getCheckOutTime());
		
		JSONObject checkOutObject = new JSONObject();
		checkOutObject.put("Timesheet", checkOutJson);
		
		JSONArray checkOutArray = new JSONArray();
		checkOutArray.add(checkOutObject);
		
		WriteJsonFile.writeOutputJsonFile(checkOutArray, "src/main/resources/ioFiles/Timesheet.json");
		
	}
}

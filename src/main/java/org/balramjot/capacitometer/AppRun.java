package main.java.org.balramjot.capacitometer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;

import main.java.org.balramjot.capacitometer.controllers.CalculateCapacity;
import main.java.org.balramjot.capacitometer.controllers.CheckIn;
import main.java.org.balramjot.capacitometer.controllers.CheckOut;
import main.java.org.balramjot.capacitometer.controllers.Display;
import main.java.org.balramjot.capacitometer.controllers.GetGymMemberList;
import main.java.org.balramjot.capacitometer.controllers.ReadJsonFile;
import main.java.org.balramjot.capacitometer.controllers.ReadObjectStream;
import main.java.org.balramjot.capacitometer.controllers.WriteObjectStream;
import main.java.org.balramjot.capacitometer.excecptions.CustomException;
import main.java.org.balramjot.capacitometer.models.GymMember;
import main.java.org.balramjot.capacitometer.models.MaxGymCapacity;
import main.java.org.balramjot.capacitometer.models.Timesheet;
import main.java.org.balramjot.capacitometer.models.TimesheetContainer;

public class AppRun {
	
	private static HashMap<Integer, GymMember> gymMemberMap = new HashMap<>();
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Display display = new Display();
		
		MaxGymCapacity maxGymCapacity = new MaxGymCapacity(1, 100);
		WriteObjectStream.writeOutputDatFile("src/main/resources/ioFiles/gymCapacity.dat", maxGymCapacity);
		MaxGymCapacity getGymMaxCapacity = ReadObjectStream.readInputDatFile("src/main/resources/ioFiles/gymCapacity.dat");
		int maxCapacity = getGymMaxCapacity.getCapacity();
		display.output("Maximum gym capacity is: ", String.valueOf(maxCapacity));
		display.printBlankLine();
		
		ReadJsonFile readJsonFile = new ReadJsonFile();
		
		JSONArray gymJsonArray = readJsonFile.readInputJsonFile("src/main/resources/ioFiles/gymMember.json");
		GetGymMemberList getGymMemberList = new GetGymMemberList();
		gymMemberMap = getGymMemberList.parseJsonObjectMap(gymJsonArray);
				
		getGymMemberList.displayGymMembersList(gymMemberMap, display);
		
/*		
		JSONArray gymMaxcapacityJsonArray = readJsonFile.readInputJsonFile("src/main/resources/ioFiles/gymCapacity.json");
		GetMaxGymCapacity getMaxGymCapacity = new GetMaxGymCapacity();
		MaxGymCapacity maxGymCapacity = getMaxGymCapacity.parseJsonObject(gymMaxcapacityJsonArray);
*/		
		
		Scanner scanner = new Scanner(System.in);
		int userInput;
		HashMap<Integer, Timesheet> timeMap = new HashMap<>();
		while (true) {
			display.output("Enter your Input (Gym Member Id): ");
			userInput = scanner.nextInt();
            
            GymMember searchedMember = gymMemberMap.get(userInput);
            display.output("Welcome!!! ", searchedMember.getStringValueOfId(), " ", searchedMember.getFirstName(), " ", searchedMember.getLastName());
            display.printBlankLine();
            display.output("What is your purpose of visit? Press the corresponding number from following:");
            display.printBlankLine();
            display.output("1. I am checking in to the gym.");
            display.printBlankLine();
            display.output("2. I am checking out from the gym.");
            display.printBlankLine();
            display.output("3. Want to know gym capacity?");
            display.printBlankLine();
            display.output("4. Exit.");
            display.printBlankLine();
            int taskInput = scanner.nextInt();
            switch(taskInput) {
	            case 1:
	            	// setting up the checkIn values, status is 1 for check-in
	            	TimesheetContainer<CheckIn> checkin = new TimesheetContainer<CheckIn>(new CheckIn());
	            	checkin.getTimesheet().setId(userInput);
	            	checkin.getTimesheet().setMemberId(userInput);
	            	checkin.getTimesheet().setStatus(1);
	            	checkin.getTimesheet().setGymMemberMapping(searchedMember);
	            	
	            	LocalDateTime checkInTime = LocalDateTime.now(); 
	            	checkin.getTimesheet().setPunchTime(checkInTime);
	            	checkin.getTimesheet().convertClassToJsonObject(checkin);	// type bounded
	            	
	            	// adding checked-in gym member to hashmap
	            	timeMap.put(userInput, checkin.getTimesheet());
	            	
	            	// displaying the output
	            	checkin.getTimesheet().output(checkin.getTimesheet().getGymMemberMapping().getFirstName(), checkin.getTimesheet().getCheckInTime());
	            	
	            	// calculating the capacity realtime
	            	CalculateCapacity calculateCapacityCheckIn = new CalculateCapacity();
	            	double runTimeGymCapacityCheckIn = calculateCapacityCheckIn.processGymCapacity(maxCapacity, timeMap);
	            	display.printBlankLine();
	            	calculateCapacityCheckIn.output(checkInTime, runTimeGymCapacityCheckIn);
	            	break;
	            case 2:
	            	// validation to make sure only checked-in user will be able to checked-out
	            	if(timeMap.get(userInput) != null) {
	            		Timesheet currentgymMember = timeMap.get(userInput);
	            		
	            		if(currentgymMember.getStatus() != 2) {
	            			TimesheetContainer<CheckOut> checkout = new TimesheetContainer<CheckOut>(new CheckOut());
			            	checkout.getTimesheet().setId(userInput);
			            	checkout.getTimesheet().setMemberId(userInput);
			            	checkout.getTimesheet().setStatus(2);
			            	checkout.getTimesheet().setGymMemberMapping(searchedMember);
			            	
			            	LocalDateTime checkOutTime = LocalDateTime.now(); 
			            	checkout.getTimesheet().setPunchTime(checkOutTime);
			            	
			            	checkout.getTimesheet().convertClassToJsonObject(checkout);
			            	
		            		timeMap.put(userInput, checkout.getTimesheet());
		            		
		            		checkout.getTimesheet().output(checkout.getTimesheet().getGymMemberMapping().getFirstName(), checkout.getTimesheet().getCheckOutTime());
			            	
			            	CalculateCapacity calculateCapacityCheckOut = new CalculateCapacity();
			            	double runTimeGymCapacityCheckOut = calculateCapacityCheckOut.processGymCapacity(maxCapacity, timeMap);
			            	display.printBlankLine();
			            	calculateCapacityCheckOut.output(checkOutTime, runTimeGymCapacityCheckOut);
			            	break;
	            		} throw new CustomException("User must be checked in first!!!");
	            	} throw new CustomException("User must be checked in first!!!");
	            	
	            case 3:
	            	CalculateCapacity calculateCapacityNow = new CalculateCapacity();
	            	LocalDateTime timeNow = LocalDateTime.now();  
	            	double runTimeGymCapacityCheckOut = calculateCapacityNow.processGymCapacity(maxCapacity, timeMap);
	            	display.printBlankLine();
	            	calculateCapacityNow.output(timeNow, runTimeGymCapacityCheckOut);
	            	break;
	            default:
	            	display.output("Good Bye !!!");
	            	scanner.close();
	            	System.exit(1);
            }
		}	
	}
}

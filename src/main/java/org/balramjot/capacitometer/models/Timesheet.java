package main.java.org.balramjot.capacitometer.models;

import java.time.LocalDateTime;

/**
 * Base class to set timesheet values
 * which means to track gym members check-in and
 * check-out times
 * @author saini
 *
 */
public abstract class Timesheet extends DisplayFactory{
	private int id;
	private int memberId;
	private LocalDateTime checkInTime;
	private LocalDateTime checkOutTime;
	private int status;
	private GymMember gymMemberMapping;
	public abstract void setPunchTime(LocalDateTime t);
	public abstract void convertClassToJsonObject(TimesheetContainer<?> t);
	
	public Timesheet() {
	}

	public Timesheet(int id, int memberId, LocalDateTime checkInTime, LocalDateTime checkOutTime, int status) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public void output(String... s) {
		// TODO Auto-generated method stub
	}
	
	public GymMember getGymMemberMapping() {
		return gymMemberMapping;
	}

	public void setGymMemberMapping(GymMember gymMemberMapping) {
		this.gymMemberMapping = gymMemberMapping;
	}
}

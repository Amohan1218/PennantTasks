package com.model;

public class Appointments {
	int apptId;
	String apptDate;
	int apptDocId;
	int apptPatnId;
	String apptSlotFrom;
	String apptSlotTo;
	public Appointments() {
		super();
	}
	public Appointments(int apptId, String apptDate, int apptDocId, int apptPatnId, String apptSlotFrom,
			String apptSlotTo) {
		super();
		this.apptId = apptId;
		this.apptDate = apptDate;
		this.apptDocId = apptDocId;
		this.apptPatnId = apptPatnId;
		this.apptSlotFrom = apptSlotFrom;
		this.apptSlotTo = apptSlotTo;
	}
	@Override
	public String toString() {
		return "Appointments [apptId=" + apptId + ", apptDate=" + apptDate + ", apptDocId=" + apptDocId
				+ ", apptPatnId=" + apptPatnId + ", apptSlotFrom=" + apptSlotFrom + ", apptSlotTo=" + apptSlotTo + "]";
	}
	public int getApptId() {
		return apptId;
	}
	public void setApptId(int apptId) {
		this.apptId = apptId;
	}
	public String getApptDate() {
		return apptDate;
	}
	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
	}
	public int getApptDocId() {
		return apptDocId;
	}
	public void setApptDocId(int apptDocId) {
		this.apptDocId = apptDocId;
	}
	public int getApptPatnId() {
		return apptPatnId;
	}
	public void setApptPatnId(int apptPatnId) {
		this.apptPatnId = apptPatnId;
	}
	public String getApptSlotFrom() {
		return apptSlotFrom;
	}
	public void setApptSlotFrom(String apptSlotFrom) {
		this.apptSlotFrom = apptSlotFrom;
	}
	public String getApptSlotTo() {
		return apptSlotTo;
	}
	public void setApptSlotTo(String apptSlotTo) {
		this.apptSlotTo = apptSlotTo;
	}
}

package com.model;

public class SlotAvlDates {
	String date;

	public SlotAvlDates(String date) {
		super();
		this.date = date;
	}

	public SlotAvlDates() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SlotAvlDates [date=" + date + "]";
	}
	
}

package com.model;

import java.time.LocalDate;

public class SlotAvl {
	int slot_id; 
	int slot_doc_id; 
	LocalDate slot_date;
	String slot_from;
	String slot_to;
	String slot_status;
	public SlotAvl(int slot_id, int slot_doc_id, LocalDate slot_date, String slot_from, String slot_to,
			String slot_status) {
		super();
		this.slot_id = slot_id;
		this.slot_doc_id = slot_doc_id;
		this.slot_date = slot_date;
		this.slot_from = slot_from;
		this.slot_to = slot_to;
		this.slot_status = slot_status;
	}
	@Override
	public String toString() {
		return "SlotAvailability [slot_id=" + slot_id + ", slot_doc_id=" + slot_doc_id + ", slot_date=" + slot_date
				+ ", slot_from=" + slot_from + ", slot_to=" + slot_to + ", slot_status=" + slot_status + "]";
	}
	public int getSlot_id() {
		return slot_id;
	}
	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}
	public int getSlot_doc_id() {
		return slot_doc_id;
	}
	public void setSlot_doc_id(int slot_doc_id) {
		this.slot_doc_id = slot_doc_id;
	}
	public LocalDate getSlot_date() {
		return slot_date;
	}
	public void setSlot_date(LocalDate slot_date) {
		this.slot_date = slot_date;
	}
	public String getSlot_from() {
		return slot_from;
	}
	public void setSlot_from(String slot_from) {
		this.slot_from = slot_from;
	}
	public String getSlot_to() {
		return slot_to;
	}
	public void setSlot_to(String slot_to) {
		this.slot_to = slot_to;
	}
	public String getSlot_status() {
		return slot_status;
	}
	public void setSlot_status(String slot_status) {
		this.slot_status = slot_status;
	}
	public SlotAvl() {
		super();
	}
}

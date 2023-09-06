package com.model;

public class SlotDetails {
	String slotFrom;
	String slotTo;
	public SlotDetails(String slotFrom, String slotTo) {
		super();
		this.slotFrom = slotFrom;
		this.slotTo = slotTo;
	}
	public SlotDetails() {
		super();
	}
	public String getSlotFrom() {
		return slotFrom;
	}
	public void setSlotFrom(String slotFrom) {
		this.slotFrom = slotFrom;
	}
	public String getSlotTo() {
		return slotTo;
	}
	public void setSlotTo(String slotTo) {
		this.slotTo = slotTo;
	}
	@Override
	public String toString() {
		return "SlotDetails [slotFrom=" + slotFrom + ", slotTo=" + slotTo + "]";
	}
}

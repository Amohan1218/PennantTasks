package com.model;

public class DocSchd {
	int docId;
	String wklySchd, mrngSlot, evngSlot;
	int slotDuration, range;
	
	DocSchd(){}
	
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getWklySchd() {
		return wklySchd;
	}
	public void setWklySchd(String wklySchd) {
		this.wklySchd = wklySchd;
	}
	public String getMrngSlot() {
		return mrngSlot;
	}
	public void setMrngSlot(String mrngSlot) {
		this.mrngSlot = mrngSlot;
	}
	public String getEvngSlot() {
		return evngSlot;
	}
	public void setEvngSlot(String evngSlot) {
		this.evngSlot = evngSlot;
	}
	public int getSlotDuration() {
		return slotDuration;
	}
	public void setSlotDuration(int slotDuration) {
		this.slotDuration = slotDuration;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public DocSchd(int docId, String wklySchd, String mrngSlot, String evngSlot, int slotDuration, int range) {
		super();
		this.docId = docId;
		this.wklySchd = wklySchd;
		this.mrngSlot = mrngSlot;
		this.evngSlot = evngSlot;
		this.slotDuration = slotDuration;
		this.range = range;
	}
	@Override
	public String toString() {
		return "DocSchd [docId=" + docId + ", wklySchd=" + wklySchd + ", mrngSlot=" + mrngSlot + ", evngSlot="
				+ evngSlot + ", slotDuration=" + slotDuration + ", range=" + range + "]";
	}
	
}

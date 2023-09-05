package com.model;

public class DocSchd {
	int docId, slotIndex;
	String wklySchd, slotFrom, slotTo;
	int slotDuration, range;
	
	DocSchd(){}

	@Override
	public String toString() {
		return "DocSchd [docId=" + docId + ", slotIndex=" + slotIndex + ", wklySchd=" + wklySchd + ", slotFrom="
				+ slotFrom + ", slotTo=" + slotTo + ", slotDuration=" + slotDuration + ", range=" + range + "]";
	}

	public DocSchd(int docId, int slotIndex, String wklySchd, String slotFrom, String slotTo, int slotDuration,
			int range) {
		super();
		this.docId = docId;
		this.slotIndex = slotIndex;
		this.wklySchd = wklySchd;
		this.slotFrom = slotFrom;
		this.slotTo = slotTo;
		this.slotDuration = slotDuration;
		this.range = range;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getSlotIndex() {
		return slotIndex;
	}

	public void setSlotIndex(int slotIndex) {
		this.slotIndex = slotIndex;
	}

	public String getWklySchd() {
		return wklySchd;
	}

	public void setWklySchd(String wklySchd) {
		this.wklySchd = wklySchd;
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
}

package com.dao;

import java.util.List;

import com.model.DocSchd;
import com.model.Doctors;
import com.model.SlotAvl;
import com.model.SlotAvlDates;

public interface HospitalDAO {
	List<Doctors> getAllDoctors();
	
	DocSchd getDoctor(int i);
	
	List<SlotAvlDates> getAvailableDates(int doc_id);
	
	List<SlotAvl> getAllAvailableSlots(int doc_id, String dt);
}

package com.dao;

import java.util.List;

import com.model.Doctors;
import com.model.SlotAvlDates;

public interface HospitalDAO {
	List<Doctors> getAllDoctors();
	
	List<SlotAvlDates> getAvailableDates(int doc_id);
}

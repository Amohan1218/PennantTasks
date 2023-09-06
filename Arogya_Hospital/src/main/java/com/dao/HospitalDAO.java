package com.dao;

import java.util.List;

import com.model.Appointments;
import com.model.DocSchd;
import com.model.Doctors;
import com.model.PatientId;
import com.model.Patients;
import com.model.SlotAvl;
import com.model.SlotAvlDates;
import com.model.SlotDetails;

public interface HospitalDAO {
	List<Doctors> getAllDoctors();
	
	DocSchd getDoctor(int i);
	
	List<SlotAvlDates> getAvailableDates(int doc_id);
	
	List<SlotAvl> getAllAvailableSlots(int doc_id, String dt);
	
	boolean createPatient(Patients p);
	
	SlotDetails getSlotDetails(int i);

	boolean createAppointment(String dt, String docId, int pid, String from, String to);

	PatientId getPatientDetails(String firstName, String lastName);

	Appointments getAppointmentDetails(String date, int doctId, String slotFrom, String slotTo);
}

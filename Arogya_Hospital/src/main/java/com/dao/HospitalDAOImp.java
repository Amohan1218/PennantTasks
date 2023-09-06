package com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Appointments;
import com.model.AppointmentsMapper;
import com.model.DocSchd;
import com.model.DocSchdMapper;
import com.model.DoctorMapper;
import com.model.Doctors;
import com.model.PatientId;
import com.model.PatientIdMapper;
import com.model.Patients;
import com.model.SlotAvl;
import com.model.SlotAvlDates;
import com.model.SlotAvlDatesMapper;
import com.model.SlotAvlMapper;
import com.model.SlotDetails;
import com.model.SlotDetailsMapper;

public class HospitalDAOImp implements HospitalDAO{
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	public HospitalDAOImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_GET_DOCTORS = "select * from ms_doctors";
	private final String SQL_GET_SLOT = "select * from ms_appointment_slot_calendar where slot_id = ?";
	private final String SQL_GET_PATIENT_DETAILS = "select * from ms_patients where patn_firstname = ? and patn_lastname = ?";
	private final String SQL_GET_DOCTOR_INFO = "select * from ms_doctor_schedule where doct_id = ? and doct_sindex = 1";
	private final String SQL_GET_ALL_AVL_SLOT_DATES = "select slot_date from ms_appointment_slot_calendar where slot_status = 'Available' and slot_doc_id = ? group by slot_date";
	private final String SQL_GET_ALL_AVL_SLOTS = "SELECT * FROM ms_appointment_slot_calendar WHERE slot_doc_id = ? and slot_date = ? and slot_status = 'Available'";
	private final String SQL_CREATE_PATIENT = "INSERT INTO ms_patients (patn_firstname, patn_lastname, patn_age, patn_gender, patn_mobile, patn_email) values(?, ?, ?, ?, ?, ?)";
	private final String SQL_CREATE_APPOINTMENT = "INSERT INTO ms_appointments (apbk_date, apbk_doct_id, apbk_patn_id, apbk_slot_from, apbk_slot_to) values(?, ?, ?, ?, ?)";
	private final String SQL_GET_APPT_DETAILS = "select * from ms_appointments where apbk_date = ? and apbk_doct_id = ? and apbk_slot_from = ? and apbk_slot_to = ?";
	
	
	@Override
	public List<Doctors> getAllDoctors() {
		return jdbcTemplate.query(SQL_GET_DOCTORS, new DoctorMapper());
	}

	@Override
	public List<SlotAvlDates> getAvailableDates(int doc_id) {
		return jdbcTemplate.query(SQL_GET_ALL_AVL_SLOT_DATES, new Object[] { doc_id }, new SlotAvlDatesMapper());
	}

	@Override
	public DocSchd getDoctor(int docId) {
		return jdbcTemplate.queryForObject(SQL_GET_DOCTOR_INFO,  new Object[] { docId }, new DocSchdMapper());
	}

	@Override
	public List<SlotAvl> getAllAvailableSlots(int doc_id, String dt) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
		try {
			utilDate = dateFormat.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jdbcTemplate.query(SQL_GET_ALL_AVL_SLOTS, new Object[] { doc_id, utilDate }, new SlotAvlMapper());
	}

	@Override
	public boolean createPatient(Patients p) {
		return jdbcTemplate.update(SQL_CREATE_PATIENT, p.getFirstName(), p.getLastName(), p.getAge(),
				p.getGender(),p.getContactNumber(), p.getEmail()) > 0;
	}

	@Override
	public boolean createAppointment(String dt, String docId, int pid, String from, String to) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
		try {
			utilDate = dateFormat.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jdbcTemplate.update(SQL_CREATE_APPOINTMENT, utilDate, Integer.parseInt(docId), pid, from, to) > 0;
	}

	@Override
	public SlotDetails getSlotDetails(int slotId) {
		return jdbcTemplate.queryForObject(SQL_GET_SLOT,  new Object[] { slotId }, new SlotDetailsMapper());
	}
	
	@Override
	public PatientId getPatientDetails(String firstName, String lastname) {
		return jdbcTemplate.queryForObject(SQL_GET_PATIENT_DETAILS,  new Object[] { firstName, lastname }, new PatientIdMapper());
	}

	@Override
	public Appointments getAppointmentDetails(String dt, int doctId, String slotFrom, String slotTo) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
		try {
			utilDate = dateFormat.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jdbcTemplate.queryForObject(SQL_GET_APPT_DETAILS, new Object[] { utilDate, doctId, slotFrom, slotTo}, new AppointmentsMapper());
	}

}

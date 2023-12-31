package com.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.HospitalDAO;
import com.dao.UserDAO;
import com.model.Appointments;
import com.model.DocSchd;
import com.model.Doctors;
import com.model.PatientId;
import com.model.Patients;
import com.model.SlotAvl;
import com.model.SlotAvlDates;
import com.model.SlotDetails;
import com.model.User;

@Controller
public class MainController {

	UserDAO userObj;
	HospitalDAO hspObj;

	@Autowired
	public MainController(UserDAO userObj, HospitalDAO hspObj) {
		this.userObj = userObj;
		this.hspObj = hspObj;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Homepage(Model model) {
		model.addAttribute("DoctorList", hspObj.getAllDoctors()); // Comment this
		return "homepage"; // "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authentication(@Validated User c, Model model) {
		User c1 = userObj.getUser(c.getUserName());
		if (c1.getPassword().equals(c.getPassword())) {
			model.addAttribute("DoctorList", hspObj.getAllDoctors());
			return "homepage";
		} else {
			return "login";
		}
	}

	@GetMapping(value = "/redirectToRegistration")
	public String RegistrationPage() {
		return "redirect:/registrationPage";
	}

	@RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
	public String register() {
		return "registration";
	}

	@GetMapping(value = "/redirectToLogin")
	public String LoginPage() {
		return "redirect:/";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@Validated User c) {
		int status = userObj.createUser(c);
		if (status > 0)
			return "registrationSuccess";
		else
			return "registrationFailed";
	}

	@RequestMapping(value = "/showDocInfo", method = RequestMethod.POST)
	public String showDocInfo(@RequestParam String docId, Model model) {

		for (Doctors d : hspObj.getAllDoctors()) {
			if (d.getDocId() == Integer.parseInt(docId)) {
				model.addAttribute("DoctorInfo", d);
			}
		}
		return "doctorInfo";
	}

	@RequestMapping(value = "/getCalendar", method = RequestMethod.POST)
	public String getCalendar(@RequestParam String docId, Model model) {

		List<SlotAvlDates> L = hspObj.getAvailableDates(Integer.parseInt(docId));
		// List<SlotAvl> S = hspObj.getAllAvailableSlots(Integer.parseInt(docId));
		DocSchd d = hspObj.getDoctor(Integer.parseInt(docId));

		model.addAttribute("DocId", docId);
		model.addAttribute("AvlDates", L);
		// model.addAttribute("AvlSlots", S);
		model.addAttribute("docRange", d.getRange());

		return "slotCalendar";
	}

	@RequestMapping(value = "/getAvlSlots", method = RequestMethod.GET)
	@ResponseBody
	public List<SlotAvl> getSlotsAvl(@RequestParam String docId, String date) {
		return hspObj.getAllAvailableSlots(Integer.parseInt(docId), date);
	}

	@RequestMapping(value = "/bookSlot", method = RequestMethod.GET)
	public String bookSlot(@RequestParam String docId, String date, String slotId, Model model) {

		model.addAttribute("DocId", docId);
		model.addAttribute("date", date);
		model.addAttribute("slot", slotId);

		return "getPatientDetails";
	}

	@RequestMapping(value = "/processAppointment", method = RequestMethod.GET)
	public String processAppointment(@RequestParam String docId, String date, String slotId, @Validated Patients p,
			Model model) {

		SlotDetails s = hspObj.getSlotDetails(Integer.parseInt(slotId));
		PatientId p1 = hspObj.getPatientDetails(p.getFirstName(), p.getLastName());
		Appointments a = hspObj.getAppointmentDetails(date, Integer.parseInt(docId), s.getSlotFrom(), s.getSlotTo());

		hspObj.createPatient(p);
		hspObj.createAppointment(date, docId, p1.getPatientId(), s.getSlotFrom(), s.getSlotTo());

		model.addAttribute("DocId", docId);
		model.addAttribute("date", date);
		model.addAttribute("slotId", slotId);

		model.addAttribute("AppId", a.getApptId());
		model.addAttribute("fullName", p.getFirstName() + " " + p.getLastName());
		model.addAttribute("age", p.getAge());
		model.addAttribute("gender", p.getGender());
		model.addAttribute("ContactNumber", p.getContactNumber());
		model.addAttribute("pid", p1.getPatientId());
		model.addAttribute("SlotTimings", "From: " + s.getSlotFrom() + " to " + s.getSlotTo());

		return "appointmentGeneration1";
	}
}
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

import com.dao.HospitalDAO;
import com.dao.UserDAO;
import com.model.DocSchd;
import com.model.Doctors;
import com.model.SlotAvlDates;
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
		return "homepage"; //"login";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authentication(@Validated User c, Model model) {
		User c1 = userObj.getUser(c.getUserName());
		if(c1.getPassword().equals(c.getPassword())) {
			model.addAttribute("DoctorList", hspObj.getAllDoctors());
			return "homepage";
		}
		else {
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
	
	@GetMapping(value="/redirectToLogin")
	public String LoginPage() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@Validated User c) {
		int status = userObj.createUser(c);
		if(status > 0)
			return "registrationSuccess";
		else
			return "registrationFailed";
	}
	
	@RequestMapping(value = "/showDocInfo", method = RequestMethod.POST)
	public String showDocInfo(@RequestParam String docId, Model model) {
		
		for(Doctors d : hspObj.getAllDoctors()) {
			if(d.getDocId() == Integer.parseInt(docId)) {
				model.addAttribute("DoctorInfo", d);
			}
		}
		return "doctorInfo";
	}
	
	@RequestMapping(value = "/getCalendar", method = RequestMethod.POST)
	public String getCalendar(@RequestParam String docId, Model model) {
		
		List<SlotAvlDates> L = hspObj.getAvailableDates(Integer.parseInt(docId));
		DocSchd d = hspObj.getDoctor(Integer.parseInt(docId));
		
		model.addAttribute("AvlDates", L);
		model.addAttribute("docRange", d.getRange());
		
		return "slotCalendar";
	}
}






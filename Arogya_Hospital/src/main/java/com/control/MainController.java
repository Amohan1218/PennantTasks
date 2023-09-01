package com.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.UserDAO;
import com.model.User;

@Controller
public class MainController {
	
	UserDAO userObj;
	
	@Autowired
	public MainController(UserDAO userObj) {
		this.userObj = userObj;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Homepage(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authentication(@Validated User c, Model model) {
		User c1 = userObj.getUser(c.getUserName());
		if(c1.getPassword().equals(c.getPassword())) {
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
}
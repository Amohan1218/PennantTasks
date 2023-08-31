package com.folder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Homepage(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/demo", method = RequestMethod.POST)
	public String Something(Model model) {
		
		return "ScheduleUpdatedPage";
	}
}
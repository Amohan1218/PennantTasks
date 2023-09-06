package com.folder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.folder.orm.model.AUser;
import com.folder.orm.model.LoanApplicant;
import com.folder.orm.service.LoanService;

@Controller
public class LoanCRUDController {

	LoanService lservice;

	@Autowired
	LoanCRUDController(LoanService loanserv) {
		this.lservice = loanserv;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String adminPage(@Validated LoanApplicant l1, Model model) {

		List<LoanApplicant> l2 = lservice.getAllApplications();

		model.addAttribute("allApplicants", l2);
		System.out.println(l2.toString());
		
		return "customerPage.jsp";
	}
}

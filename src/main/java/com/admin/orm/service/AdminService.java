package com.admin.orm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.admin.orm.dao.AdminDAO;
import com.admin.orm.model.RegisterUser;
import com.admin.orm.model.UserSession;
import com.admin.orm.model.Users;
import com.admin.orm.model.ValidateUser;
import com.customer.orm.model.LoanApplicant;

@Component
public class AdminService {

	AdminDAO adao;
	
	@Autowired
	public AdminService(AdminDAO adminDao) {
		this.adao = adminDao;
	}

	Calendar calendar = Calendar.getInstance();

	String todayDt = "" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
			+ calendar.get(Calendar.DAY_OF_MONTH) + "";

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public Date getExpireDate() {
		Date dt = new Date();
		calendar.setTime(dt);
		
		// Add minutes
	    calendar.add(Calendar.MINUTE, 15);
	    
	    // Convert Calendar back to Date
	    Date expTime = calendar.getTime();
	    return expTime;
	}
	
	// generating random Key
	public String generateRandomKey() {
		final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    final int LENGTH = 13; // Change this to your desired length
	    
	    Random random = new Random();
	    StringBuilder rstr = new StringBuilder(LENGTH);
	    
	    for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            rstr.append(randomChar);
        }
		return rstr.toString();
	}

	public String ValidateUserDetails(ValidateUser v) throws ParseException {
		String uname = v.getUserName();
		String pwd = v.getPassword().hashCode() + "";

		Users u = adao.getUser(uname); // Getting Single User
		
		Integer userId = u.getUserId().intValue();
		
		if (uname.equals(u.getUsername())) {
			if (pwd.equals(u.getPassword()) && u.getUserType().equals("ADMN")) {
				String output = "redirect:/adminPage" + "-" + userId;
				return output;
				
			} else if (pwd.equals(u.getPassword()) && u.getUserType().equals("CUST")) {
				String output = "redirect:/CustomerHome" + "-" + userId;
				return output;
				
			} else {
				return "Error";
			}
		}
		return "Error";
	}

	@Transactional
	public void createUser(RegisterUser r) throws NumberFormatException, ParseException {
		String password = r.getPassword().hashCode() + "";
		Users u = new Users(r.getuserName(), dateFormat.parse(todayDt), r.getAccType(), password, r.getEmailId(),
				r.getRecEmailId(), Long.parseLong(r.getPhNum()));
		adao.saveUser(u);
	}
	
	@Transactional
	public Integer createSession(Integer userId, String sessionId, String hostname, String key) throws ParseException {
		UserSession us = new UserSession(userId, sessionId, dateFormat.parse(todayDt), key, hostname, getExpireDate(), "AC");
		adao.saveSession(us);
		return us.getId();
	}
	
	@Transactional
	public UserSession getUserSession(Integer userId) {
		return adao.getSession(userId);
	}
	
	@Transactional
	public List<LoanApplicant> getListBydate(String date) throws ParseException{
		Date targetDate = dateFormat.parse(date);
		return adao.getApplicantsByDate(targetDate);
	}

	public List<LoanApplicant> getListByLoanAmount(String filterLoanAmountFrom, String filterLoanAmountTo) {
		Double amtFrom = Double.parseDouble(filterLoanAmountFrom);
		Double amtTo = Double.parseDouble(filterLoanAmountTo);
		
		return adao.getApplicantsByLAmount(amtFrom, amtTo);
	}
}

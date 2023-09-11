package com.customer.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.admin.orm.dao.AdminDAO;
import com.admin.orm.model.UserSession;

@SuppressWarnings("serial")
@WebFilter(filterName ="CustomerFilter", urlPatterns = {"/CustPage", "/applicationStatus", "/submitApplication", "/filterData", "/adminPage"})
public class CustomerFilter extends HttpFilter implements Filter {

	AdminDAO adminDao;

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("-- Inside the filter --");

		// Retrieve the FilterConfig from the ServletContext
		FilterConfig filterConfig = getFilterConfig();

		if (adminDao == null && filterConfig != null) {
			ServletContext servletContext = filterConfig.getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			adminDao = webApplicationContext.getBean(AdminDAO.class);
		}

		// Filtering logic before the request is processed
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		HttpSession session = httpRequest.getSession();

		Integer userSessionId = (Integer) session.getAttribute("userSessionId");
		String authKey = (String) session.getAttribute("authKey");

		Date dt = new Date();
		
		UserSession us = adminDao.getSession(userSessionId);

		if (us.getExpireTime().compareTo(dt) >= 0 && us.getSessionKey().equals(authKey)) {
			chain.doFilter(request, response);
		} else {
			PrintWriter out = httpResponse.getWriter();
			out.println("<h1>Sorry..!! Session TimeOut</h1>");
			System.out.println("Session Timeout..!!");
		}
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
}
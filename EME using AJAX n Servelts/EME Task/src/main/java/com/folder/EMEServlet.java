package com.folder;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/getResult")
public class EMEServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String s = req.getParameter("action");
		
		PrintWriter out = res.getWriter();
		try {
			if (s.equals("ready")) {
				out.println(EmpDAL.getJsonData());
			}
			if (s.equals("insertRecord")) {
				out.println(EmpDAL.insertData(req.getParameter("empid"), req.getParameter("name"), req.getParameter("job"),
						req.getParameter("sal"), req.getParameter("dept")));
			}
			if (s.equals("updateRecord")) {
				out.println(EmpDAL.updateData(req.getParameter("empid"), req.getParameter("name"), req.getParameter("job"),
						req.getParameter("sal"), req.getParameter("dept")));
			}
			if (s.equals("delete")) {
				out.println(EmpDAL.deleteData(req.getParameter("empid")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
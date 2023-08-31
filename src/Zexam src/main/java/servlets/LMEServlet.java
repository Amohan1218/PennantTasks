package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import folder.LoanDAL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/getLoanExam")
public class LMEServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String s = req.getParameter("action");
		
		PrintWriter out = res.getWriter();
		try {
			if (s.equals("ready")) {
				out.println(LoanDAL.getJsonData());
			}
			if (s.equals("insertRecord")) {
				LoanDAL.insertData(req.getParameter("loanid"), req.getParameter("bookid"), req.getParameter("borrowerid"),
						req.getParameter("checkoutdate"), req.getParameter("duedate"), req.getParameter("returndate"), req.getParameter("fine"));
			}
			if (s.equals("updateRecord")) {
				LoanDAL.updateData(req.getParameter("loanid"), req.getParameter("bookid"), req.getParameter("borrowerid"),
						req.getParameter("checkoutdate"), req.getParameter("duedate"), req.getParameter("returndate"), req.getParameter("fine"));
			}
			if (s.equals("delete")) {
				LoanDAL.deleteData(req.getParameter("loanid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
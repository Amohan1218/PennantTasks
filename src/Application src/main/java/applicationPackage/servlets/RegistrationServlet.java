package applicationPackage.servlets;

import java.io.IOException;

import applicationPackage.dals.myDBDAL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/createAccount")
public class RegistrationServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pwd = req.getParameter("password");
		
		res.getWriter().println(myDBDAL.insertData(uname, pwd));
	}
}
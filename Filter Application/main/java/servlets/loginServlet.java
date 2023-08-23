package servlets;

import java.io.IOException;
import java.sql.SQLException;

import dals.myDBDAL;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/authenticate")
public class loginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pwd = req.getParameter("password");
		
		try {
			String message = myDBDAL.authenticateUser(uname, pwd);
			
			String []s = message.split("&");

			res.getWriter().println(s[0]);
			res.setHeader("authKey", s[1]);
			
//			if(!s[1].equals(" ")) {
//				RequestDispatcher rd = req.getRequestDispatcher("/homepage.jsp");
//				rd.forward(req, res);
//			}else {
//				RequestDispatcher rd = req.getRequestDispatcher("/index.html");
//				rd.forward(req, res);
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

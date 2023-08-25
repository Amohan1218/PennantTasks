package servlets;

import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONObject;

import folder.myDBDAL;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/authenticatee")
public class loginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pwd = req.getParameter("password");
		
		try {
			JSONObject J = myDBDAL.authenticateUser(uname, pwd);		
			
			System.out.println("LoginServlet: " + J.getString("key"));
			
			HttpSession sessionVar = req.getSession();
			sessionVar.setAttribute("authKey", J.getString("key"));

			RequestDispatcher dispatcher1 = req.getRequestDispatcher("/index1.html");
			dispatcher1.forward(req, res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
package applicationPackage.servlets;

import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONObject;

import applicationPackage.dals.myDBDAL;
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
			JSONObject J = myDBDAL.authenticateUser(uname, pwd);
			
			res.setHeader("authKey", J.getString("key"));			
			
			System.out.println(J);
			
			res.getWriter().println(J);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
package applicationPackage.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/getPage")
public class getPageServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String url = req.getParameter("url");
		
		if(url.equals("EME_Task")) {
			RequestDispatcher rd = req.getRequestDispatcher("/EME_Task_Webapp/CRUDEMEindex.html");
			rd.forward(req, res);
		}
	}
}
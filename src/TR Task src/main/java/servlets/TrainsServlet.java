package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dals.TrainsDAL;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getTrains")
public class TrainsServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		try {
			out.println(TrainsDAL.getJsonData());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
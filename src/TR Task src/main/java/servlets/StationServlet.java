package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dals.StationsDAL;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getStations")
public class StationServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		try {
			out.println(StationsDAL.getJsonData());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
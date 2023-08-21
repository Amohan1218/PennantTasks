package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dals.BookTicket;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Passenger;
import models.Ticket;
import models.Train;
import models.URLExtraction;

@WebServlet("/getResult")
public class BookingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		String queryString = req.getQueryString();

		System.out.println(queryString);

		try { // sending url 
			
			URLExtraction.dumpData(queryString);

			// Extracting Passenger Data and Train Details 
			ArrayList<Passenger> P =
			URLExtraction.getPasgnrList();
			Train TR = URLExtraction.getTrain();

			// Creating Ticket 
			Ticket T = new Ticket(TR, P);

			// Booking Ticket.. Its generates the fare and PNR 
			T = BookTicket.book(T);

			req.setAttribute("data", T);

			RequestDispatcher rd = req.getRequestDispatcher("/ConfirmTicket.jsp");

			rd.forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
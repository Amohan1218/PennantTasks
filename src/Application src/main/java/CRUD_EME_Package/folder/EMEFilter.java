package CRUD_EME_Package.folder;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebFilter("/EME_Task_Webapp/CRUDEMEindex.html")
public class EMEFilter extends HttpFilter{
		
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("/EME_Task_Webapp/CRUDEMEindex.html --- Filter Invoked");
		
		chain.doFilter(req, res);
	}
}

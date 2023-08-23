package filters;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/getResult")
public class Filter1 extends HttpFilter{
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String keyF = response.getHeader("authKey");
				
		if(keyF.equals("y2ghgf6534jkh23512kj")) {
			chain.doFilter(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		}
	}
}

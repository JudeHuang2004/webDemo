package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletFrontDoor extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1366135174023953879L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ---- forward to private page
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();

		String requestURI = request.getRequestURI();
		if (requestURI.contains("fd/public")) {
			RequestDispatcher rd = context.getRequestDispatcher("/private");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = context.getRequestDispatcher("/error");
			rd.forward(request, response);
		}
	}
}

package LeeRaj.clock.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LeeRaj.clock.model.ClockBean;
import LeeRaj.clock.model.DateTimeFormatException;

/**
 * Servlet implementation class ClockServlet
 */
@WebServlet("/clock")
public class ClockServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
   	public ClockServlet() {
        super();
    	}

protected void doGet(HttpServletRequest request, 
   HttpServletResponse response) 
   throws ServletException, IOException {
		ClockBean clock = new ClockBean();
		try {
			String time = clock.getCurrentTimeFormatted("full");
			request.setAttribute("currentTime", time);
			request.getRequestDispatcher("/LeeRajClock.jsp").
			     forward(request, response);
		} catch (DateTimeFormatException e) {
			System.out.println(e.getStackTrace());
		}
		return;
	}

protected void doPost(HttpServletRequest request, 
   HttpServletResponse response) 
   throws ServletException, IOException {
		ClockBean clock = new ClockBean();
		try {
			String format = request.getParameter("format").trim();
			String time = clock.getCurrentTimeFormatted(format);
			request.setAttribute("currentTime", time);
RequestDispatcher rd = 
request.getRequestDispatcher("/LeeRajClock.jsp");
			rd.forward(request, response);
		} catch (DateTimeFormatException e) {
			System.out.println(e.getStackTrace());
		}
		return;
	}
}

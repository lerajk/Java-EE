package Leenoy.Rajkhowa.clock.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Leenoy.Rajkhowa.clock.model.ClockBean;
import Leenoy.Rajkhowa.clock.model.DateTimeFormatException;

/**
 * Servlet implementation class ClockServlet
 */
@WebServlet("/clock")
public class ClockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ClockBean clock = new ClockBean();
		try {
			String time = clock.getCurrentTimeFormatted("full");
			request.setAttribute("currentTime", time);
			request.getRequestDispatcher("/LeenoyRajkhowaClock.jsp").
			     forward(request, response);
			//rd.forward(request, response);
		} catch (DateTimeFormatException e) {
			System.out.println(e.getStackTrace());
		}
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ClockBean clock = new ClockBean();
		try {
			String format = request.getParameter("format").trim();
			String time = clock.getCurrentTimeFormatted(format);
			request.setAttribute("currentTime", time);
			RequestDispatcher rd = 
			request.getRequestDispatcher("/LeenoyRajkhowaClock.jsp");
			rd.forward(request, response);
		} catch (DateTimeFormatException e) {
			System.out.println(e.getStackTrace());
		}
		return;
	}

}

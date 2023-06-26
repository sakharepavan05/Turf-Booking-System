package com.Turf_handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Turf_bin.Booking_bo;
import com.Turf_bin.Login_bo;
import com.Turf_dao.Login_dao;

/**
 * Servlet implementation class View_booking_handler
 */
@WebServlet("/View_booking_handler")
public class View_booking_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_booking_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<h1><a href='index.html'>Home</a></h1>");
		pw.println("<h1>Booking List</h1>");
		List<Booking_bo> list=Login_dao.Boking_list();
		pw.print("<table border='1' width='100%'");
		pw.print("<tr><th>Name</th><th>Time</th><th>Date</th></tr>");
		for(Booking_bo e:list)
		{
			pw.print("<tr><td>"+e.getName()+"</td><td>"+e.getTime()+"</td><td>"+e.getDate()+"</td></tr>");

		}
		pw.print("</table>");
        pw.close();
	}

}

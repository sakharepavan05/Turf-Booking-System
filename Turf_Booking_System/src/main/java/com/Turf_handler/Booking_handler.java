package com.Turf_handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Turf_bin.Booking_bo;
import com.Turf_bin.Login_bo;
import com.Turf_dao.Login_dao;

/**
 * Servlet implementation class Booking_handler
 */
@WebServlet("/Booking_handler")
public class Booking_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booking_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String Name=request.getParameter("Turf_name");
		String Time=request.getParameter("time");
		String Date=request.getParameter("date");
		Booking_bo lb=new Booking_bo(Name,Time,Date);
		
		int status=Login_dao.Book(lb);
		if(status >0)
		{
			pw.println("Book sucessfully");
			RequestDispatcher rd=request.getRequestDispatcher("user_index.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("Booking Try Again");
			RequestDispatcher rd=request.getRequestDispatcher("Boking_turf.html");
			rd.include(request, response);
		}
	}

}

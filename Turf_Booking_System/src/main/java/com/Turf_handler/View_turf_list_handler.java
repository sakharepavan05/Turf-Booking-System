package com.Turf_handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Turf_bin.Turf_list_bo;
import com.Turf_dao.Turf_list_dao;

/**
 * Servlet implementation class View_turf_list_handler
 */
@WebServlet("/View_turf_list_handler")
public class View_turf_list_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_turf_list_handler() {
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
		pw.println("<h1>Turf List</h1>");
		List<Turf_list_bo> list = Turf_list_dao.Turf_list();
		pw.print("<table border='1' width='100%'");
		pw.print("<tr><th>Name</th><th>Location</th><th>Description</th><th>Edit</th><th>Delete</th></tr>");
		for(Turf_list_bo e:list)
		{
			pw.print("<tr><td>"+e.getName()+"</td><td>"+e.getLocation()+"</td><td>"+e.getDescription()+"</td><td><a href='update_servlet1?Name="+e.getName()+"'>edit</a></td><td><a href='Delete_turf_handler?Name="+e.getName()+"'>delete</a></td></tr>");

		}
		pw.print("</table>");
        pw.close();
	}

}

package com.migo.seo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetriveExistingFilesServlet
 * 
 * used to Display all the files stored in Server.
 */
@WebServlet("/RetriveExistingFilesServlet")
public class RetriveExistingFilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/filesList.jsp");
        dispatcher.forward(request, response); 
	}

}

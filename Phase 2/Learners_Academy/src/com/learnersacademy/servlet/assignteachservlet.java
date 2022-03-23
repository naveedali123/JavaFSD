package com.learnersacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.database.DBConnection;

/**
 * Servlet implementation class assignteachservlet
 */
@WebServlet("/assignteach")
public class assignteachservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignteachservlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String username = "root";
		String password = "Simplilearn";

        PrintWriter out = response.getWriter();
        
        RequestDispatcher rd =null;
		
			try {
				
				
				int Class = Integer.parseInt(request.getParameter("Class"));
				int name = Integer.parseInt(request.getParameter("name"));
				int subject = Integer.parseInt(request.getParameter("subject"));
		    				
				DBConnection dbConnection = new DBConnection(dbUrl, username, password);
			
				PreparedStatement stmnt = dbConnection.getConnection().prepareStatement ("update  teachers set class =?,subject=? where id=?");
				
				stmnt.setInt(1, Class);

			     stmnt.setInt(2, subject);
			     stmnt.setInt(3, name);

				stmnt.executeUpdate();
				
				stmnt.close();
				dbConnection.closeConnection();
	            
				out.println("<div align='center'>");
				out.println("<h1>Teacher Assigned Succesfully</h1>");
				out.println("</div>");
				out.println("<a href=\"classes-list.jsp\">Click here to go back</a>");
				
			}catch (Exception e) {
	            e.printStackTrace();
	            
			}
	}

}

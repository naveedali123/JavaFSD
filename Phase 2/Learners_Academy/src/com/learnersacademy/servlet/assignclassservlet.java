package com.learnersacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.database.DBConnection;

/**
 * Servlet implementation class assignclassservlet
 */
@WebServlet("/assignclass")
public class assignclassservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignclassservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String username = "root";
		String password = "Simplilearn";

        PrintWriter out = response.getWriter();
        
        RequestDispatcher rd =null;
		
			try {
				
				
				int Class = Integer.parseInt(request.getParameter("Class"));
				int name = Integer.parseInt(request.getParameter("name"));
		    

				// Initialize the database
				DBConnection dbConnection = new DBConnection(dbUrl, username, password);

				// Create a SQL query to insert data into demo table
				PreparedStatement stmnt = dbConnection.getConnection().prepareStatement ("update  students set class =? where id=?");
				
				
				// For the first parameter,
				// get the data using request object
				// sets the data to st pointer
				stmnt.setInt(1, Class);

//				// Same for second parameter
			  stmnt.setInt(2, name);

				// Execute the insert command using executeUpdate()
				// to make changes in database
				stmnt.executeUpdate();
				
	            // Close all the connections
				stmnt.close();
				dbConnection.closeConnection();
	            
				//response.sendRedirect("successPage");
				out.println("<div align='center'>");
				out.println("<h1>Product Succesfully Inserted</h1>");
				out.println("</div>");
				
			}catch (Exception e) {
	            e.printStackTrace();
	            
			}
	}
	}



package com.learnersacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.database.DBConnection;

/**
 * Servlet implementation class masterlistservlet
 */
@WebServlet("/masterlist")
public class masterlistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public masterlistservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*doGet(request, response);*/
		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String username = "root";
		String password = "Simplilearn";

        PrintWriter out = response.getWriter();
        
        RequestDispatcher rd =null;
		
			try {
				
				
				int Class = Integer.parseInt(request.getParameter("Class"));
				/*int name = Integer.parseInt(request.getParameter("name"));
				int subject = Integer.parseInt(request.getParameter("subject"));
		    */

				// Initialize the database
				DBConnection dbConnection = new DBConnection(dbUrl, username, password);

				// Create a SQL query to insert data into demo table
				PreparedStatement stmnt = dbConnection.getConnection().prepareStatement ("select s.fname,t.tfname,sb.name from students s, teachers t,subjects sb where s.class=? AND t.class=? AND sb.class=? ");
				
				stmnt.setInt(1, Class);
				stmnt.setInt(2, Class);
				stmnt.setInt(3, Class);

//				// Same for second parameter
			    

				// Execute the insert command using executeUpdate()
				// to make changes in database
			     ResultSet rs =stmnt.executeQuery();
				
	            // Close all the connections
				
	            
				//response.sendRedirect("successPage");
				out.println("<div align='center'>");
				out.println("<h1>Class DETAILS</h1>");



				out.println("<style> table,td,th {border:1px solid green; padding:10px;}</style>");



				out.print("<table>");



				out.print("<th> Product ID </th>");

				out.print("<th> Product Name </th>");

				out.print("<th> Product Price </th>");

				



				out.print ("</tr>");



				/* Printing result */

				while (rs.next()){



				out.print("<tr><td>"


				+ rs.getString("fname") + " </td><td>"
						+ rs.getString("tfname") + " </td><td>"
								+ rs.getString("name") + " </td>");

				

				}



				out.print ("</table>");
				out.println("</div>");
				stmnt.close();
				dbConnection.closeConnection();
				
			}catch (Exception e) {
	            e.printStackTrace();
	            
			}

	}

}

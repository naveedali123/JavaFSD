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
				
				
				DBConnection dbConnection = new DBConnection(dbUrl, username, password);

				PreparedStatement stmnt1 = dbConnection.getConnection().prepareStatement ("select fname from students  where class=? ");
				
				PreparedStatement stmnt2 = dbConnection.getConnection().prepareStatement ("select tfname from teachers  where class=? ");
				
				PreparedStatement stmnt3 = dbConnection.getConnection().prepareStatement ("select name from subjects  where class=?");
				
				stmnt1.setInt(1, Class);
				stmnt2.setInt(1, Class);
				stmnt3.setInt(1, Class);

			     ResultSet rs1 =stmnt1.executeQuery();
			     ResultSet rs2 =stmnt2.executeQuery();
			     ResultSet rs3 =stmnt3.executeQuery();
			     out.println("<a style='text-align: right'href=\"classes-list.jsp\">DashBoard</a>");
			     out.println("<h1 style='text-align: center'>Class Report</h1>");
				out.println("<div float='left' style='display: flex'>");
				
				out.println("<style> table,td,th {border:1px solid blue; padding:10px;}</style>");
				out.print("<table>");
				out.print("<th> Student Name </th>");

				/*out.print("<th> Teacher Name </th>");

				out.print("<th> Subject Name </th>");*/

				out.print ("</tr>");

				while (rs1.next()){


				out.print("<tr><td>"+ rs1.getString("fname") + " </td></tr>");

				}
				/*+ rs.getString("tfname") + " </td><td>"+ rs.getString("name") + " </td>"*/
				
				out.print ("</table>");
				//out.println("</div>");
				
				out.println("<style> table,td,th {border:1px solid blue; padding:10px;}</style>");
				out.print("<table style='margin-left: 25px'>");
			/*	out.print("<th> Student Name </th>");*/

			out.print("<th> Teacher Name </th>");

				

				out.print ("</tr>");

				while (rs2.next()){


				out.print("<tr><td>"+ rs2.getString("tfname") + " </td></tr>");

				}
				/*+ rs.getString("tfname") + " </td><td>"+ rs.getString("name") + " </td>"*/
				
				out.print ("</table>");
				//out.println("</div>");
				
				out.print("<table style='margin-left: 15px'>");
				
				out.print("<th> Subject Name </th>");

				out.print ("</tr>");

				while (rs3.next()){


				out.print("<tr><td>"+ rs3.getString("name") + " </td></tr>");

				}
				/*+ rs.getString("tfname") + " </td><td>"+ rs.getString("name") + " </td>"*/
				
				out.print ("</table>");
				out.println("</div>");
				stmnt1.close();
				stmnt2.close();
				stmnt3.close();
				dbConnection.closeConnection();
				
			}catch (Exception e) {
	            e.printStackTrace();
	            
			}

	}

}

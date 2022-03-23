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

				PreparedStatement stmnt = dbConnection.getConnection().prepareStatement ("select s.fname,t.tfname,sb.name from students s, teachers t,subjects sb where s.class=? AND t.class=? AND sb.class=? ");
				
				stmnt.setInt(1, Class);
				stmnt.setInt(2, Class);
				stmnt.setInt(3, Class);

			     ResultSet rs =stmnt.executeQuery();
				
				out.println("<div align='center'>");
				out.println("<h1>Class Report</h1>");
				out.println("<style> table,td,th {border:1px solid blue; padding:10px;}</style>");
				out.print("<table>");
				out.print("<th> Student Name </th>");

				out.print("<th> Teacher Name </th>");

				out.print("<th> Subject Name </th>");

				out.print ("</tr>");

				while (rs.next()){


				out.print("<tr><td>"+ rs.getString("fname") + " </td><td>"+ rs.getString("tfname") + " </td><td>"+ rs.getString("name") + " </td>");

				}
				out.print ("</table>");
				out.println("</div>");
				stmnt.close();
				dbConnection.closeConnection();
				out.println("<a href=\"classes-list.jsp\">DashBoard</a>");
			}catch (Exception e) {
	            e.printStackTrace();
	            
			}

	}

}

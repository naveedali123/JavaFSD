package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;

/**
* Servlet implementation class ProductDetails
*/
@WebServlet("/list")
public class SearchProductservlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public SearchProductservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                
        	String dbUrl = "jdbc:mysql://localhost:3306/ecommerce";

        	String username = "root";

        	String password = "Simplilearn";

        	PrintWriter out = response.getWriter();

        	out.println("<html><body>");

        	try {

        	DBConnection dbConnection = new DBConnection(dbUrl, username, password);

                        Statement stmt = dbConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                      
                        String productSearch = request.getParameter("search");
                       
                        if(productSearch.isEmpty())
                        {	
	                        out.println("<h2 style='color:red;'>Please Enter product ID</h2>");
	                        out.println("<a href=\"searchproduct.html\">Click here to go back</a>");
                        }
                    
                        else 
                        {
                        	
                        	String sql_res= "select * from eproduct where id=" + productSearch;
                            ResultSet querry = stmt.executeQuery(sql_res);
                            
                            if(querry.next()) {
                            	out.println("<h1 style='color:green;'> Product List :- </h1>");
                    		out.println("<style> table,td,th {border:1px solid green; padding:10px;}</style>");
                    		out.println("<table>");

                    		out.println("<tr>");
                    		out.print("<th> Product ID </th>");
                    		out.print("<th> Product Name </th>");
                    		out.print("<th> Product Price </th>");
                    		out.print("</tr>");
                    			out.print("<tr>");
                    			out.print("<td>" + querry.getInt("ID") + "</td>");
                    			out.print("<td>" + querry.getString("name") + "</td>");
                    			out.print("<td>" + querry.getDouble("price") + "</td>");
                    			out.print("</tr>");                   	
                    		out.print("</table>");
                            	
                        }
                           
                            else {
                            	out.println("<h2 style='color:red;'>There was no element with product ID: " + productSearch + " found in the table <br/> please try again</h2>");
                            out.println("<a href=\"searchproduct.html\">Click here to go back</a>");
                            }
                        }
                    	
                        stmt.close();
                        out.println("</body></html>");
                        dbConnection.closeConnection();
                        
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}


package com.Validation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class LoginValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		RequestDispatcher rd=null;
		if(username.equalsIgnoreCase("naveed") && password.equals("admin@123")){
		rd=request.getRequestDispatcher("DashboardPageServlet");
		rd.forward(request,response);
		}
		else{
		rd=request.getRequestDispatcher("Userloginpage.html");
		PrintWriter out=response.getWriter();
		rd.include(request,response);
		out.println(("<center><span style='color:red'>Invalid Credentials!! Please try again</span></center>"));
		}
	}

}
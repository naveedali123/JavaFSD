package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.util.Eproduct;
import com.ecommerce.util.HibernateUtil;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addproduct")
public class AddproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddproductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("addproduct.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body>");
		

		String name = request.getParameter("name");
		String price = request.getParameter("price");
		if(name.isEmpty() && price.isEmpty()) {
			pw.println("<h2 style='color:blue'>Enter correct products details again</h2><br/>");
			pw.println("<a href=\"addproduct.html\">Click here to go back</a>");
		}
		else {
		// STEP 1: Gets SessionFactory Object
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		
		// STEP 2: Open Sesson
		Session session = sf.openSession();
		
		
		Transaction tx = session.beginTransaction();
			Eproduct ep = new Eproduct();
			ep.setName(name);
			ep.setPrice(Double.valueOf(price));
			session.save(ep);
		
		tx.commit();
		
		pw.println("<h3 style='color:blue'> Product is created successfully ! </h3>");
		pw.println("<a href=\"readproduct\">Click here to view Product</a>");
		
		session.close();
		}
		
	}

}

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
import javax.xml.bind.*;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.ecommerce.eproduct;
import com.ecommerce.HibernateUtil;

/**
* Servlet implementation class ListProducts
*/
@WebServlet("/list")
public class ListProducts extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
        
        
    /**
* @see HttpServlet#HttpServlet()
*/
    public ListProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                 try {
                        SessionFactory factory = HibernateUtil.buildSessionFactory();
                        
                        Session session = factory.openSession();
                        // using HQL
                        List<eproduct> list = session.createQuery("from eproduct").list();
                        
                        session.close();
                        
                         PrintWriter out = response.getWriter();
                         out.println("<html><body>");
                         out.println("<b>Product Listing</b><br>");
                         for(eproduct p: list) {
                                 out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getname() +
                                                 ", Price: " + String.valueOf(p.getprice())  + "<br>");
                         }
                         
                     out.println("</body></html>");
                     
                     
                 } catch (Exception ex) {
                         throw ex;
                 }
                    
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}

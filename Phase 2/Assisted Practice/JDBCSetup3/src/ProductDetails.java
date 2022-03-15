
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;

/**
* Servlet implementation class ProductDetails
*/
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public ProductDetails() {
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
                	//Statement stmnt = dbConnection.getConnection().createStatement();
                    CallableStatement stmnt = dbConnection.getConnection().prepareCall("{call add_product(?, ?)}");
                         
                        stmnt.setString(1, "new product");
                        stmnt.setBigDecimal(2, new BigDecimal(1900.50));
                        stmnt.executeUpdate();
                        
                        out.println("Stored procedure has been executed.<Br>");
                        stmnt.close();
                        
                        
                        out.println("</body></html>");
                        dbConnection.closeConnection();
                        
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException e) {
                        e.printStackTrace();
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

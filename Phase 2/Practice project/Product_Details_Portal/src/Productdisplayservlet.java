import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class productservlet
 */
@WebServlet("/product")
public class Productdisplayservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productdisplayservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//PrintWriter out = response.getWriter();
		String name =request.getParameter("name");
		String price= request.getParameter("price");
		if(name.isEmpty() || price.isEmpty()) {
			request.setAttribute("name", name);
			request.setAttribute("price", price);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}else {
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.getRequestDispatcher("/viewproduct.jsp").forward(request, response);
		}
	}

}

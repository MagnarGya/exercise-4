package no.hib.dat152;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/Product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("cart")!=null){
			@SuppressWarnings("unchecked")
			ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
			cart.add(FakeDAO.products[Integer.parseInt(request.getParameter("product"))]);
			session.setAttribute("cart", cart);
		}else{
			ArrayList<Product> cart = new ArrayList<Product>();
			cart.add(FakeDAO.products[Integer.parseInt(request.getParameter("product"))]);
			session.setAttribute("cart", cart);
		}
		doGet(request, response);
	}

}

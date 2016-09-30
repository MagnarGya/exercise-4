package no.hib.dat152;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> products = (ArrayList<Product>) request.getSession().getAttribute("cart");
		HashMap<Product,Integer> cartMap = new HashMap<Product,Integer>();
		float sum = 0;
		HashMap<Product,String> descriptionMap = new HashMap<Product,String>();
		if(products != null){
			for (Product p : products) {
				if (cartMap.containsKey(p)) {
					cartMap.put(p, cartMap.get(p)+1);
					sum+=p.getPriceInEuro();
				} else {
					cartMap.put(p, 1);
					sum+=p.getPriceInEuro();
				}
			}
			
			String langcode = (String)request.getParameter("language");

			if (langcode == null) {
				langcode = request.getSession().getAttribute("language").toString();
				if (langcode == null) {
					langcode = request.getLocale().toString();
				}
			}
			
			System.out.println(langcode);
			
			for (Product p : cartMap.keySet()) {
				descriptionMap.put(p, FakeDAO.getDescription(p.pno, langcode));
			}
		}
		
		request.setAttribute("sum", sum);
		request.setAttribute("cartMap", cartMap);
		request.setAttribute("descriptionMap", descriptionMap);
		request.getRequestDispatcher("WEB-INF/jsp/Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

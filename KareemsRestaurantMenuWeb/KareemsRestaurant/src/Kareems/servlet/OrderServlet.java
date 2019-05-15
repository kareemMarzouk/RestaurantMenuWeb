package Kareems.servlet;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for accepting and propagating the input of different menu items in an order
 */

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("menu", MenuManager.getInstance().getMenu());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/OrderPage.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean selected = false;
		for(int item=0;item<MenuManager.getInstance().getMenu().size();item++) {
			String selectedQuantity = request.getParameter(Integer.toString(item));
			if(selectedQuantity!=null && !selectedQuantity.isEmpty() && !selectedQuantity.equals("0")) {
				selected=true;
			}
		}
		
		if(selected) { //If an item is selected, items selected are added to a new order and passed to confirmation JSP page.
			Order newOrder = new Order();
			for(int item=0;item<MenuManager.getInstance().getMenu().size();item++) {
				String selectedQuantity = request.getParameter(Integer.toString(item));
				if(selectedQuantity!=null && !selectedQuantity.isEmpty() && !selectedQuantity.equals("0")) {
					newOrder.addItemToOrder(MenuManager.getInstance().getMenu().get(item),Integer.parseInt(selectedQuantity));
				}
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/ConfirmationPage.jsp");
			request.setAttribute("order",newOrder);
			request.setAttribute("order_items",newOrder.getItems());
			requestDispatcher.forward(request, response);								
		}else {
			doGet(request, response);
		}
	
	
	}

}

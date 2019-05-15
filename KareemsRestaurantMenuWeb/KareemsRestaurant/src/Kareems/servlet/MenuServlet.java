package Kareems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet responsible for displaying menu items to the user prior to entering a name
 */

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setAttribute("menu", MenuManager.getInstance().getMenu());
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/MenuPage.jsp");
		 requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if(request.getParameter("name").isEmpty()) {
			request.setAttribute("flag", "You must enter a username!");
			doGet(request, response);
		}else {
			MenuManager.getInstance().incrementOrderNo();
			request.getSession().setAttribute("orderName", request.getParameter("name"));
			request.getSession().setAttribute("orderNo", MenuManager.orderNumber);
			request.getRequestDispatcher("/OrderServlet").forward(request, response);
		}
	}
	
	

}

package Kareems.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for handling Confirmation or Cancellation of items.
 */
@WebServlet("/ConfirmationServlet")
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Servlet only contains a get method which is passed the value of the button passed by the user to either confirm 
     * or cancel the order.
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String buttonClicked = request.getParameterValues("button")[0]; 
		if(buttonClicked.equals("Confirm")) {
			request.setAttribute("Status",1);
			request.setAttribute("time", getOrderTime());
		}else {
			request.setAttribute("Status",0);
		}
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/FinalPage.jsp");
		 requestDispatcher.forward(request, response);
	}
	
	public String getOrderTime() {
		Calendar cal = Calendar.getInstance();
		long time = cal.getTimeInMillis() + 1200;
		DateFormat df = DateFormat.getTimeInstance(DateFormat.LONG);
		time+=20*60*1000;
		return df.format(new Date(time));
	}

}

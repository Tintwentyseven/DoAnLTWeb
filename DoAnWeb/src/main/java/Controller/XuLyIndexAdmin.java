package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderDAO;
import Model.Order;

/**
 * Servlet implementation class XuLyIndexAdmin
 */
@WebServlet("/XuLyIndexAdmin")
public class XuLyIndexAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyIndexAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		 response.setContentType("text/html;charset=UTF-8"); 
		String error = ""; 
    	
		String url = "";
		 OrderDAO dao2 = new OrderDAO();
         int totalsell = dao2.getTotalProduct(1);
         int coffeesell = dao2.getTotalDrinkSell("Cà phê",1);
         int milkteasell = dao2.getTotalDrinkSell("Trà sữa",1);
         int juicesell = dao2.getTotalDrinkSell("Nước ép",1);
         double coffeemoney = dao2.getTotalDrinkSellM("Cà phê", 1);
         double milkteamoney = dao2.getTotalDrinkSellM("Trà sữa", 1);
         double juicemoney = dao2.getTotalDrinkSellM("Nước ép", 1);
         List<Order> list2 = dao2.getAllOrderByAdmin(1);
		
		HttpSession session = request.getSession(true);
        if(list2!=null) {
		session.setAttribute("listsell", list2);
		session.setAttribute("totalsell", totalsell);
		session.setAttribute("coffeesell", coffeesell);
		session.setAttribute("milkteasell", milkteasell);
		session.setAttribute("juicesell", juicesell);
		session.setAttribute("coffeem", coffeemoney);
		session.setAttribute("milkteam", milkteamoney);
		session.setAttribute("juicem", juicemoney);
		url = "/WEB-INF/Web/indexforadmin.jsp";
        }
        
		
        
		if (url != null) { // Check if URL is valid
		    getServletContext().getRequestDispatcher(url).forward(request, response);
		    
		}
		}
		  
		  // Forward the request to Shop.jsp
		  
	        
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}



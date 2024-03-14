package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhachHangDAO;
import DAO.ProductDAO;
import Model.Product;
import Model.User;

/**
 * Servlet implementation class XuLyUser
 */
@WebServlet(name = "XuLyUser", urlPatterns = {"/XuLyUser"})

public class XuLyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
		
		 response.setContentType("text/html;charset=UTF-8"); 
		  
    	KhachHangDAO dao = new KhachHangDAO();
		String url = "";
		List<User> list = dao.getAllUser();
		
		HttpSession session = request.getSession(true);
        if(list!=null) {
		session.setAttribute("listU", list);
		session.setAttribute("numberUser", list.size());
		url = "/WEB-INF/Web/AdminUserTemplate.jsp";
		
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

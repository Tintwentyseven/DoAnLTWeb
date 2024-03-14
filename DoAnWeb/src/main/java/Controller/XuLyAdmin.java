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
import Model.KhachHang;
import Model.User;

/**
 * Servlet implementation class XuLyAdmin
 */
@WebServlet("/XuLyAdmin")
public class XuLyAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		 KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
		    if (auth == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
	    
    	KhachHangDAO dao = new KhachHangDAO();
		String url = "";
		List<User> list = dao.getAdminBoss();
		List<User> list2 = dao.getAllAdminExcept();
		List<User> list3 = dao.getAllAdmin();
		
		HttpSession session = request.getSession(true);
        if(list!=null) {
		session.setAttribute("listAB", list);
		session.setAttribute("numberAdminB", list.size());
		url = "/WEB-INF/Web/AdminTemplate.jsp";
		
        }
        if(list2!=null) {
        	session.setAttribute("listA", list2);
        	url = "/WEB-INF/Web/AdminTemplate.jsp";
        	
        }
        if(list3!=null) {
        	session.setAttribute("numberAdmin", list3.size());
        	url = "/WEB-INF/Web/AdminTemplate.jsp";
        	
        }
		if (url != null) { // Check if URL is valid
		    getServletContext().getRequestDispatcher(url).forward(request, response);
		    
		}
		}
		  
		  // Forward the request to Shop.jsp
		  
	        
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
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

package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import Model.Comments;
import Model.KhachHang;

/**
 * Servlet implementation class XuLyAdminComment
 */
@WebServlet("/XuLyAdminComment")
public class XuLyAdminComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyAdminComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		 response.setContentType("text/html;charset=UTF-8"); 
		 KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
		    if (auth == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
		String error = ""; 
    	ProductDAO dao = new ProductDAO();
		String url = "";
		List<Comments> list = dao.getAllComment();
		
		HttpSession session = request.getSession(true);
        if(list!=null) {
		session.setAttribute("CoAdmin", list);
		session.setAttribute("numberCo", list.size());
		url = "/WEB-INF/Web/AdminCommentTemplate.jsp";
		
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

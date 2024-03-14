package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Model.KhachHang;
import Model.Product;

/**
 * Servlet implementation class XuLyHDComment
 */
@WebServlet("/XuLyHDComment")
public class XuLyHDComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyHDComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String action = request.getParameter("action") == null ? "" : request.getParameter("action");

		switch (action.toLowerCase()) {
		
		
		case "delete":
			delete(request, response);
			break;
		case "deleteall":
			deleteall(request, response);
			break;
		
		}
    }
	

	

	

	private void deleteall(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
	    if (auth.getUserName() == null) {
	        // User not authenticated, redirect to the login page
	        response.sendRedirect("DangNhap.jsp");
	        return; // Stop further processing
	    }
	    ProductDAO dao = new ProductDAO();
	    dao.deleteAllCommentAdmin();
	    response.sendRedirect("XuLyAdminComment");
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
	    if (auth.getUserName() == null) {
	        // User not authenticated, redirect to the login page
	        response.sendRedirect("DangNhap.jsp");
	        return; // Stop further processing
	    }
		String time = request.getParameter("time");
		ProductDAO dao = new ProductDAO();
		dao.deleteComment(time);
		response.sendRedirect("XuLyAdminComment");
		
	}

	
		  
		 
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

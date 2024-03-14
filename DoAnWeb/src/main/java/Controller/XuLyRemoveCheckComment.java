package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import Model.KhachHang;

/**
 * Servlet implementation class XuLyRemoveCheckComment
 */
@WebServlet("/XuLyRemoveCheckComment")
public class XuLyRemoveCheckComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyRemoveCheckComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
		    if (auth == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
		StringBuilder datecomment = new StringBuilder();
		 for(String commentd:request.getParameterValues("selectedComments")) {
			 datecomment.append("'").append(commentd).append("',");
		 }
		 datecomment.deleteCharAt(datecomment.length()-1);
		 ProductDAO dao = new ProductDAO();
		 dao.deleteCommentsAdmin(datecomment);
		 response.sendRedirect("XuLyAdminComment");
	}

}

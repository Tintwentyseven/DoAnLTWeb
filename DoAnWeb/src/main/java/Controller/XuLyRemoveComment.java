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
 * Servlet implementation class XuLyRemoveComment
 */
@WebServlet("/XuLyRemoveComment")
public class XuLyRemoveComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyRemoveComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
		    if (auth == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
		String time = request.getParameter("time");
		ProductDAO dao = new ProductDAO();

		dao.deleteComment(time);
        response.sendRedirect("XuLyComment?username=" + auth.getUserName());


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
 * Servlet implementation class XuLyComment
 */
@WebServlet("/XuLyComment")
public class XuLyComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		/* response.setContentType("text/html;charset=UTF-8"); */
		  
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		 KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
		    if (auth.getUserName() == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
		String username = request.getParameter("username");
		ProductDAO dao = new ProductDAO();
		List<Comments> listCo = dao.getAllCommentByUserName(username);
		  HttpSession session = request.getSession();

		  session.setAttribute("listComment", listCo);
			request.getRequestDispatcher("/WEB-INF/Web/Comment.jsp").forward(request, response);
		  // Forward the request to Shop.jsp
    }
	        
    
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

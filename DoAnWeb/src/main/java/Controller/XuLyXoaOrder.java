package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OrderDAO;
import DAO.ProductDAO;
import Model.KhachHang;

/**
 * Servlet implementation class XuLyXoaOrder
 */
@WebServlet("/XuLyXoaOrder")
public class XuLyXoaOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyXoaOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		    response.setCharacterEncoding("utf-8");
		    
		    String auth = request.getParameter("username");
		    String id = request.getParameter("id");
		      

		    ProductDAO dao = new ProductDAO();
		    OrderDAO dao2 = new OrderDAO();
		    dao2.deleteOrderByOrderid(id, auth);
		    response.sendRedirect("XuLyCheckOut");
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

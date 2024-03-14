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
import Model.KhachHang;
import Model.Product;

/**
 * Servlet implementation class XuLyZtoAProduct
 */
@WebServlet("/XuLyZtoAProduct")
public class XuLyZtoAProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyZtoAProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
		    if (auth.getUserName() == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
		 ProductDAO dao = new ProductDAO();
		  
		  List<Product> list = dao.getAllProductFromZtoA();
		
		HttpSession session = request.getSession();
	    session.setAttribute("listProduct", list);

	    // Forward to the Shop.jsp instead of redirecting
	    request.getRequestDispatcher("/WEB-INF/Web/Shop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

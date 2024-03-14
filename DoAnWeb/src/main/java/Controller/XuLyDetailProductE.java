package Controller;

import java.io.IOException;

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
 * Servlet implementation class XuLyDetailProductE
 */
@WebServlet("/XuLyDetailProductE")
public class XuLyDetailProductE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyDetailProductE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		 KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
		    if (auth.getUserName() == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
		String productid = request.getParameter("productid");
		ProductDAO dao = new ProductDAO();
		
		  Product p = dao.getAllProductByIdE(productid);
		  HttpSession session = request.getSession();
		  String lang = request.getParameter("lang");
			
			session.setAttribute("lang", lang);
		  session.setAttribute("detail",
		  p); request.getRequestDispatcher("/WEB-INF/Web/shop-single.jsp").forward(request,
		  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

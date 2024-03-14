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
 * Servlet implementation class XuLyRemoveCheckProduct
 */
@WebServlet("/XuLyRemoveCheckProduct")
public class XuLyRemoveCheckProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyRemoveCheckProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
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
		 StringBuilder productIds = new StringBuilder();
		 for(String proid:request.getParameterValues("selectedProducts")) {
			 productIds.append("'").append(proid).append("',");
		 }
		 productIds.deleteCharAt(productIds.length()-1);
		 ProductDAO dao = new ProductDAO();
		 dao.deleteProducts(productIds);
		 response.sendRedirect("XuLyAdminProduct");
	}

}

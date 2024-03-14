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
 * Servlet implementation class XuLyHDProductEdit
 */
@WebServlet("/XuLyHDProductEdit")
public class XuLyHDProductEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyHDProductEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		String id = request.getParameter("editproductid"); 
		  ProductDAO dao = new ProductDAO();
		  Product pr = dao.getAllProductById(id);
		  String url="";
		  HttpSession session = request.getSession(true);
		  if(pr!=null) {
				
				session.setAttribute("productE", pr);
				
				url = "/WEB-INF/Web/EditProductTemplate.jsp";
				
		        }
				if (url != null) { // Check if URL is valid
				    getServletContext().getRequestDispatcher(url).forward(request, response);
				    
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
//		  KhachHang auth = (KhachHang) request.getSession().getAttribute("user"); if
//		  (auth == null) { // User not authenticated, redirect to the login page
//		  response.sendRedirect("DangNhap.jsp"); return; // Stop further processing }
//		  }
		String proid = request.getParameter("productId");
		String proname = request.getParameter("productName");
		String prodes = request.getParameter("productDes");
		String proImg = request.getParameter("productImg");
		String img = "assets/img/";
		double proPri = Double.parseDouble(request.getParameter("productPrice"));
		int proNum = Integer.parseInt(request.getParameter("productNumber"));
		String proCaid = request.getParameter("productCaid");
		String error = ""; 
		String url = "";
		if(!proImg.contains("assets/img/")) {
			img += proImg;
		}
		ProductDAO dao = new ProductDAO();
		
			
			
			dao.updateProduct(proid, proname, prodes, img, proPri, proNum, proCaid);
			
			    
		
		
		response.sendRedirect("XuLyAdminProduct");
		}
		
	}
	



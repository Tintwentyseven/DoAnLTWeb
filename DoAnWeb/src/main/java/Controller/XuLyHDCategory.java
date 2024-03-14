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
 * Servlet implementation class XuLyHDCategory
 */
@WebServlet("/XuLyHDCategory")
public class XuLyHDCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyHDCategory() {
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
		
		case "add":
			add(request, response);
			break;
		case "edit":
			edit(request, response);
			break;
		case "update":
			update(request,response);
		    break;
		case "delete":
			delete(request, response);
			break;
		case "deleteall":
			deleteall(request, response);
			break;
		
		}
    }
	

	

	private void update(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String proid = request.getParameter("productId");
		String proname = request.getParameter("productName");
		String prodes = request.getParameter("productDes");
		String proImg = request.getParameter("productImg");
		String img = "assets/img/";
		double proPri = Double.parseDouble(request.getParameter("productPrice"));
		String proCaid = request.getParameter("productCaid");
		String error = ""; 
		String url = "";
		
		if(!proImg.contains("assets/img/")) {
			img += proImg;
		}
		ProductDAO dao = new ProductDAO();
		if(dao.checkProductExists(proid)) {
			error+="Id sản phẩm đã tồn tại. Vui lòng chọn Id khác.";
		}
		if (!error.isEmpty() & url != null) {
			request.setAttribute("error", error);
			url = "/AddProduct.jsp";
			
			    getServletContext().getRequestDispatcher(url).forward(request, response);
			
		}else {
		dao.themProduct(proid, proname, prodes, img,proPri,2,proCaid);
		
		response.sendRedirect("XuLyAdminProduct");
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
		CategoryDAO dao = new CategoryDAO();
		ProductDAO dao2 = new ProductDAO();
		dao.deleteAllCategory();
		dao2.deleteAllProduct();
		response.sendRedirect("XuLyAdminCategory");
		
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
		String pid = request.getParameter("caid");
		ProductDAO dao = new ProductDAO();
		CategoryDAO dao2 = new CategoryDAO();
		dao2.deleteCategory(pid);
		dao.deleteProductByCaid(pid);
		response.sendRedirect("XuLyAdminCategory");
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String id = request.getParameter("editproductid"); 
		  ProductDAO dao = new ProductDAO();
		  Product pr = dao.getAllProductById(id);
		  String url="";
		  HttpSession session = request.getSession(true);
		  if(pr!=null) {
				
				session.setAttribute("productE", pr);
				
				url = "/EditProduct.jsp";
				
		        }
				if (url != null) { // Check if URL is valid
				    getServletContext().getRequestDispatcher(url).forward(request, response);
				    
				}
		  
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

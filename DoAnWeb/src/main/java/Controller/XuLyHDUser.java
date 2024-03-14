package Controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhachHangDAO;
import DAO.ProductDAO;
import Model.Email;
import Model.KhachHang;
import Model.Product;

/**
 * Servlet implementation class XuLyHDUser
 */
@WebServlet("/XuLyHDUser")
public class XuLyHDUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyHDUser() {
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
		case "capquyen" :
			capquyen(request, response);
			break;
		case "thuhoi" :
			thuhoi(request, response);
			break;
		
		}

	}

	
	private void capquyen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
	    if (auth == null) {
	        // User not authenticated, redirect to the login page
	        response.sendRedirect("DangNhap.jsp");
	        return; // Stop further processing
	    }
String bid = request.getParameter("userid");
		
		KhachHangDAO dao = new KhachHangDAO();
		dao.update(bid, "Admin");
		response.sendRedirect("XuLyUser");


	}
	private void thuhoi(HttpServletRequest request, HttpServletResponse response)
	 
			throws IOException {
			   request.setCharacterEncoding("utf-8");
			   response.setCharacterEncoding("utf-8");

			   KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
			   if (auth == null) {
			       // User not authenticated, redirect to the login page
			       response.sendRedirect("DangNhap.jsp");
			       return; // Stop further processing
			   }

			   String bid = request.getParameter("adminid");

			   // Redirect to XuLyUser immediately if userid is UID001
			   
			   // Update user to "User" for other userids
			   KhachHangDAO dao = new KhachHangDAO();
			   dao.update(bid, "User");

			   // Redirect to XuLyUser after update
			   response.sendRedirect("XuLyAdmin");
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
		  if (auth.getUserName() == null) { // User not authenticated, redirect to the
		 response.sendRedirect("DangNhap.jsp"); return;  }
		 
String role = "User";
		
		KhachHangDAO dao = new KhachHangDAO();
		List<String> e = dao.getEmailByRole(role);
		String e2 = e.stream().collect(Collectors.joining(", "));
		dao.deleteUser2(role);
		Email.sendEmail2(e2, "Thông báo bị xóa tài khoản", "Tài khoản của bạn và những người dùng khác đã bị admin xóa");
		response.sendRedirect("XuLyUser");
	
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
	    if (auth == null) {
	        // User not authenticated, redirect to the login page
	        response.sendRedirect("DangNhap.jsp");
	        return; // Stop further processing
	    }
String bid = request.getParameter("userid");
		
		KhachHangDAO dao = new KhachHangDAO();
		String e = dao.getEmailbyUserId(bid);
		dao.deleteUser(bid);
		
		Email.sendEmail(e, "Thông báo bị xóa tài khoản", "Tài khoản của bạn đã bị admin xóa");
		response.sendRedirect("XuLyUser");
		
		
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
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		String proid = request.getParameter("productId");
//		String proname = request.getParameter("productName");
//		String prodes = request.getParameter("productDes");
//		String proImg = request.getParameter("productImg");
//		String img = "assets/img/";
//		double proPri = Double.parseDouble(request.getParameter("productPrice"));
//		String proCaid = request.getParameter("productCaid");
//		String error = ""; 
//		String url = "";
//		
//		if(!proImg.contains("assets/img/")) {
//			img += proImg;
//		}
//		ProductDAO dao = new ProductDAO();
//		if(dao.checkProductExists(proid)) {
//			error+="Id sản phẩm đã tồn tại. Vui lòng chọn Id khác.";
//		}
//		if (!error.isEmpty() & url != null) {
//			request.setAttribute("error", error);
//			url = "/AddProduct.jsp";
//			
//			    getServletContext().getRequestDispatcher(url).forward(request, response);
//			
//		}else {
//		dao.themProduct(proid, proname, prodes, img,proPri,2,proCaid);
//		
//		response.sendRedirect("XuLyAdminProduct");
//		}
		doGet(request, response);
	}

}

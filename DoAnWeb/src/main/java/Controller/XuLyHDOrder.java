package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderDAO;
import DAO.ProductDAO;
import Model.Checkout;
import Model.KhachHang;
import Model.Order;
import Model.Product;

/**
 * Servlet implementation class XuLyHDOrder
 */
@WebServlet("/XuLyHDOrder")
public class XuLyHDOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyHDOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		 KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
		    if (auth == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
		String action = request.getParameter("action") == null ? "" : request.getParameter("action");

		switch (action) {
		case "A0":
			A0(request, response);
			break;
		case "A1":
			A1(request, response);
			break;
		case "MQuantity":
			MQuantity(request, response);
			break;
		case "LQuantity":
			LQuantity(request, response);
			break;
		case "MMoney":
			MMoney(request, response);
			break;
		case "LMoney":
			LMoney(request, response);
			break;
		case "L100A0":
			L100A0(request, response);
			break;
		case "L100300A0":
			L100300A0(request, response);
			break;
		case "H300A0":
			H300A0(request, response);
			break;
		case "L100A1":
			L100A1(request, response);
			break;
		case "L100300A1":
			L100300A1(request, response);
			break;
		case "H300A1":
			H300A1(request, response);
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
		case "deleteCheckOut":
			deleteCheckOut(request, response);
			break;
		case "deleteallCheckOut":
			deleteallCheckOut(request, response);
			break;
		
		}

	}

    private void deleteall(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	OrderDAO dao = new OrderDAO();
		dao.deleteOrderByStatus(0);
		
		response.sendRedirect("XuLyAdminOrder");
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String orderid = request.getParameter("orderid");
		OrderDAO dao = new OrderDAO();
		dao.deleteOrderByOrderid2(orderid);
		
		response.sendRedirect("XuLyAdminOrder");

		
	}

	private void A0(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	OrderDAO dao = new OrderDAO();
    	
    	List<Order> list = dao.getAllOrderByAdmin(0);
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("OrderA0", list);
    	String url = "/WEB-INF/Web/AdminOrderTemplate.jsp";
		
    
	if (url != null) { // Check if URL is valid
	    getServletContext().getRequestDispatcher(url).forward(request, response);
	    
	}
    	
    	// Forward to the Shop.jsp instead of redirecting
    	request.getRequestDispatcher("/AdminOrderTemplate.jsp").forward(request, response);
    	
    }
    private void MQuantity(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	OrderDAO dao = new OrderDAO();
    	
    	List<Order> list = dao.getAllQuantitySellDESC(1);
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("listsell", list);
    	
    	String url = "/WEB-INF/Web/indexforadmin.jsp";
		
        
    	if (url != null) { // Check if URL is valid
    	    getServletContext().getRequestDispatcher(url).forward(request, response);
    	    
    	}
        
    	
    }
    private void LQuantity(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	OrderDAO dao = new OrderDAO();
    	
    	List<Order> list = dao.getAllQuantitySellASC(1);
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("listsell", list);
    	
String url = "/WEB-INF/Web/indexforadmin.jsp";
		
        
    	if (url != null) { // Check if URL is valid
    	    getServletContext().getRequestDispatcher(url).forward(request, response);
    	    
    	}
    	
    }
    private void MMoney(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	OrderDAO dao = new OrderDAO();
    	
    	List<Order> list = dao.getAllSellByAdminDesc(1);
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("listsell", list);
    	
String url = "/WEB-INF/Web/indexforadmin.jsp";
		
        
    	if (url != null) { // Check if URL is valid
    	    getServletContext().getRequestDispatcher(url).forward(request, response);
    	    
    	}
    	
    }
    private void LMoney(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	OrderDAO dao = new OrderDAO();
    	
    	List<Order> list = dao.getAllSellByAdminAsc(1);
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("listsell", list);
    	
String url = "/WEB-INF/Web/indexforadmin.jsp";
		
        
    	if (url != null) { // Check if URL is valid
    	    getServletContext().getRequestDispatcher(url).forward(request, response);
    	    
    	}
    	
    }
    private void A1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	OrderDAO dao = new OrderDAO();
    	
    	List<Checkout> list = dao.getAllCheckout();
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("CheckOuts", list);
    	
String url = "/WEB-INF/Web/AdminOrderCheckOutTemplate.jsp";
		
        
    	if (url != null) { // Check if URL is valid
    	    getServletContext().getRequestDispatcher(url).forward(request, response);
    	    
    	}
    	
    }
	private void L100A0(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		OrderDAO dao = new OrderDAO();
		  
		  List<Order> list = dao.getAllOrderLower100(0);
		
		HttpSession session = request.getSession();
	    session.setAttribute("OrderA0", list);

	    String url = "/WEB-INF/Web/AdminOrderTemplate.jsp";
		
	    
		if (url != null) { // Check if URL is valid
		    getServletContext().getRequestDispatcher(url).forward(request, response);
		    
		}
	    
		
	}
	private void L100300A0(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		OrderDAO dao = new OrderDAO();
		
		List<Order> list = dao.getAllOrderFrom100to300(0);
		
		HttpSession session = request.getSession();
		session.setAttribute("OrderA0", list);
		
		String url = "/WEB-INF/Web/AdminOrderTemplate.jsp";
		
	    
		if (url != null) { // Check if URL is valid
		    getServletContext().getRequestDispatcher(url).forward(request, response);
		    
		}
	    
		
	}
	private void H300A0(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		OrderDAO dao = new OrderDAO();
		
		List<Order> list = dao.getAllOrderHigher300(0);
		
		HttpSession session = request.getSession();
		session.setAttribute("OrderA0", list);
		
		String url = "/WEB-INF/Web/AdminOrderTemplate.jsp";
		
	    
		if (url != null) { // Check if URL is valid
		    getServletContext().getRequestDispatcher(url).forward(request, response);
		    
		}
	    
		
	}
	private void L100A1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		OrderDAO dao = new OrderDAO();
		
		List<Checkout> list = dao.getAllCheckOutLower100();
		
		HttpSession session = request.getSession();
		session.setAttribute("CheckOuts", list);
		
		String url = "/WEB-INF/Web/AdminOrderCheckOutTemplate.jsp";
		
	    
		if (url != null) { // Check if URL is valid
		    getServletContext().getRequestDispatcher(url).forward(request, response);
		    
		}
	    
		
	}
	private void L100300A1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		OrderDAO dao = new OrderDAO();
		
		List<Checkout> list = dao.getAllCheckOutFrom100to300();
		
		HttpSession session = request.getSession();
		session.setAttribute("CheckOuts", list);
		
String url = "/WEB-INF/Web/AdminOrderCheckOutTemplate.jsp";
		
	    
		if (url != null) { // Check if URL is valid
		    getServletContext().getRequestDispatcher(url).forward(request, response);
		    
		}
		
	}
	private void H300A1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		OrderDAO dao = new OrderDAO();
		
		List<Checkout> list = dao.getAllCheckOutHigher100();
		
		HttpSession session = request.getSession();
		session.setAttribute("CheckOuts", list);
		
String url = "/WEB-INF/Web/AdminOrderCheckOutTemplate.jsp";
		
	    
		if (url != null) { // Check if URL is valid
		    getServletContext().getRequestDispatcher(url).forward(request, response);
		    
		}
		
	}

	private void AtoZ(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ProductDAO dao = new ProductDAO();
		  
		  List<Product> list = dao.getAllProductFromAtoZ();
		
		HttpSession session = request.getSession();
	    session.setAttribute("listProduct", list);

	    // Forward to the Shop.jsp instead of redirecting
	    request.getRequestDispatcher("/Shop.jsp").forward(request, response);
		
		
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
			url = "/AddProductTemplate.jsp";
			
			    getServletContext().getRequestDispatcher(url).forward(request, response);
			
		}else {
		dao.themProduct(proid, proname, prodes, img,proPri,2,proCaid);
		
		response.sendRedirect("XuLyAdminOrderCheckOut");
		}
		
	}
	

	private void deleteallCheckOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    
	    
		
		OrderDAO dao = new OrderDAO();

		dao.deleteAllCheckOut();
		response.sendRedirect("XuLyAdminOrderCheckOut");
		
	}
	
	private void deleteCheckOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    String username = request.getParameter("username");
	    String orderid = request.getParameter("orderid");
	    if (username == null) {
	        // User not authenticated, redirect to the login page
	        response.sendRedirect("DangNhap.jsp");
	        return; // Stop further processing
	    }
		
		OrderDAO dao = new OrderDAO();

		dao.deleteOrderByOrderid(orderid, username);
		response.sendRedirect("XuLyAdminOrderCheckOut");
		
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

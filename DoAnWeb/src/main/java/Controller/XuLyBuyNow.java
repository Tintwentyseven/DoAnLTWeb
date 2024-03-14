package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OrderDAO;
import DAO.ProductDAO;
import Model.Cart;
import Model.KhachHang;
import Model.Order;
import Model.OrderDetail;

/**
 * Servlet implementation class XuLyBuyNow
 */
@WebServlet("/XuLyBuyNow")
public class XuLyBuyNow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyBuyNow() {
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
		/*
		 * try { PrintWriter out = response.getWriter(); SimpleDateFormat formatter =
		 * new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); Date date = new Date(); String
		 * id = request.getParameter("productid");
		 * 
		 * KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
		 * if(auth!= null) { Order order = new Order();
		 * order.setUsername(auth.getUserName()); order.setEmail(auth.getEmail());
		 * order.setDate(formatter.format(date));
		 * 
		 * 
		 * List<OrderDetail> o = new ArrayList<OrderDetail>(); for(OrderDetail o1: o) {
		 * o1 } OrderDAO dao = new OrderDAO(); boolean result = dao.themOrder(order);
		 * boolean results = dao.themOrderDetail(order); if(result) {
		 * response.sendRedirect("checkout.jsp"); }else { out.println("Order failed"); }
		 * }else { response.sendRedirect("DangNhap.jsp"); }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * } catch (Exception e) { e.printStackTrace(); // Handle the exception (e.g.,
		 * log the error, show a user-friendly message) }
		 */
	}

}

package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhachHangDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import Model.Checkout;
import Model.Email;
import Model.Product;

/**
 * Servlet implementation class XuLyHDOrderUpdateStatus
 */
@WebServlet("/XuLyHDOrderUpdateStatus")
public class XuLyHDOrderUpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XuLyHDOrderUpdateStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		String id = request.getParameter("orderid");
		OrderDAO dao = new OrderDAO();
		Checkout pr = dao.getAllCheckOutById(id);
		String url = "";
		HttpSession session = request.getSession(true);
		if (pr != null) {

			session.setAttribute("orderE", pr);

			url = "/WEB-INF/Web/UpdateStatusOrderTemplate.jsp";

		}
		if (url != null) { // Check if URL is valid
			getServletContext().getRequestDispatcher(url).forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

//		  KhachHang auth = (KhachHang) request.getSession().getAttribute("user"); if
//		  (auth == null) { // User not authenticated, redirect to the login page
//		  response.sendRedirect("DangNhap.jsp"); return; // Stop further processing }
//		  }
		String orderid = request.getParameter("orderId");
		String status = request.getParameter("statusorder");

		OrderDAO dao = new OrderDAO();
		KhachHangDAO dao2 = new KhachHangDAO();

		dao.updateStatus(orderid, status);

		response.sendRedirect("XuLyAdminOrderCheckOut");
	}
	public static void main(String[] args) {
		System.out.println("Tin");
	}

}

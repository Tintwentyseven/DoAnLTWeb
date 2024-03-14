package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cart;
import Model.KhachHang;

/**
 * Servlet implementation class XuLyRemoveAllFromCart
 */
@WebServlet("/XuLyRemoveAllFromCart")
public class XuLyRemoveAllFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyRemoveAllFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
		    if (auth == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
		try (PrintWriter out = response.getWriter()) {
		        // No need to check for bookId as we're clearing the entire cart

		        ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

		        if (cartList != null) {
		            // Clear the cart list directly
		            cartList.clear();

		            // Ensure the updated cart list is saved in the session
		            request.getSession().setAttribute("cart-list", cartList);
		        }

		        response.sendRedirect("XuLyToCart");
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

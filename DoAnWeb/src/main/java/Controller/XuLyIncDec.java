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
 * Servlet implementation class XuLyIncDec
 */
@WebServlet("/XuLyIncDec")
public class XuLyIncDec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyIncDec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void
    
    doGet(HttpServletRequest request, HttpServletResponse response)

            
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
	    if (auth.getUserName() == null) {
	        // User not authenticated, redirect to the login page
	        response.sendRedirect("DangNhap.jsp");
	        return; // Stop further processing
	    }
    try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String idParam = request.getParameter("id"); // Get the ID as a string

            if (action != null && idParam != null) {
                int id = Integer.parseInt(idParam.substring(idParam.length() - 1)); // Extract the last character as a number
                ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

                if (action.equals("inc")) {
                    for (Cart c : cart_list) {
                        if (c.getId().endsWith(idParam)) { // Compare ID strings
                            int quantity = c.getQuantity() + 1; // Increment quantity
                            c.setQuantity(quantity);
                            response.sendRedirect("XuLyToCart");
                            break;
                        }
                    }
                } else if (action.equals("dec")) {
                    for (Cart c : cart_list) {
                        if (c.getId().endsWith(idParam) && c.getQuantity() > 1) {
                            int quantity = c.getQuantity() - 1; // Decrement quantity
                            c.setQuantity(quantity);
                            break;
                        }
                    }
                    response.sendRedirect("XuLyToCart");
                }
            } else {
                response.sendRedirect("XuLyToCart");
            }
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

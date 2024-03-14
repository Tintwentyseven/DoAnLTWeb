package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cart;
import Model.KhachHang;

/**
 * Servlet implementation class XuLyRemoveFromCart
 */
@WebServlet("/XuLyRemoveFromCart")
public class XuLyRemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyRemoveFromCart() {
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
        request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
        KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
	    if (auth == null) {
	        // User not authenticated, redirect to the login page
	        response.sendRedirect("DangNhap.jsp");
	        return; // Stop further processing
	    }
    try (PrintWriter out = response.getWriter()) {
            String bookId = request.getParameter("id");

            if (bookId != null) {
                ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

                if (cartList != null) {
                    // Use an Iterator to avoid ConcurrentModificationException
                    Iterator<Cart> iter = cartList.iterator();
                    while (iter.hasNext()) {
                        Cart c = iter.next();
                        if (c.getId().equals(bookId)) {  // Use .equals() for string comparison
                            iter.remove();
                            break;
                        }
                    }

                    // Ensure the updated cart list is saved in the session
                    request.getSession().setAttribute("cart-list", cartList);
                }
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

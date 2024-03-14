package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cart;
import Model.KhachHang;

/**
 * Servlet implementation class XuLyCart
 */
@WebServlet("/Addtocart")
public class XuLyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XuLyCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected
	 
	void
	 
	doGet(HttpServletRequest request, HttpServletResponse response)

	        
	throws ServletException, IOException {
		 KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
		    if (auth == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
	   
	    try (PrintWriter out = response.getWriter()) {
	        String id = request.getParameter("productid");

	        HttpSession session = request.getSession();
	        ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");

	        if (cartList == null) {
	            cartList = new ArrayList<>(); // Create a new list if it doesn't exist
	            session.setAttribute("cart-list", cartList);
	            
	        }

	        boolean productFound = false;
	        for (Cart cartItem : cartList) {
	            if (cartItem.getId().equals(id)) { // Use equals() for string comparison
	                productFound = true;
	                 // Increment quantity
	                out.println("Product exist");
	                break; // Exit the loop as product is found
	            }
	        }

	        if (!productFound) {
	            Cart cm = new Cart();
	            cm.setId(id);
	            cm.setQuantity(1);
	            cartList.add(cm);
	            response.sendRedirect("XuLyProduct");
	        }

	        // Print cart contents
	        for (Cart c : cartList) {
	            out.println(c.getId());
	        }
	    }
	}

        
		// Extract product ID from request parameter
		/*
		 * HttpSession session = request.getSession(true); String productId =
		 * request.getParameter("detailid");
		 * 
		 * // Check login status KhachHang customer = (KhachHang)
		 * session.getAttribute("user");
		 * 
		 * if (customer != null) { // Customer is logged in, add product to cart try {
		 * new CartDAO().addToCart(productId); response.sendRedirect("cart.jsp"); }
		 * catch (Exception e) { // Handle error e.printStackTrace(); } } else { //
		 * Customer is not logged in, redirect to login page
		 * response.sendRedirect("DangNhap.jsp"); }
		 */
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//                response.sendRedirect("Shop.jsp");
////            } else {
////                cartList = cart_list;
////
////                boolean exist = false;
////                for (Cart c : cart_list) {
////                    if (c.getId() == id) {
////                        exist = true;
////                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
////                    }
////                }
//
////                if (!exist) {
////                    cartList.add(cm);
////                    response.sendRedirect("Shop.jsp");
////                }
          doGet(request, response);
	}
}
/*
 * protected void Put(HttpServletRequest req, HttpServletResponse resp) throws
 * ServletException, IOException { HttpSession session = req.getSession();
 * ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
 * String id = req.getParameter("id"); int quanlity =
 * Integer.parseInt(req.getParameter("quanlity")); String e =""; if(quanlity>0){
 * shoppingCart.update(id,quanlity); } else{ e="So luong phai lon hon 0"; }
 * req.setAttribute("error",e); session.setAttribute("cart",shoppingCart);
 * req.getRequestDispatcher("ShopingCartCL?action=get").forward(req,resp); }
 */

/*
 * ProductDAO dao = new ProductDAO(); Product pr =
 * dao.getAllProductById(detailproductid); String quantityValue =
 * request.getParameter("product-quanity");
 * 
 * 
 * 
 * // Calculate the total price int totalPrice = (int)
 * (Integer.parseInt(quantityValue)*pr.getPrice());
 * 
 * // Set the quantity and total price parameters
 * request.setAttribute("quantity", quantityValue);
 * request.setAttribute("totalPrice", totalPrice);
 */
// Redirect to cart.jsp

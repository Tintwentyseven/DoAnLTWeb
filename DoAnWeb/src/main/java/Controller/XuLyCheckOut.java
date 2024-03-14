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

/**
 * Servlet implementation class XuLyCheckOut
 */
@WebServlet("/XuLyCheckOut")
public class XuLyCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyCheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
            PrintWriter out = response.getWriter();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            System.out.println(cart_list);

            KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
    	    if (auth == null) {
    	        // User not authenticated, redirect to the login page
    	        response.sendRedirect("DangNhap.jsp");
    	        return; // Stop further processing
    	  
    	    }

            if (cart_list != null && auth != null) {
                OrderDAO dao2 = new OrderDAO();
                ProductDAO dao3 = new ProductDAO();

                for (Cart c : cart_list) {
                    Order order = new Order();
                    Double prices = dao3.getPriceById(c.getId());
                    String proname = dao3.getProNameById(c.getId());
                    order.setUsername(auth.getUserName());
                    order.setEmail(auth.getEmail());
                    order.setProductname(proname);
                    order.setQuantity(c.getQuantity());
                    order.setPrices(prices);
                    order.setTotalprice(c.getQuantity()*prices);
                    order.setDate(formatter.format(date));
                    order.setStatus(0);
                   

                   

                    boolean result = dao2.themOrder(order);

                    if (!result) 
                        // Handle the error, break the loop, or take appropriate action
                        break;
                    }
                

                cart_list.clear();
                response.sendRedirect("XuLyToCheckOut");
            }

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception (e.g., log the error, show a user-friendly message)
        }
	}
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

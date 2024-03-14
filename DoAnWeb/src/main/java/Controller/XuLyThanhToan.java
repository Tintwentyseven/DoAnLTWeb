package Controller;

import java.io.IOException;
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
import Model.Cart;
import Model.Checkout;
import Model.Order;

/**
 * Servlet implementation class XuLyThanhToan
 */
@WebServlet("/XuLyThanhToan")
public class XuLyThanhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyThanhToan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
	    String auth = request.getParameter("username");
	    
	    OrderDAO dao2 = new OrderDAO();
	    List<Order> order_list = dao2.getAllOrder(auth, 0);
	    dao2.updateThanhToan(auth, 1);
	    String country = request.getParameter("c_country");
	    String firstName = request.getParameter("c_fname");
	    String lastName = request.getParameter("c_lname");
	    String companyName = request.getParameter("c_companyname");
	    String address = request.getParameter("c_address");
	    String email = request.getParameter("c_email_address");
	    String phoneNumber = request.getParameter("c_phone");
	    String notes = request.getParameter("c_order_notes");
	    String paymentMethod = request.getParameter("paymentMethod");
		for(Order o:order_list) {
			Checkout ch = new Checkout();
			ch.setUsername(auth);
			ch.setOrderid(o.getOrderid());
			ch.setCountry(country);
			ch.setFirstname(firstName);
			ch.setLastname(lastName);
			ch.setCompanyname(companyName);
			ch.setAddress(address);
			ch.setEmail(email);
			ch.setPhonenumber(phoneNumber);
			ch.setNotes(notes);
			ch.setTransfers(paymentMethod);
            ch.setCheckoutdate(formatter.format(date));
            ch.setStatusch("Đang xử lý");
            boolean result = dao2.themCheckout(ch);
            if (!result) 
                // Handle the error, break the loop, or take appropriate action
                break;
            }
			
		

	    response.sendRedirect("XuLyThankYou");

	}

	}



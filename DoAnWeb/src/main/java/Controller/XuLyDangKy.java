package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KhachHangDAO;
import Model.Email;
import Model.KhachHang;


/**
 * Servlet implementation class XuLyDangKy
 */
@WebServlet("/XuLyDangKy")
public class XuLyDangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyDangKy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		String name = request.getParameter("firstname");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		String error="";
		String error1 = "";
		String error2= "";
		String error3= "";
		String error4= "";
		String error5= "";
		String error6= "";
		String role = "User";
		String url = null;
		
        KhachHangDAO khachHangDAO = new KhachHangDAO();

		// Kiểm tra tên đăng nhập
		if (khachHangDAO.checkUsernameExists(username)) {
		    error+="Tài khoản đã tồn tại. Vui lòng chọn tên tài khoản khác.";
		}
		if(username.length() < 6) {
			error5+= "Tên đăng nhập phải từ 6 kí tự trở lên";
		}
			if (username.contains(" ")) {
				error6 += "Tên đăng nhập không được chứa khoảng cách";
	

		}
		if(pass.length() < 6) {
			error3+= "Mật khẩu phải từ 6 kí tự trở lên";
		}
		if (pass.contains(" ")) {
		    error4 += "Mật khẩu không được chứa khoảng cách";
		}

		// Kiểm tra pass nhập lại
		if (!repass.equals(pass)) {
		    error1+="Mật khẩu nhập lại không khớp, vui lòng nhập lại";
		}

		// Kiểm tra số điện thoại
		for (char c : telephone.toCharArray()) {
		    if (!Character.isDigit(c)) {
		        error2+="Số điện thoại không được chứa chữ cái.";
		        break;
		    }
		}

		// Nếu có lỗi
		if (!error.isEmpty()) {
		    request.setAttribute("error", error);
		    url = "/DangKy.jsp";
		}
		else if (!error1.isEmpty()) {
		   request.setAttribute("error1", error1);
		    	url = "/DangKy.jsp";
		}
		else if (!error2.isEmpty()) {
			request.setAttribute("error2", error2);
			url = "/DangKy.jsp";
		}
		else if (!error3.isEmpty()) {
			request.setAttribute("error3", error3);
			url = "/DangKy.jsp";
		}
		else if (!error4.isEmpty()) {
			request.setAttribute("error4", error);
			url = "/DangKy.jsp";
		}
		else if (!error5.isEmpty()) {
			request.setAttribute("error5", error5);
			url = "/DangKy.jsp";
		}
		else if (!error6.isEmpty()) {
		    		request.setAttribute("error6", error6);
		    		url = "/DangKy.jsp";
		
		} else {
		    KhachHang kh = new KhachHang(username, pass, name, email, telephone, address, role);
		    khachHangDAO.themTaiKhoan(kh);
		    Email.sendEmail(email, "Thông báo đăng kí thành công", "Xin chào bạn, bạn đã đăng kí thành công trang web của chúng tôi");
		    url = "/DangNhap.jsp";
		}

		if (url != null) { // Check if URL is valid
		    getServletContext().getRequestDispatcher(url).forward(request, response);
		} /*
			 * else { // Handle invalid URL }
			 */
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

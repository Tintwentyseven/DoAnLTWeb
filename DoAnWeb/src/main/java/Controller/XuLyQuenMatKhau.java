package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import DAO.KhachHangDAO;
import Model.KhachHang;
import Model.Email;

/**
 * Servlet implementation class XuLyQuenMatKhau
 */
@WebServlet("/XuLyQuenMatKhau")
public class XuLyQuenMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyQuenMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        String sendemail = request.getParameter("email");
        String error1 = "";
        String error2 = "";
        String url = "";
        String message = "";
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        
       
       


        if (sendemail != null && sendemail.equals("21130565@st.hcmuaf.edu.vn")) {
            error1 = "Mail này không được gửi đi";
        } else if (!khachHangDAO.checkEmailExists(sendemail) && !sendemail.equals("21130565@st.hcmuaf.edu.vn")) {
            error2 = "Email này chưa được đăng kí. Vui lòng chọn email khác";
        } else {
            String password = khachHangDAO.takePass(sendemail);
           
            if (password != null) {
                if (Email.sendEmail(sendemail, "Đây là mật khẩu của bạn", "Xin chào bạn, Password của bạn là: " + password)) {
                    message = "Mật khẩu đã được gửi đến email của bạn.";
                } else {
                    error1 = "Có lỗi xảy ra trong quá trình gửi email. Vui lòng thử lại sau.";
                }
            } else {
                error1 = "Không thể lấy mật khẩu cho email này.";
            }
        }

        if (!error1.isEmpty()) {
            request.setAttribute("error1", error1);
            url = "/WEB-INF/Web/quenmatkhau.jsp";
        } else if (!error2.isEmpty()) {
            request.setAttribute("error2", error2);
            url = "/WEB-INF/Web/quenmatkhau.jsp";
        } else {
            request.setAttribute("message", message);
            url = "/WEB-INF/Web/quenmatkhau.jsp"; // Change to success page
        }

        if (url != null) {
            getServletContext().getRequestDispatcher(url).forward(request, response);
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

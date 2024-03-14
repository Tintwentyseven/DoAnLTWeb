package Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mysql.cj.Session;
import com.mysql.cj.protocol.Message;

import DAO.KhachHangDAO;
import Model.Email;
import Model.KhachHang;

/**
 * Servlet implementation class XuLyGuiMailChoAdmin
 */
@WebServlet("/XuLyGuiMailChoAdmin")
public class XuLyGuiMailChoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyGuiMailChoAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8"); KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
	    if (auth == null) {
	        // User not authenticated, redirect to the login page
	        response.sendRedirect("DangNhap.jsp");
	        return; // Stop further processing
	    }
   
		
	        String email = request.getParameter("email");
	        String name = request.getParameter("name");
	        String to = "21130565@st.hcmuaf.edu.vn";
	        String subject = request.getParameter("subject");
	        String subject2 = "Cảm ơn " + name + " vì đã gửi tiêu đề " + subject + " cho chúng tôi";
	        String body = request.getParameter("message");
	        String body2 = "Chúng tôi đã nhận được ý kiến của bạn là " + body + " .Chúng tôi sẽ luôn nỗ lực từ những ý kiến của bạn " + "<table>\r\n"
	        		+ "    <tbody>\r\n"
	        		+ "        <tr>\r\n"
	        		+ "            <td>\r\n"
	        		+ "                <p>Sincerely,</p>\r\n"
	        		+ "                <p>\r\n"
	        		+ "                    <img\r\n"
	        		+ "                      src=\"https://d36urhup7zbd7q.cloudfront.net/anonymous_user/no_sig_167800497127/signoff.gif?ck=1678004971.27\"\r\n"
	        		+ "                      alt=\"Phạm Trung Tín\">\r\n"
	        		+ "                </p>\r\n"
	        		+ "            </td>\r\n"
	        		+ "        </tr>\r\n"
	        		+ "    </tbody>\r\n"
	        		+ "</table>";

	        String error1 = "";
	        String error2 = "";
	        String url = "";
	        String message = "";
	        KhachHangDAO khachHangDAO = new KhachHangDAO();

	        if (email != null && email.equals("21130565@st.hcmuaf.edu.vn")) {
	            error1 = "Mail này không được gửi đi";
	        } else if (!khachHangDAO.checkEmailExists(email) && !email.equals("21130565@st.hcmuaf.edu.vn")) {
	            error2 = "Email này chưa được đăng kí. Vui lòng chọn email khác";
	        } else {
	            String passwordu = khachHangDAO.takePass(email);
	           
	            if (passwordu != null) {
	                
						if (Email.sendEmail(email, subject2, body2)) {
						    message = "Mật khẩu đã được gửi đến email của bạn.";
						} else {
						    error1 = "Có lỗi xảy ra trong quá trình gửi email. Vui lòng thử lại sau.";
						}
					
						// TODO Auto-generated catch block
						
					
	            } else {
	                error1 = "Không thể lấy mật khẩu cho email này.";
	            }
	        }
	        if (!error1.isEmpty()) {
	            request.setAttribute("error1", error1);
	            url = "/WEB-INF/Web/contact.jsp";
	        } else if (!error2.isEmpty()) {
	            request.setAttribute("error2", error2);
	            url = "/WEB-INF/Web/contact.jsp";
	        } else {
	            request.setAttribute("message", message);
	            url = "/WEB-INF/Web/contact.jsp"; // Change to success page
	        }

	        if (url != null) {
	            getServletContext().getRequestDispatcher(url).forward(request, response);
	        }

	        }

	        // Thực hiện chuyển hướng hoặc hiển thị thông báo dựa trên kết quả gửi email
	    
	
	}



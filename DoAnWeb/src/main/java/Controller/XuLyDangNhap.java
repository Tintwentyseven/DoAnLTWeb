package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhachHangDAO;
import DAO.OrderDAO;
import Model.KhachHang;
import Model.Order;

/**
 * Servlet implementation class XuLyDangNhap
 */
@WebServlet("/XuLyDangNhap")
public class XuLyDangNhap extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyDangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String error = "";
        String url = "";

        // Initialize the login attempt counter
        int loginAttempts = 0;

        // Check if the user has already tried to log in unsuccessfully
        HttpSession session = request.getSession();
        if (session != null) {
            Integer loginAttemptsAttribute = (Integer) session.getAttribute("loginAttempts");
            if (loginAttemptsAttribute != null) {
                loginAttempts = loginAttemptsAttribute;
            }
        }

        // Set session timeout to 10 seconds
        session.setMaxInactiveInterval(30*60);

        String kh1 = new KhachHangDAO().takeRole(username);
        KhachHang kh = new KhachHangDAO().layThongTinTaiKhoan(username);
        boolean kh2 = new KhachHangDAO().kiemTraDangNhap(username, pass);
        KhachHangDAO dao = new KhachHangDAO();

        if (kh1 != null) {
        	if(kh2) {
        		dao.updateView();
        	}
            if (kh2 && kh1.equals("Admin")) {
                loginAttempts = 0; // Reset the login attempt counter on successful login
                OrderDAO dao2 = new OrderDAO();
                int totalsell = dao2.getTotalProduct(1);
                List<Order> list2 = dao2.getAllOrderByAdmin(1);
                session.setAttribute("userloginA", kh);
                session.setAttribute("listsell", list2);
                session.setAttribute("totalsell", totalsell);
                url = "/WEB-INF/Web/indexforadmin.jsp";
            } else if (kh2 && kh1.equals("User")) {
                loginAttempts = 0; // Reset the login attempt counter on successful login
                session.setAttribute("user", kh);

                /* Xử lý view */
              
                
                int views = dao.getView();
                String formatted = String.format("%05d", views);
                request.setAttribute("views", formatted);
                
                url = "/WEB-INF/Web/index.jsp";
            }
        } else {
            loginAttempts++; // Increment the login attempt counter on failed login
            error = "Tên hoặc mật khẩu không đúng";
            System.out.println("Tên hoặc mật khẩu không đúng");
            url = "/DangNhap.jsp";
            error += ". Số lần đăng nhập không thành công: " + loginAttempts;
        }

        // Update the login attempt counter in the session
        session.setAttribute("loginAttempts", loginAttempts);
        request.setAttribute("error", error);

        if (url != null) { // Check if URL is valid
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

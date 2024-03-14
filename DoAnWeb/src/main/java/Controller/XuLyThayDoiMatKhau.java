package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhachHangDAO;

/**
 * Servlet implementation class XuLyThayDoiMatKhau
 */
@WebServlet("/XuLyThayDoiMatKhau")
public class XuLyThayDoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyThayDoiMatKhau() {
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
        String passcu = request.getParameter("oldpass");
        String passmoi = request.getParameter("newpass");
        String error1 = "";
        String error2 = "";
        String error3 = "";
        String url = "";
        String message = "";
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        HttpSession session = request.getSession();

        boolean kh2 = khachHangDAO.kiemTraDangNhap(username, passcu);

        if (!kh2) {
            error1 = "Tên hoặc mật khẩu không đúng";
            System.out.println("Tên hoặc mật khẩu không đúng");
        } else if (kh2 && passcu.equals(passmoi)) {
            error2 = "Mật khẩu mới và cũ không được giống nhau";
        } else if (kh2 && khachHangDAO.takeRole(username).equals("Admin")) { // Check role before password update
            error3 = "Tên đăng nhập này thuộc về admin";
        } else {
            // Update password and username (assuming both are intended to be updated)
            khachHangDAO.updateMatKhauTheoTenDangNhap(username, passmoi); // Updated method name
            url = "/DangNhap.jsp";
        }

        if (!error1.isEmpty()) {
            request.setAttribute("error1", error1);
        } else if (!error2.isEmpty()) {
            request.setAttribute("error2", error2);
        } else if (!error3.isEmpty()) {
            request.setAttribute("error3", error3);
        }

        url = url.isEmpty() ? "/WEB-INF/Web/thaydoimatkhau.jsp" : url; // Default to thaydoimatkhau.jsp if no errors
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

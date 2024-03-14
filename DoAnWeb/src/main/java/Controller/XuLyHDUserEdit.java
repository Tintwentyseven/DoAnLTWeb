package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhachHangDAO;
import Model.KhachHang;
import Model.User;

/**
 * Servlet implementation class XuLyHDUserEdit
 */
@WebServlet("/XuLyHDUserEdit")
public class XuLyHDUserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyHDUserEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("Adminid"); 
		  KhachHangDAO dao = new KhachHangDAO();
		 User pr2 = dao.layThongTinUser2(id);
		  String url="";
		  HttpSession session = request.getSession(true);
		  if(pr2!=null) {
				
				session.setAttribute("euser", pr2);
				
				url = "/WEB-INF/Web/EditUserTemplate.jsp";
				
		        }
				if (url != null) { // Check if URL is valid
				    getServletContext().getRequestDispatcher(url).forward(request, response);
				    
				}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/*
		 * KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
		 * if (auth == null) { // User not authenticated, redirect to the login page
		 * response.sendRedirect("DangNhap.jsp"); return; // Stop further processing }
		 */
		  String url="";

		String sid = request.getParameter("useridE");
		String username = request.getParameter("usernameE");
		String pass = request.getParameter("passE");
		String name = request.getParameter("firstnameE");
		String email = request.getParameter("emailE");
		String telephone = request.getParameter("telephoneE");
		String address = request.getParameter("addressE");
		KhachHangDAO dao = new KhachHangDAO();
		dao.updateUser(sid, username, pass, name,email, telephone, address);
			
			    
		
		
		response.sendRedirect("XuLyUser");
	}
}

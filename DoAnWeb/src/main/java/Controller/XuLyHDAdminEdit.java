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
 * Servlet implementation class XuLyHDAdminEdit
 */
@WebServlet("/XuLyHDAdminEdit")
public class XuLyHDAdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyHDAdminEdit() {
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
		 User pr = dao.layThongTinUser2(id);
		  String url="";
		  HttpSession session = request.getSession(true);
		  if(pr!=null) {
				
				session.setAttribute("admin", pr);
				
				url = "/WEB-INF/Web/EditAdminTemplate.jsp";
				
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
	    
		String sid = request.getParameter("useridA");
		String username = request.getParameter("usernameA");
		String pass = request.getParameter("passA");
		String name = request.getParameter("firstnameA");
		String email = request.getParameter("emailA");
		String telephone = request.getParameter("telephoneA");
		String address = request.getParameter("addressA");
		KhachHangDAO dao = new KhachHangDAO();
		dao.updateUser(sid, username, pass, name,email, telephone, address);
		
		response.sendRedirect("XuLyAdmin");
		
	}
	}



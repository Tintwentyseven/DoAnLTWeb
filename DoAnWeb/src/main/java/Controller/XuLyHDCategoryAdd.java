package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import Model.KhachHang;

/**
 * Servlet implementation class XuLyHDCategoryAdd
 */
@WebServlet("/XuLyHDCategoryAdd")
public class XuLyHDCategoryAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyHDCategoryAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Web/AddCategoryTemplate.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  request.setCharacterEncoding("utf-8");
		  response.setCharacterEncoding("utf-8");
			/*
			 * HttpSession session = request.getSession(false); // Get existing session
			 * without creating a new one
			 * 
			 * if (session == null || session.getAttribute("userloginA") == null) { // User
			 * not authenticated, redirect to the login page
			 * response.sendRedirect("DangNhap.jsp"); return; // Stop further processing }
			 */
		  KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
		    if (auth == null) {
		        // User not authenticated, redirect to the login page
		        response.sendRedirect("DangNhap.jsp");
		        return; // Stop further processing
		    }
		String caid = request.getParameter("caId");
		String caname = request.getParameter("caName");
		
		String error = ""; 
		
		String url = "";
		
		
		CategoryDAO dao = new CategoryDAO();
		if(dao.checkCategoryExists(caid)) {
			error+="Id danh mục đã tồn tại. Vui lòng chọn Id khác.";
		}
		
		if (!error.isEmpty()) {
		    request.setAttribute("error", error);
		    url = "/WEB-INF/Web/AddCategoryTemplate.jsp";
		}
		
			
		else {
		dao.themCategory(caid, caname);
		
		response.sendRedirect("XuLyAdminCategory");
		}
		
	}

}

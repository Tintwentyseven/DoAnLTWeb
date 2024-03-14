package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import Model.Categorys;
import Model.KhachHang;


/**
 * Servlet implementation class XuLyHDCategoryEdit
 */
@WebServlet("/XuLyHDCategoryEdit")
public class XuLyHDCategoryEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyHDCategoryEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String id = request.getParameter("editcaid"); 
		  CategoryDAO dao = new CategoryDAO();
		  Categorys list = dao.getAllCatById(id);
		  String url="";
		  HttpSession session = request.getSession(true);
		  if(list!=null) {
				
				session.setAttribute("categoryE", list);
				
				url = "/WEB-INF/Web/EditCategoryTemplate.jsp";
				
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
		 
		String caid = request.getParameter("caId");
		String caname = request.getParameter("caName");
		
		String error = ""; 
		
		String url = "";
		
		
		CategoryDAO dao = new CategoryDAO();
		
		
		
		
			
		
		
			dao.updateCategory(caid,caname);
		
		
		response.sendRedirect("XuLyAdminCategory");
		}
		
	}




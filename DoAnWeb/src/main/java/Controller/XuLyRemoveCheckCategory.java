package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import DAO.ProductDAO;

/**
 * Servlet implementation class XuLyRemoveCheckCategory
 */
@WebServlet("/XuLyRemoveCheckCategory")
public class XuLyRemoveCheckCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyRemoveCheckCategory() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder categoryid = new StringBuilder();
		 for(String ca:request.getParameterValues("selectedCategorys")) {
			 categoryid.append("'").append(ca).append("',");
		 }
		 categoryid.deleteCharAt(categoryid.length()-1);
		 CategoryDAO dao = new CategoryDAO();
		 ProductDAO dao2 = new ProductDAO();
		 dao.deleteCategorys(categoryid);
		 dao.deleteCategoryProducts(categoryid);
		 response.sendRedirect("XuLyAdminCategory");
	}

}

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Model.Categorys;
import Model.KhachHang;
import Model.Product;


/**
 * Servlet implementation class XuLyProduct
 */
@WebServlet(name = "XuLyProduct", urlPatterns = {"/XuLyProduct"})
public class XuLyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	
		  
		  // Forward the request to Shop.jsp
		  
	        
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	/* response.setContentType("text/html;charset=UTF-8"); */
   	 KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
	    if (auth.getUserName() == null) {
	        // User not authenticated, redirect to the login page
	        response.sendRedirect("DangNhap.jsp");
	        return; // Stop further processing
	    }
		  ProductDAO dao = new ProductDAO();
		  CategoryDAO dao2 = new CategoryDAO();
		  
		  List<Product> list = dao.getAllProduct();
		  HttpSession session = request.getSession();
		  
		  session.setAttribute("listProduct", list);
		  List<Categorys> list2 = dao2.getAllCategory();
		  
		  
		  session.setAttribute("listCa", list2);
		  String lang = request.getParameter("lang");
			
			session.setAttribute("lang", lang);
//			String indexPage =
//					  request.getParameter("indexs"); 
//					  int index = Integer.parseInt(indexPage);
//					  if(indexPage == null) {
//						  index=1;
//					  }
//					  int count = dao.getTotalProduct(); 
//					  int endPage = count/12; 
//					  if(count % 12 !=0) {
//						  endPage++; } 
//					  List<Product> list3 = dao.pagingProduct(index);
					  session.setAttribute("listProduct", list); 
//					  session.setAttribute("endP", endPage);
//					  session.setAttribute("index", index); 
			
			request.getRequestDispatcher("/WEB-INF/Web/Shop.jsp").forward(request, response);
		}
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

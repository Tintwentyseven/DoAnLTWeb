package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Model.KhachHang;

@WebServlet("/XuLyHDProductAdd")
public class XuLyHDProductAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public XuLyHDProductAdd() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("/WEB-INF/Web/AddProductTemplate.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    KhachHang auth = (KhachHang) request.getSession().getAttribute("userloginA");
    if (auth.getUserName() == null) {
        // User not authenticated, redirect to the login page
        response.sendRedirect("DangNhap.jsp");
        return; // Stop further processing
    }

    String proid = request.getParameter("productId");
    String proname = request.getParameter("productName");
    String prodes = request.getParameter("productDes");
    String proImg = request.getParameter("productImg");
    String img = "assets/img/";
    double proPri = Double.parseDouble(request.getParameter("productPrice"));
    String proCaid = request.getParameter("productCaid");
    String error = "";
    String error1 = "";

    if (!proImg.contains("assets/img/")) {
        img += proImg;
    }

    ProductDAO dao = new ProductDAO();
    CategoryDAO dao2 = new CategoryDAO();

    if (dao.checkProductExists(proid)) {
        error += "Id sản phẩm đã tồn tại. Vui lòng chọn Id khác.";
    }

    if (!dao2.checkCategoryExists(proCaid)) {
        error1 += "Vui lòng chọn categoryId khác vì giá trị này chưa xuất hiện";
    }

    if (!error.isEmpty()) {
        request.setAttribute("error", error);
        request.getRequestDispatcher("/WEB-INF/Web/AddProductTemplate.jsp").forward(request, response);
        return;
    } else if (!error1.isEmpty()) {
        request.setAttribute("error1", error1);
        request.getRequestDispatcher("/WEB-INF/Web/AddProductTemplate.jsp").forward(request, response);
        return;
    } else {
        dao.themProduct(proid, proname, prodes, img, proPri, 2, proCaid);
        response.sendRedirect("XuLyAdminProduct");
    }
}
}
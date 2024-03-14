<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="DAO.ProductDAO" %>
<%@page import="Model.Cart" %>
<%@page import="java.util.*" %>
<%
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartproduct = null;
if(cart_list != null){
	ProductDAO dao = new ProductDAO(); 
	cartproduct = dao.getCartProducts(cart_list);
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
 <title>Zay Shop eCommerce HTML CSS Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
    
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">
    
    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
</head>
<body>
 <c:if test="${user.userName != 'PTT'}">
    
    <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <img src="https://coffeeluck.themerex.net/wp-content/uploads/2016/08/logo.png" alt="">

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse"
              data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false"
              aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

             <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between"
              id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="XuLyHome">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="XuLyAbout">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="XuLyProduct">Shop</a>
                        </li>
                  
                        <li class="nav-item">
                            <a class="nav-link" href="XuLyToCart">Cart</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="XuLyContact">Contact</a>
                        </li>
                       
                        
                    </ul>
                </div>
                
                <c:choose>
    <c:when test="${not empty sessionScope.user.name}">
<p style="position:relative;top:8px">Chào ${sessionScope.user.name}/<a href="XuLyLogOut" style="text-decoration:none">LogOut</a></p>    </c:when>
    <c:otherwise>
        <a href="DangNhap.jsp" style="text-decoration:none">Log in</a>
    </c:otherwise>
</c:choose>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <div class="navbar align-self-center d-flex">
                    <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                        <div class="input-group">
                            <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                            <div class="input-group-text">
                                <i class="fa fa-fw fa-search"></i>
                            </div>
                        </div>
                    </div>
                     <a class="nav-icon d-none d-lg-inline" href="#" data-bs-toggle="modal"
                      data-bs-target="#templatemo_search">
                        <i class="fa fa-fw fa-search text-dark mr-2" onclick="updateSearchUrl()"></i>
                    </a> 
                    <a class="nav-icon position-relative text-decoration-none" href="XuLyToCart">
                        <i class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i>
                        <span
                          class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">${cart_list.size()}</span>
                    </a>
                    
                   <!--  <a class="nav-icon position-relative text-decoration-none" href="#">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span
                          class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
                    </a> -->
                </div>
            </div>

        </div>
    </nav>
    </c:if>
</body>
<script src="assets/js/custom.js">
$("a.nav-link").click(function(){
    $("a.nav-link").css("background-color", "black");
  $(this).css("background-color", "red");
});
</script>
<style>
.nav-link.active {
  color: #007bff; /* Or any other color you want for the active link */
}
</style>
</html>
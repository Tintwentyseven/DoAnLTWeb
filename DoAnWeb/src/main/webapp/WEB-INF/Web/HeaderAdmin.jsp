<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <c:if test="${user.userName == 'PTT'}">
    
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
                            <a class="nav-link" href="XuLyAdmin">Admin</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="XuLyUser">User</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="XuLyAdminProduct">Product</a>
                        </li>
                  
                        <li class="nav-item">
                            <a class="nav-link" href="XuLyAdminCategory">Category</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="XuLyProduct">Order</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ThongKe.jsp">Statistic</a>
                        </li>
                        
                    </ul>
                </div>
                 <c:choose>
    <c:when test="${not empty sessionScope.user.name}">
        <p style="position:relative;top:8px">Chào ${sessionScope.user.name}/<a href="DangNhap.jsp" style="text-decoration:none">LogOut</a></p>
    </c:when>
    <c:otherwise>
        <a href="DangNhap.jsp" style="text-decoration:none">Log in</a>
    </c:otherwise>
</c:choose>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                
            </div>

        </div>
    </nav>
    </c:if>
</body>
</html>
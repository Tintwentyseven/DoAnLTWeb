<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="Model.ShoppingCart"%>
<%@page import="DAO.GioHangDAO"%>
<%@page import="DAO.NgonNguDAO"%>
<%@page import="java.util.*"%>
<% Map<String,String> showlanguage = new NgonNguDAO().vietnamLanguage();
   String lang = (String) session.getAttribute("lang");
   if(lang!=null){
	   if(lang.equals("Vietnamese")){
		   showlanguage = new NgonNguDAO().vietnamLanguage();
	   }else if(lang.equals("English")){
		   showlanguage = new NgonNguDAO().englishLanguage();
		   
	   }
   }

%>
<html>
<head>
<title>Shop</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="assets/img/apple-icon.png">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/templatemo.css">
<link rel="stylesheet" href="assets/css/custom.css">


<!-- Load fonts style after rendering the layout styles -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="shortcut icon" href="favicon.png">

</head>
<body>
	<!-- Start Top Nav -->
	<jsp:useBean id="product" class="DAO.ProductDAO"></jsp:useBean>
	<jsp:useBean id="category" class="DAO.CategoryDAO"></jsp:useBean>
	<%--  <%
    List<Product> products = (List<Product>) request.getAttribute("products");
    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
    if(shoppingCart==null){
        shoppingCart = new ShoppingCart();
    }

%> --%>

	<!-- Start Top Nav -->
	<nav
		class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block"
		id="templatemo_nav_top">
		<div class="container text-light">
			<div class="w-100 d-flex justify-content-between">
				<div>
					<i class="fa fa-envelope mx-2"></i> <a
						class="navbar-sm-brand text-light text-decoration-none"
						href="mailto:info@company.com">info@company.com</a> <i
						class="fa fa-phone mx-2"></i> <a
						class="navbar-sm-brand text-light text-decoration-none"
						href="tel:010-020-0340">010-020-0340</a>
				</div>
				<div>
					<a class="text-light" href="https://fb.com/templatemo"
						target="_blank" rel="sponsored"><i
						class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a> <a
						class="text-light" href="https://www.instagram.com/"
						target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
					<a class="text-light" href="https://twitter.com/" target="_blank"><i
						class="fab fa-twitter fa-sm fa-fw me-2"></i></a> <a class="text-light"
						href="https://www.linkedin.com/" target="_blank"><i
						class="fab fa-linkedin fa-sm fa-fw"></i></a>
				</div>
				<a role="menuitem" href="XuLyProduct?lang=Vietnam"><img
					src="assets/img/vietnam.png"
					style="position: absolute; left: 1140px; top: 7px"></a> <a
					role="menuitem" href="XuLyProductE?lang=English"><img
					src="assets/img/united-states.png"
					style="position: absolute; left: 1180px; top: 7px"></a>
			</div>
		</div>
	</nav>
	<!-- Close Top Nav -->


	<!-- Header -->
	<!-- Header -->
	<c:if test="${user.userName == 'PTT'}">

		<jsp:include page="HeaderAdmin.jsp"></jsp:include>
	</c:if>
	<c:if test="${user.userName != 'PTT'}">
		<jsp:include page="Header.jsp"></jsp:include>

	</c:if>
	<!-- Close Header -->
	<!-- Modal -->
	<div class="modal fade bg-white" id="templatemo_search" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="w-100 pt-1 mb-5 text-right">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form action="XuLySearch" method="get"
				class="modal-content modal-body border-0 p-0">


				<div class="input-group mb-2">


					<input type="text" class="form-control" id="inputModalSearch"
						name="search" placeholder="Search ..." list="datalist1">
					<datalist id="datalist1">
						<c:forEach items="${listProduct}" var="p">
							<option value="${p.proname}"></option>
						</c:forEach>
					</datalist>
					<button type="submit"
						class="input-group-text bg-success text-light">
						<i class="fa fa-fw fa-search text-white"></i>


					</button>


				</div>

			</form>
		</div>
	</div>
	<!-- Start Hero Section -->
	<section class="bg-success py-5">
		<div class="container">
			<div class="row align-items-center py-5">
				<div class="col-md-8 text-white">
					<h1>Shop</h1>

				</div>

			</div>
		</div>
	</section>
	<!-- End Hero Section -->

	<br>
	<!-- Start Content -->

	<div class="container py-5">
		<div class="row">
			<c:set var="size" value="${sessionScope.size}" />
			
			<div class="col-lg-3">
				<h1 class="h2 pb-4">Categories</h1>
				<ul class="list-unstyled templatemo-accordion">

					<li class="pb-3"><a
						class="collapsed d-flex justify-content-between h3 text-decoration-none"
						href="#" onclick="toggleList1('collapseThree1')"> Feature <i
							class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
					</a>
						<ul id="collapseThree1" class="collapse list-unstyled pl-3">
							<li><a class="text-decoration-none" href="XuLyProduct">Normal</a></li>
							<li><a class="text-decoration-none" href="XuLyAtoZProduct">A
									to Z</a></li>
							<li><a class="text-decoration-none" href="XuLyZtoAProduct">Z
									to A</a></li>
						</ul></li>

					<li class="pb-3"><a
						class="collapsed d-flex justify-content-between h3 text-decoration-none"
						href="#" onclick="toggleList2('collapseThree2')"> Product <i
							class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
					</a>
						<ul id="collapseThree2" class="collapse list-unstyled pl-3">
							<li><a class="text-decoration-none" href="XuLyProduct">All</a></li>
							<c:forEach items="${listCa}" var="c">
								<li><a class="text-decoration-none"
									href="XuLyChonLocDuLieu?caid=${c.id}">${c.getCaname()}</a></li>
							</c:forEach>
						</ul>
					<li class="pb-3"><a
						class="collapsed d-flex justify-content-between h3 text-decoration-none"
						href="#" onclick="toggleList1('collapseThree1')"> Price <i
							class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
					</a>
						<ul id="collapseThree1" class="collapse list-unstyled pl-3">

							<li><a class="text-decoration-none" href="XuLyPrice1">0
									to 50.00</a></li>
							<li><a class="text-decoration-none" href="XuLyPrice2">50.00
									to 100.00</a></li>
							<li><a class="text-decoration-none" href="XuLyPrice3">100.00
									to 500.00</a></li>
						</ul></li>

				</ul>
			
				
					<br><br>
            <a href="XuLyComment?username=${sessionScope.user.userName}"><button type="submit" class="btn btn-success btn-lg" name="submit">Your Comment</button></a>
			 
			</div>
            
			<div class="col-lg-9">


					<div class="row">
						<c:forEach items="${listProduct}" var="p">

							<div class="col-md-4">
								<div class="card mb-4 product-wap rounded-0">
									<div class="card rounded-0">
										<img style="width:260px;height:260px" class="card-img rounded-0 img-fluid" src="${p.image}">
										<div
											class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
											<ul class="list-unstyled">

												<li><a class="btn btn-success text-white mt-2"
													href="XuLyDetailProduct?productid=${p.id}"><i
														class="far fa-eye"></i></a></li>
												<li><a class="btn btn-success text-white mt-2"
													href="Addtocart?productid=${p.id}"><i
														class="fas fa-cart-plus"></i></a></li>
												
												
											</ul>
										</div>
									</div>
									<div class="card-body">
										<a href="shop-single.html" class="h3 text-decoration-none"></a>
										<p class="text-center mb-0">${p.proname}</p>
										<ul
											class="w-100 list-unstyled d-flex justify-content-between mb-0">
											<li class="pt-2"><span
												class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
												<span
												class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
												<span
												class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
												<span
												class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
												<span
												class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
											</li>
										</ul>
										<ul class="list-unstyled d-flex justify-content-center mb-1">
											<li><i class="text-warning fa fa-star"></i> <i
												class="text-warning fa fa-star"></i> <i
												class="text-warning fa fa-star"></i> <i
												class="text-muted fa fa-star"></i> <i
												class="text-muted fa fa-star"></i></li>
										</ul>
										<p class="text-center mb-0">${p.price}</p>
									</div>
								</div>
							</div>
						</c:forEach>
						<%-- <%} %> --%>
					</div>
				
				


			</div>
		</div>

	</div>
	</div>
	<button onclick="topFunction()" id="myBtn" title="Go to top">TOP</button>
    <c:forEach begin="1" end="${endP}" var="i">
    <a href="XuLyProduct?indexs=${i}">${i}</a>
    </c:forEach>




	<!-- End Content -->

	<!-- Start Brands -->



	<!-- Start Footer -->
	<footer class="bg-dark" id="tempaltemo_footer">
		<div class="container">
			<div class="row">

				<div class="col-md-4 pt-5">
					<h2 class="h2 text-success border-bottom pb-3 border-light logo">Zay
						Shop</h2>
					<ul class="list-unstyled text-light footer-link-list">
						<li><i class="fas fa-map-marker-alt fa-fw"></i> 123
							Consectetur at ligula 10660</li>
						<li><i class="fa fa-phone fa-fw"></i> <a
							class="text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
						</li>
						<li><i class="fa fa-envelope fa-fw"></i> <a
							class="text-decoration-none" href="mailto:info@company.com">info@company.com</a>
						</li>
					</ul>
				</div>

				<div class="col-md-4 pt-5">
					<h2 class="h2 text-light border-bottom pb-3 border-light">Products</h2>
					<ul class="list-unstyled text-light footer-link-list">
						<li><a class="text-decoration-none" href="#">Luxury</a></li>
						<li><a class="text-decoration-none" href="#">Sport Wear</a></li>
						<li><a class="text-decoration-none" href="#">Men's Shoes</a></li>
						<li><a class="text-decoration-none" href="#">Women's
								Shoes</a></li>
						<li><a class="text-decoration-none" href="#">Popular
								Dress</a></li>
						<li><a class="text-decoration-none" href="#">Gym
								Accessories</a></li>
						<li><a class="text-decoration-none" href="#">Sport Shoes</a></li>
					</ul>
				</div>

				<div class="col-md-4 pt-5">
					<h2 class="h2 text-light border-bottom pb-3 border-light">Further
						Info</h2>
					<ul class="list-unstyled text-light footer-link-list">
						<li><a class="text-decoration-none" href="#">Home</a></li>
						<li><a class="text-decoration-none" href="#">About Us</a></li>
						<li><a class="text-decoration-none" href="#">Shop
								Locations</a></li>
						<li><a class="text-decoration-none" href="#">FAQs</a></li>
						<li><a class="text-decoration-none" href="#">Contact</a></li>
					</ul>
				</div>

			</div>

			<div class="row text-light mb-4">
				<div class="col-12 mb-3">
					<div class="w-100 my-3 border-top border-light"></div>
				</div>
				<div class="col-auto me-auto">
					<ul class="list-inline text-left footer-icons">
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="http://facebook.com/"><i
								class="fab fa-facebook-f fa-lg fa-fw"></i></a>
						</li>
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="https://www.instagram.com/"><i
								class="fab fa-instagram fa-lg fa-fw"></i></a>
						</li>
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="https://twitter.com/"><i
								class="fab fa-twitter fa-lg fa-fw"></i></a>
						</li>
						<li
							class="list-inline-item border border-light rounded-circle text-center">
							<a class="text-light text-decoration-none" target="_blank"
							href="https://www.linkedin.com/"><i
								class="fab fa-linkedin fa-lg fa-fw"></i></a>
						</li>
					</ul>
				</div>
				<div class="col-auto">
					<label class="sr-only" for="subscribeEmail">Email address</label>
					<div class="input-group mb-2">
						<input type="text" class="form-control bg-dark border-light"
							id="subscribeEmail" placeholder="Email address">
						<div class="input-group-text btn-success text-light">Subscribe</div>
					</div>
				</div>
			</div>
		</div>

		<div class="w-100 bg-black py-3">
			<div class="container">
				<div class="row pt-2">
					<div class="col-12">
						<p class="text-left text-light">
							Copyright &copy; 2021 Company Name | Designed by <a
								rel="sponsored" href="https://templatemo.com" target="_blank">TemplateMo</a>
						</p>
					</div>
				</div>
			</div>
		</div>

	</footer>
	<!-- End Footer -->

	<!-- Start Script -->
	<script src="assets/js/jquery-1.11.0.min.js"></script>
	<script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/templatemo.js"></script>
	<script src="assets/js/custom.js"></script>
	<script type="text/javascript">
    function buy(id){
    	document.f.action="buy?id=" + id;
    	document.f.submit();
    }
    
    function toggleList1(listId1) {
    	  const list1 = document.getElementById(listId1);
    	  const isOpen1 = list.classList.contains("show1");

    	  if (isOpen1) {
    	    list1.classList.remove("show1");
    	  } else {
    	    list1.classList.add("show1");
    	  }
    	}
    function toggleList2(listId2) {
    	  const list2 = document.getElementById(listId2);
    	  const isOpen2 = list.classList.contains("show2");

    	  if (isOpen2) {
    	    list2.classList.remove("show2");
    	  } else {
    	    list2.classList.add("show2");
    	  }
    	}
    </script>
	<script type="text/javascript">
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("myBtn").style.display = "block";
    } else {
        document.getElementById("myBtn").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}
function updateSearchUrl() {
    // Update the URL when the search icon is clicked
    window.history.replaceState({}, document.title, '/DoAnWeb/XuLyProduct');
}
</script>

	<!-- End Script -->
</body>
<style>
#myBtn {
	display: none;
	position: fixed;
	bottom: 60px;
	right: 0px;
	z-index: 99;
	border: none;
	outline: none;
	background-color: #fff;
	border: 2px solid #ccc;
	color: blue;
	cursor: pointer;
	border-radius: 30px;
	opacity: 0.7;
}

#myBtn:hover {
	background-color: #f1f1f1;
}

.listPage {
	padding: 10px;
	text-align: center;
	list-style: none;
}

.listPage li {
	background-color: #ffffffBD;
	padding: 20px;
	display: inline-block;
	margin: 0 10px;
	cursor: pointer;
}

.listPage .active {
	background-color: #B192EF;
	color: #fff;
}

input::-webkit-calendar-picker-indicator {
	opacity: 0;
}
</style>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="DAO.*" %>
<%@page import="Model.*" %>
<%@page import="java.util.*" %>
    <%
	
    KhachHang auth = (KhachHang) request.getSession().getAttribute("user");
	List<Order> orders = null;
	if (auth != null) {
	    request.setAttribute("person", auth);
	    OrderDAO orderDao  = new OrderDAO();
		orders = orderDao.getAllOrder(auth.getUserName(), 0);
	}else{
		response.sendRedirect("login.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
	
	%>
    
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>CheckOut</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
          <link rel="shortcut icon" href="favicon.png">
    
</head>
<body>
 <!-- Start Top Nav -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
        <div class="container text-light">
            <div class="w-100 d-flex justify-content-between">
                <div>
                    <i class="fa fa-envelope mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none"
                      href="mailto:info@company.com">info@company.com</a>
                    <i class="fa fa-phone mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                </div>
                <div>
                    <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i
                          class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.instagram.com/" target="_blank"><i
                          class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://twitter.com/" target="_blank"><i
                          class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i
                          class="fab fa-linkedin fa-sm fa-fw"></i></a>
                </div>
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
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
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
                    <h1>Billing details</h1>
                   
                </div>
                
            </div>
        </div>
    </section>
    <br>
		<!-- End Hero Section -->
    <!-- Close Header -->
    <form action="XuLyThanhToan?&username=<%=auth.getUserName() %>" method="post">
     <div class="row">
		        <div class="col-md-6 mb-5 mb-md-0">
		          <h2 class="h3 mb-3 text-black">Billing Details</h2>
		          <div class="p-3 p-lg-5 border bg-white">
		            <div class="form-group">
		              <label for="c_country" class="text-black">Country <span class="text-danger">*</span></label>
		              <select id="c_country" class="form-control" name="c_country">
		                <option value="1">Select a country</option>    
		                <option value="Vietnam">Vietnam</option>    
		                <option value="Algeria">Algeria</option>    
		                <option value="Afghanistan">Afghanistan</option>    
		                <option value="America">America</option>    
		                <option value="UK">UK</option>    
		                <option value="India">India</option>    
		                <option value="Japan">Japan</option>    
		                <option value="Korea">Korea</option>    
		              </select>
		            </div>
		            <div class="form-group row">
		              <div class="col-md-6">
		                <label for="c_fname" class="text-black">First Name <span class="text-danger">*</span></label>
		                <input type="text" class="form-control" id="c_fname" name="c_fname">
		              </div>
		              <div class="col-md-6">
		                <label for="c_lname" class="text-black">Last Name <span class="text-danger">*</span></label>
		                <input type="text" class="form-control" id="c_lname" name="c_lname">
		              </div>
		            </div>

		            <div class="form-group row">
		              <div class="col-md-12">
		                <label for="c_companyname" class="text-black">Company Name </label>
		                <input type="text" class="form-control" id="c_companyname" name="c_companyname">
		              </div>
		            </div>

		            <div class="form-group row">
		              <div class="col-md-12">
		                <label for="c_address" class="text-black">Address <span class="text-danger">*</span></label>
		                <input type="text" class="form-control" id="c_address" name="c_address" placeholder="Street address">
		              </div>
		            </div>

		           

		          

		            <div class="form-group row mb-5">
		              <div class="col-md-6">
		                <label for="c_email_address" class="text-black">Email Address <span class="text-danger">*</span></label>
		                <input type="text" class="form-control" id="c_email_address" name="c_email_address">
		              </div>
		              <div class="col-md-6">
		                <label for="c_phone" class="text-black">Phone <span class="text-danger">*</span></label>
		                <input type="text" class="form-control" id="c_phone" name="c_phone" placeholder="Phone Number">
		              </div>
		            </div>

		            <div class="form-group">
		              <div class="collapse" id="create_an_account">
		                <div class="py-2 mb-4">
		                  <p class="mb-3">Create an account by entering the information below. If you are a returning customer please login at the top of the page.</p>
		                  <div class="form-group">
		                    <label for="c_account_password" class="text-black">Account Password</label>
		                  </div>
		                </div>
		              </div>
		            </div>

                  
		            
		            <div class="form-group">
		              <label for="c_order_notes" class="text-black">Order Notes</label>
		              
		              <textarea name="c_order_notes" id="c_order_notes" maxlength="60" data-max-chars="60" cols="30" rows="5" class="form-control" onkeyup="return displayWordCounter();" placeholder="Write your notes here..."></textarea>
		              <div class="total_count">total remaining Charatctor:
       <div class="input-msg text-orange"></div>
</div>
		            </div>
		          </div>
		        </div>
		        <div class="col-md-6">

		          <div class="row mb-5">
		            <div class="col-md-12">
		              <h2 class="h3 mb-3 text-black">Coupon Code</h2>
		              <div class="p-3 p-lg-5 border bg-white">

		                <label for="c_code" class="text-black mb-3">Enter your coupon code if you have one</label>
		                <div class="input-group w-75 couponcode-wrap">
		                  <input type="text" class="form-control me-2" id="c_code" placeholder="Coupon Code" aria-label="Coupon Code" aria-describedby="button-addon2">
		                  <div class="input-group-append">
		                    <button class="btn btn-black btn-sm" type="button" id="button-addon2">Apply</button>
		                  </div>
		                </div>

		              </div>
		            </div>
		          </div>

		          <div class="row mb-5">
		            <div class="col-md-12">
		              <h2 class="h3 mb-3 text-black">Your Order</h2>
		              <div class="p-3 p-lg-5 border bg-white">
		                <table class="table site-block-order-table mb-5">
		                  <thead>
		                  <tr>
		                    <th scope="col">Date</th>
					<th scope="col">Detail</th>
					<th scope="col">Cancel</th>
		                    </tr>
		                  </thead>
		                  <tbody>
		                   <%
			if(orders != null){
				for(Order o:orders){%>
					<tr>
						<td><%=o.getDate()%></td>
						<td><%=o.productname %>|<%=o.quantity %>x<%=o.prices %></td>
						<td><a class="btn btn-sm btn-danger" href="XuLyXoaOrder?id=<%=o.getOrderid()%>&username=<%=auth.getUserName() %>">Cancel Order</a></td>
					</tr>
				<%}
			}
			%>
		                  </tbody>
		                </table>
		                <a class="btn btn-sm btn-danger" href="XuLyXoaAllOrder?&username=<%=auth.getUserName() %>">Cancel all Order</a>

		                <div class="border p-3 mb-3">
        <input type="radio" name="paymentMethod" id="directBankTransferCheckbox" value="DirectBankTransfer">
       <span style="font-size:20px">Direct Bank Transfer</span>

  

        <br>
  
        <input type="radio" name="paymentMethod" id="chequePaymentCheckbox" value="Cast">
            <span style="font-size:20px">Cast</span>
     
    

   


		            </div>
		       
                        <button type="submit" class="btn btn-sm btn-danger" ><span style="font-size:20px">Place order</span></button>

		        </div>
		      </div>
		      <!-- </form> -->
		    </div>
		  </div>
		  </div>
		  </form>
		  <script src="assets/js/LimitTextArea.js">
/*=============  This is a count of total number to be displayed ==================*/

</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import = "DAO.NgonNguDAO" %>
<%@page import = "java.util.*" %>
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
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Đăng ký</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" />
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="shortcut icon" href="favicon.png">
  
</head>
<body>
<div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Select language
  <span class="caret"></span></button>
  <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
    <li role="presentation"><a role="menuitem" href="DaNgonNgu?lang=Vietnamese">Vietnam</a></li>
    <li role="presentation"><a role="menuitem" href="DaNgonNgu?lang=English">English</a></li>
   
  </ul>
</div>
<div class="container">
    <jsp:useBean id="user" class="DAO.KhachHangDAO"></jsp:useBean>

<c:set var="pi" value="${user.layThongTinUser(param.edituserid)}"/>
  <h2> Thêm sản phẩm   </h2>
  <form class="form-horizontal" action="XuLyHDProductAdd" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">ID</label>
      <div class="col-sm-10">
<input type="text"  class="form-control"  name="productId" required placeholder="<%=showlanguage.get("DangKy.UserName2")%>">
<span style="color:red;font-size:10px">${error}</span>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Name</label>
      <div class="col-sm-10">
<input type="text" class="form-control"  name="productName"  required placeholder="<%=showlanguage.get("DangKy.UserName2")%>">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Descriptions</label>
      <div class="col-sm-10">          
       <textarea style="width:945px;height:100px" name="productDes"></textarea>
        
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">UrlImg</label>
      <div class="col-sm-10">          
        <input type="file" alt="Ko hiện được" class="form-control"  name="productImg"  required placeholder="<%=showlanguage.get("DangKy.FirstName2")%>">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Price</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control"  name="productPrice" required  placeholder="<%=showlanguage.get("DangKy.Email2")%>">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">CategoryId</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control"  name="productCaid" required  placeholder="<%=showlanguage.get("DangKy.Email2")%>">
        <span style="color:red;font-size:10px">${error1}</span>
      </div>
    </div>
    
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-success">Tạo mới</button>
        
      </div>
      <div class="col-sm-offset-2 col-sm-10" style="text-align:right">
        <input type="reset" value="<%=showlanguage.get("DangKy.Reset")%>" class="btn btn-success" >
      </div>
    </div>
  </form>
</div>
  
   <br>
   <span style="color:red;">${error}</span>
   <br>
   <span style="color:red;">${error1}</span>

</body>
<script >
//step 1
const ipnElement = document.querySelector('#pwd')
const btnElement = document.querySelector('#btnPassword')

// step 2
btnElement.addEventListener('click', function() {
  // step 3
  const currentType = ipnElement.getAttribute('type')
  // step 4
  ipnElement.setAttribute(
    'type',
    currentType === 'password' ? 'text' : 'password'
  )
})
</script>
<style>
/* .container{
	height: 100%;
	width: 100%;
	background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url("");
	background-position: center;
	background-size: cover;
	position: absolute;
} */
</style>
</html>

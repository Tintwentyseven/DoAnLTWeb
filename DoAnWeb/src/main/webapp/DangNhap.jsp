<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="Model.KhachHang"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import = "DAO.NgonNguDAO" %>
<%@page import = "java.util.*" %>
<% Map<String,String> showlanguage = new NgonNguDAO().vietnamLanguage();
   String lang = (String) session.getAttribute("lang2");
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
 <title>Đăng nhập</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" />
 <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">  -->
    <link rel="stylesheet" href="assets/css/style.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="shortcut icon" href="favicon.png">
  
</head>
<body>


<!-- partial:index.partial.html -->

<div class="logo text-center">
  <h1>Coffee&Tea</h1>
</div>
<div class="wrapper">
  <div class="inner-warpper text-center">
    <h2 class="title">Login to your account</h2>
    <form action="XuLyDangNhap" method="post">
      <div class="input-group">
        <label class="palceholder" for="username"><%=showlanguage.get("DangNhap.UserName")%></label>
        <input class="form-control" name="username" id="userName" type="text" placeholder="" />
        <span class="lighting"></span>
      </div>
      <div class="input-group">
        <label class="palceholder" for="pass"><%=showlanguage.get("DangNhap.PassWord")%></label>
        <input class="form-control" name="pass" id="pwd" type="password" placeholder="" />
        <span class="lighting" ></span>
                 <span style="color:red;font-size:10px"><%=showlanguage.get("DangNhap.Error")%> ${loginAttempts}</span>
        
         
      </div>
     
      <button type="submit" id="login"><%=showlanguage.get("DangNhap.Login")%></button>
      <br><br>
      <button onclick="event.preventDefault(); window.location.href='DangKy.jsp';" class="btn btn-success"><%=showlanguage.get("DangNhap.SignUp")%></button>
      <br><br>
      <button type="reset"><%=showlanguage.get("DangNhap.Reset")%></button>
      
    </form>
      <br>
       <a href="XuLyToQuenMatKhau" style="text-decoration:none"> <button type="submit" class="btn btn-success"><%=showlanguage.get("DangNhap.ForgotPass")%></button></a>
       <br><br>
       <a href="XuLyToThayDoiMatKhau" style="text-decoration:none"> <button type="submit" class="btn btn-success"><%=showlanguage.get("DangNhap.ChangePass")%></button></a>
  </div>
  
</div>
      <input class="theme-toggle" type='checkbox'>



<!-- you don't need that :)  -->
<div class="direction" style="height:120px">
  Type something in input and click submit to see the effect
  <ul class="dropdown-menu" role="menu" aria-labelledby="menu1" style="list-style:none;text-align:center">
    <li role="presentation"><a role="menuitem" href="DaNgonNguDangNhap?lang2=Vietnamese"><img src="assets/img/vietnam.png" style="position:relative;left:-30px"></a></li>
    <li role="presentation"><a role="menuitem" href="DaNgonNguDangNhap?lang2=English"><img src="assets/img/united-states.png" style="position:relative;left:-30px"></a></li>
   
  </ul>

</div>
<!-- partial -->
  <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js'></script><script  src="assets/js/script.js"></script>

</body>
   <script>
   const checkbox = document.querySelector('input[type="checkbox"]');

   checkbox.addEventListener("change", () => {
   	document.body.classList.toggle("dark-body");
   });

</script>




</html>

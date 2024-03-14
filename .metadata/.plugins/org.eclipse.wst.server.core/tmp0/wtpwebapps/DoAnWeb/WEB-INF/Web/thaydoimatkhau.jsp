<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" />
 <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">  -->
    <link rel="stylesheet" href="assets/css/style.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="shortcut icon" href="favicon.png">
  
  

<title>Thay đổi mật khẩu</title>
</head>
<body>
<div class="logo text-center">
  <h1>Coffee&Tea</h1>
</div>
<div class="wrapper">
  <div class="inner-warpper text-center">
    <h2 class="title">Thay đổi mật khẩu</h2>
    <form action="XuLyThayDoiMatKhau" method="post">
      <div class="input-group">
        <label class="palceholder" for="username">Tên đăng nhập</label>
         <input type="text" class="form-control" id="pwd" name="username" required >
                        <span style="color:red;font-size:10px">${error1}</span>
                 <span style="color:red;font-size:10px">${error3}</span>
               
         
        <span class="lighting"></span>
      </div>
      <div class="input-group">
        <label class="palceholder" for="pass">Mật khẩu cũ</label>
         <input type="password" class="form-control" id="pwd" name="oldpass" required >
        <span class="lighting" ></span>

      </div>
      <div class="input-group">
        <label class="palceholder" for="pass">Mật khẩu mới</label>
       <input type="password" class="form-control" id="pwd" name="newpass" required >
                 <span style="color:red;font-size:10px">${error2}</span>
        <span class="lighting" ></span>

      </div>
     
      <button type="reset">Xóa hết</button>
      <br><br>
          <button type="submit" class="btn btn-primary">Thay đổi theo mật khẩu mới</button>
          <br><br>
                <button onclick="event.preventDefault(); window.location.href='DangNhap.jsp';" class="btn btn-success">Quay lại</button>
          
      
    </form>
      <br>
       
  </div>
  
</div>
       

<!-- you don't need that :)  -->

<br>
    <br>
       <span style="color:red;">${error1}</span>
       <span style="color:red;">${error2}</span>
       <span style="color:red;">${error3}</span>
       <span style="color:red;">${message}</span>
       
  <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js'></script><script  src="assets/js/script.js"></script>  
</body>
</html>
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
  
<title>Quên mật khẩu</title>
</head>
<body>
<div class="logo text-center">
  <h1>Coffee&Tea</h1>
</div>
<div class="wrapper">
  <div class="inner-warpper text-center">
    <h2 class="title">Quên mật khẩu</h2>
    <form action="XuLyQuenMatKhau" method="post">
      <div class="input-group">
        <label class="palceholder" for="username">Email</label>
          <input type="email" class="form-control" id="pwd" name="email" required >
                        <span style="color:red;font-size:10px">${error1}</span>
       <span style="color:red;font-size:10px">${error2}</span>
               
         
        <span class="lighting"></span>
      </div>
      
     
      <button type="reset">Xóa hết</button>
      <br><br>
           <button type="submit" class="btn btn-primary">Gửi lại mật khẩu</button>
              <span style="color:red;font-size:10px">${message}</span>
              <br><br>
      <button onclick="event.preventDefault(); window.location.href='DangNhap.jsp';" class="btn btn-success">Quay lại</button>
              
       
    </form>
      <br>
       
  </div>
  
</div>
       

<!-- you don't need that :)  -->

<br><br><br><br><br><br><br>
      
    <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js'></script><script  src="assets/js/script.js"></script>
</body>
</html>
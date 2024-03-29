<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<html>
<head>
 <title>Coffee luck</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
    
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">
    <link rel="stylesheet" href="assets/css/Translate.css">
    
    
    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
          <link rel="shortcut icon" href="favicon.png">
      <script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"
   Integrity = "sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ=="
   crossorigin = "anonymous" referrerpolicy = "no-referrer"> </script>
</head>
<body id="dark-class">
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
                          <!-- <label class = "toggleButton">
      <input type = "checkbox" id = "toggle">
      <div class = "roundButton circle" ></div>
   </label> -->
                </div>
    <a role="menuitem" href="DaNgonNguindex?lang=Vietnamese"><img src="assets/img/vietnam.png" style="position:absolute;left:1140px;top:7px"></a>
<a role="menuitem" href="DaNgonNguindex?lang=English"><img src="assets/img/united-states.png" style="position:absolute;left:1180px;top:7px"></a>
            </div>
        </div>
    </nav>
    <div id='google_translate_element'></div>
    
    <!-- Close Top Nav -->
 


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



    <!-- Start Banner Hero -->
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img  src="./assets/img/Banner1.jpg" style="width:500px" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left align-self-center">
                                <h2 ><%=showlanguage.get("index.banner1.1")%></h2>
                               
                                <p>
                                    <%=showlanguage.get("index.banner1.2")%>
                                </p>
                                
                               <span style="position:relative;left:110px;font-size:26px"><%=showlanguage.get("index.banner1.3")%></span>
                               <div class="time-container">
      <div class="time"><p><%=showlanguage.get("index.banner1.4")%></p><span id="days">00</span></div>
      <div class="time"><p><%=showlanguage.get("index.banner1.5")%></p><span id="hours">00</span></div>
      <div class="time"><p><%=showlanguage.get("index.banner1.6")%></p><span id="minutes">00</span></div>
      <div class="time"><p><%=showlanguage.get("index.banner1.7")%></p><span id="seconds">00</span></div>
    </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <img class="img-fluid" src="./assets/img/Banner2.jpg" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h2 ><%=showlanguage.get("index.banner2.1")%></h2>
                                <p>
                                   <%=showlanguage.get("index.banner2.2")%>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        
                            <img class="img-fluid" src="./assets/img/Banner4.jpg" style="width:350px;height:400px;position:relative;left:100px" alt="">
                        
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-right" style="width:500px;position:absolute;left:700px">
                               <h2><%=showlanguage.get("index.banner3.1")%></h2>
                                <p>
                                  <%=showlanguage.get("index.banner3.2")%>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel"
          role="button" data-bs-slide="prev">
            <i class="fas fa-chevron-left"></i>
        </a>
        <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel"
          role="button" data-bs-slide="next">
            <i class="fas fa-chevron-right"></i>
        </a>
    </div>
    <!-- End Banner Hero -->


    <!-- Start Categories of The Month -->
    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1"><%=showlanguage.get("index.category")%></h1>
                <p>
                    <%=showlanguage.get("index.category2")%>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="#"><img
                      src="https://product.hstatic.net/1000360860/product/tra_sua_toco_517ae6b8d48942a3b0ff7f40fbe2fcc2_master.jpg"
                      class="rounded-circle img-fluid border"></a>
                <h5 class="text-center mt-3 mb-3"><%=showlanguage.get("index.category3")%></h5>
                <p class="text-center"><a class="btn btn-success">Go Shop</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="#"><img src="https://image.freepik.com/free-photo/pouring-coffee-with-smoke-cup-coffee-beans-burlap-sack-black-background_126277-480.jpg" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3"><%=showlanguage.get("index.category4")%></h2>
                <p class="text-center"><a class="btn btn-success">Go Shop</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="#"><img src="https://images8.alphacoders.com/746/thumb-1920-746166.jpg" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3"><%=showlanguage.get("index.category5")%></h2>
                <p class="text-center"><a class="btn btn-success">Go Shop</a></p>
            </div>
        </div>
    </section>
    <!-- End Categories of The Month -->


    <!-- Start Featured Product -->
    <section class="bg-light">
        <div class="container py-5">
            <div class="row text-center py-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1"><%=showlanguage.get("index.Feature")%></h1>
                    <p>
                      <%=showlanguage.get("index.Feature2")%>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <a href="shop-single.html">
                            <img src="./assets/img/Coffee1black.jpg" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                </li>
                                <li class="text-muted text-right">$20.00</li>
                            </ul>
                            <a href="shop-single.html" class="h2 text-decoration-none text-dark"><%=showlanguage.get("index.Feature3")%></a>
                            <p class="card-text">
                                <%=showlanguage.get("index.Feature6")%>
                            </p>
                            <p class="text-muted"></p>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <a href="shop-single.html">
                            <img src="./assets/img/MilkTea1.jpg" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                    <i class="text-muted fa fa-star"></i>
                                </li>
                                <li class="text-muted text-right">$20.00</li>
                            </ul>
                            <a href="shop-single.html" class="h2 text-decoration-none text-dark"><%=showlanguage.get("index.Feature2")%></a>
                            <p class="card-text">
                                <%=showlanguage.get("index.Feature7")%>
                            </p>
                            <p class="text-muted"></p>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <a href="shop-single.html">
                            <img src="./assets/img/Coffee2milk.jpg" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                    <i class="text-warning fa fa-star"></i>
                                </li>
                                <li class="text-muted text-right">$20.00</li>
                            </ul>
                            <a href="shop-single.html" class="h2 text-decoration-none text-dark"><%=showlanguage.get("index.Feature5")%></a>
                            <p class="card-text">
                               <%=showlanguage.get("index.Feature6")%>
                            </p>
                            <p class="text-muted"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="text-align:right">Số lượt truy cập ${views}</div>
    </section>
    <!-- End Featured Product -->


    <!-- Start Footer -->
    <footer class="bg-dark" id="tempaltemo_footer">
        <div class="container">
            <div class="row">

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-success border-bottom pb-3 border-light logo">Zay Shop</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li>
                            <i class="fas fa-map-marker-alt fa-fw"></i>
                            123 Consectetur at ligula 10660
                        </li>
                        <li>
                            <i class="fa fa-phone fa-fw"></i>
                            <a class="text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                        </li>
                        <li>
                            <i class="fa fa-envelope fa-fw"></i>
                            <a class="text-decoration-none" href="mailto:info@company.com">info@company.com</a>
                        </li>
                    </ul>
                </div>

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Products</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="#">Luxury</a></li>
                        <li><a class="text-decoration-none" href="#">Sport Wear</a></li>
                        <li><a class="text-decoration-none" href="#">Men's Shoes</a></li>
                        <li><a class="text-decoration-none" href="#">Women's Shoes</a></li>
                        <li><a class="text-decoration-none" href="#">Popular Dress</a></li>
                        <li><a class="text-decoration-none" href="#">Gym Accessories</a></li>
                        <li><a class="text-decoration-none" href="#">Sport Shoes</a></li>
                    </ul>
                </div>

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Further Info</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="#">Home</a></li>
                        <li><a class="text-decoration-none" href="#">About Us</a></li>
                        <li><a class="text-decoration-none" href="#">Shop Locations</a></li>
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
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i
                                  class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank"
                              href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i
                                  class="fab fa-twitter fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank"
                              href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="col-auto">
                    <label class="sr-only" for="subscribeEmail">Email address</label>
                    <div class="input-group mb-2">
                        <input type="text" class="form-control bg-dark border-light" id="subscribeEmail"
                          placeholder="Email address">
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
                            Copyright &copy; 2021 Company Name
                            | Designed by <a rel="sponsored" href="https://templatemo.com"
                              target="_blank">TemplateMo</a>
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
    <script src="assets/js/countdown.js"></script>
    <script src="assets/js/Translate.js"></script>
    <!-- <script>
   function debounce(func, threshold) {
    var timeout;

    return function() {
        var context = this,
            args = arguments;

        if (timeout) {
            clearTimeout(timeout);
        }

        timeout = setTimeout(function() {
            func.apply(context, args);

            timeout = null;
        }, threshold || 250);
    };
}

var SessionTimeout = (function() {
    var session_duration = 10,
        session_timeout_id,
        logout_duration = 15, //15 minutes
        session_timeout_duration = (session_duration - logout_duration) * 1000,
        logout_id,
        logout_timeout_duration = logout_duration * 1000,
        events = 'keydown mousedown',
        notification_element;

    return {
        init: function() {
            var that = this;

            document.addEventListener(events.split(' ')[0], debounce(function () {
                that.handler.apply(that);
            }, 500));
            
            this.startIdleTimeout();
        },

        handler: function() {                    
            // reset session timeout
            clearTimeout(session_timeout_id);

            this.startIdleTimeout();
        },
      
        startIdleTimeout: function () {
            var that = this;

            session_timeout_id = setTimeout(function () {
                that.idle.apply(that); 
            }, session_timeout_duration);
        },

        idle: function() {
            // create bar
            notification_element = this.createTimeoutNotification();

            // display bar
            notification_element.style.display = 'block';

            // remove events
            document.removeEventListener('keydown', this.handler);
            document.removeEventListener('mousedown', this.handler);

            // start logout timeout
            this.startLogoutTimeout();
            
            // start logout countdown
            this.startLogoutCountdown();

            // add logout events
            this.attachTimeoutNotificationEvents();
        },

        createTimeoutNotification: function() {
            var notification_element = document.createElement('div');
            notification_element.className = 'session-timeout-notification';
            notification_element.innerHTML = [
                '<strong>Hey!</strong> you will be logged off in <strong class="time">' + logout_duration + '</strong> seconds due to inactivity. ',
                '<a href="#">Click here to continue using www.example.com</a>'
            ].join('');
            
            document.body.appendChild(notification_element);

            return notification_element;
        },

        removeTimeoutNotification: function() {
            notification_element.style.display = 'none';
            document.body.removeChild(notification_element);
        },

        attachTimeoutNotificationEvents: function() {
            var that = this,
                dismiss_element = notification_element.querySelector('a');

            dismiss_element.addEventListener('click', function() {
                // reset timer to prevent logout
                clearTimeout(logout_id);

                that.removeTimeoutNotification();

                that.init();
            });
        },

        startLogoutTimeout: function() {
            var that = this;

            logout_id = setTimeout(function() {
                alert('REDIRECT:LOGOUT');
                
                that.removeTimeoutNotification.apply(that);
            }, logout_timeout_duration);
        },

        startLogoutCountdown: function(time) {
            var that = this,
                time = time || logout_duration - 1;

            setTimeout(function() {
                notification_element.querySelector('.time').innerHTML = time;

                time--;

                if (time > 0) {
                    that.startLogoutCountdown.call(that, time);
                }
            }, 1000);
        }
    };
}());
</script> -->
<!-- <script>
      // If the input checkbox is checked, activate dark mode by adding dark-class to the body
      $('#toggle').change(() => {
         if ($('#toggle').is(":checked")) {
            $("body").addClass("dark-class");
         } else {
            $("body").removeClass("dark-class")
         }
      })
   </script> -->
<script>

</script>

    <!-- End Script -->
</body>
    <style>
   .time-container {
  display: flex;
  justify-content: center;
}
.time {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 0 15px;
  color: black;
  font-size: 1rem;
}
.time span {
  margin-top: 10px;
  color: black;
  font-size: 3rem;
}
@media screen and (max-width: 480px) {
  .time {
    font-size: 0.875rem;
    margin: 0 8px;
  }
  .time span {
    font-size: 1.75rem;
  }
}

      /* body {
         color: black;
         background-color: rgb(241, 241, 241);
         text-align: center;
         justify-content: center;
      }
      .dark-class {
         color: white;
         background-color: gray;
      }
      .dark-class section {
         color: white;
         background-color: gray;
      }
      p {
         font-size: 1.2rem;
      }
      .toggleButton {
         width: 3rem;
         height: 1.2rem;
         position: relative;
         display: inline-block;
      }
      .toggleButton input {
         opacity: 0;
      }
      .roundButton {
         background-color: black;
         top: 0;
         left: 0;
         position: absolute;
         right: 0;
         bottom: 0;
         cursor: pointer;
      }
      .roundButton:before {
         left: 0;
         bottom: 0;
         position: absolute;
         content: "";
         background-color: grey;
         transition: 1s;
         height: 20px;
         width: 20px;
      }
      input:checked+.roundButton {
         background-color: white;
      }
      input:checked+.roundButton:before {
         transform: translateX(2rem);
      }
      .roundButton.circle {
         border-radius: 20px;
      }
      .roundButton.circle:before {
         border-radius: 50%;
      }
   */
    </style>
</html>
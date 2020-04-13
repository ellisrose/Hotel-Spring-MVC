<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<head>
  <title>LuxuryHotel a Hotel Template</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900|Rubik:300,400,700" rel="stylesheet">

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/animate.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/fontawesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/magnific-popup.css">

  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  
  <!-- Theme Style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style1.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/landingModify.css">
</head>

<body>

  <header role="banner">

    <nav class="navbar navbar-expand-md navbar-dark bg-light">
      <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">LuxuryHotel</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample05"
          aria-controls="navbarsExample05" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse navbar-light" id="navbarsExample05">
          <ul class="navbar-nav ml-auto pl-lg-5 pl-0">
            <li class="nav-item">
              <a class="nav-link active" href="${pageContext.request.contextPath}/">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/room">Rooms</a>

            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/restaurant/restaurant">Restaurant</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/about">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a>
            </li>
         	
         	<!-- Not visible when user logged in -->           
            <security:authorize access="!isAuthenticated()">
              <a class="nav-link" href="${pageContext.request.contextPath}/loginPage">
                <span class="fa fa-user fa-xs"> Login</span>
              </a>
             </security:authorize>
             
             <!-- Only visible when user logged in -->
            <security:authorize access="isAuthenticated()">
            	<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/landing/contact">
              		<span class="fa fa-user fa-xs"> <security:authentication property="principal.username" /></span></a>            	
              	</li>
            	<li class="nav-item">
            		<form:form action="${pageContext.request.contextPath}/logout" method="post">
              			<input class="nav-link sub" type="submit" value="logout"/>
              		</form:form>
            	</li>
            </security:authorize>
          </ul>

        </div>
      </div>
    </nav>
  </header>
  <!-- END header -->

  <section class="site-hero overlay" data-stellar-background-ratio="0.5"
    style="background-image: url(${pageContext.request.contextPath}/resources/images/big_image_1.jpg);">
    <div class="container">
      <div class="row align-items-center site-hero-inner justify-content-center">
        <div class="col-md-12 text-center">

          <div class="mb-5 element-animate">
            <h1>Welcome To Our Luxury Rooms</h1>
            <p>Discover our world's #1 Luxury Room For VIP.</p>
            <p><a href="${pageContext.request.contextPath}/reservation/book" class="btn btn-primary">Book Now</a></p>
            <div class="separator">
              <h6>Or</h6>
            </div>
			
            <div>

              <form:form action="search" modelAttribute="confirm" method="post">

                <div class="row">
                  <div class="col-md-12 form-group ">
                    <label for="confirmCode" class="confirmcode-label" >I already had a reservation</label> </br>
                    <input type="text" name="confirm" class="input-lg" id="confirmCode" size ="60" placeholder=" Confirmation code" >
                  </div>
                </div>

                <div class="row">
                  <div class="col-md-12 form-group">
                    <input type="submit" value="Check my reservation" class="btn btn-primary">
                  </div>
                </div>

              </form:form>

            </div>

          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- END section -->

  <!-- loader -->
  <div id="loader" class="show fullscreen">
    <!--
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
            stroke="#f4b214" />
    </svg>
-->
</div>
  <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery-migrate-3.0.0.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery.waypoints.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery.stellar.min.js"></script>

  <script src="${pageContext.request.contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/magnific-popup-options.js"></script>

  <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>

</html>
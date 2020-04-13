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

    <section class="site-hero site-hero-innerpage overlay" data-stellar-background-ratio="0.5"
        style="background-image: url(images/big_image_1.jpg);">
        <div class="container">
            <div class="row align-items-center site-hero-inner justify-content-center">
                <div class="col-md-12 text-center">

                    <div class="mb-5 element-animate">
                        <h1>My Reservation</h1>
                        <p>View your booking details.</p>
                    </div>

                </div>
            </div>
        </div>
    </section>
    <!-- END section -->

    <section class="site-section">
        <div class="container">

            <div class="row">
                <div class="col-md-12">

                    <h2 class="mb-5">Reservation List</h2>

                    <div class="row" style="align-items: flex-end;">
                        <div class="col-sm-3 form-group">
                            <label for="from_date">From</label>
                            <div style="position: relative;">
                                <span class="fa fa-calendar icon"
                                    style="position: absolute; right: 10px; top: 10px;"></span>
                                <input type='text' class="form-control" id='from_date' />
                            </div>
                        </div>
                        <div class="col-sm-3 form-group">
                            <label for="to_date">To</label>
                            <div style="position: relative;">
                                <span class="fa fa-calendar icon"
                                    style="position: absolute; right: 10px; top: 10px;"></span>
                                <input type='text' class="form-control" id='to_date' />
                            </div>
                        </div>
                        <div class="col-md-3 form-group">
                            <input type="submit" value="Search" class="btn btn-md" >
                          </div>
                    </div>


                    <div class="row">
                        <div class="col-md-12 ">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Location</th>
                                        <th>Check-in</th>
                                        <th>Check-out</th>
                                        <th>Confirmation code</th>
                                        <th>Room type</th>
                                        <th>Quantity</th>
                                        <th>Nightly charge</th>
                                        <th>Meal*</th>
                                        <th>Total</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Chicago,IL</td>
                                        <td>02/20/2020</td>
                                        <td>02/29/2020</td>
                                        <td>ABC123</td>
                                        <td> <a href="rooms.html">Luxury </a></td>
                                        <td>2</td>
                                        <td>$200</td>
                                        <td>Not included</td>
                                        <td>$1800</td>
                                        <td>
                                            <input type="submit" value="Cancel" class="btn btn-md">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Chicago,IL</td>
                                        <td>02/20/2020</td>
                                        <td>02/29/2020</td>
                                        <td>ABC123</td>
                                        <td> <a href="rooms.html">Luxury </a></td>
                                        <td>2</td>
                                        <td>$200</td>
                                        <td>B</td>
                                        <td>$1800</td>
                                        <td>
                                            <input type="submit" value="Cancel" class="btn btn-md">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Chicago,IL</td>
                                        <td>02/20/2020</td>
                                        <td>02/29/2020</td>
                                        <td>ABC123</td>
                                        <td> <a href="rooms.html">Luxury </a></td>
                                        <td>2</td>
                                        <td>$200</td>
                                        <td>B,L,D</td>
                                        <td>$1800</td>
                                        <td>
                                            <input type="submit" value="Cancel" class="btn btn-md">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>

            </div>
            <div class="row pull-right">
                *: B-Breakfast, L-Lunch, D-Dinner
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
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery-migrate-3.0.0.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.stellar.min.js"></script>

    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/magnific-popup-options.js"></script>
    <script
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>

    <script>

        $('#arrival_date, #departure_date').datepicker({});

    </script>



    <script src="js/main.js"></script>
</body>

</html>
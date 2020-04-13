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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/magnific-popup.css">

    <!-- Theme Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
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
              <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/display-room-types">Rooms</a>

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

    <section class="site-hero site-hero-innerpage overlay" data-stellar-background-ratio="0.5" style="background-image: url(${pageContext.request.contextPath}/resources/images/big_image_1.jpg);">
      <div class="container">
        <div class="row align-items-center site-hero-inner justify-content-center">
          <div class="col-md-12 text-center">

            <div class="mb-5 element-animate">
              <h1>Harborview Restaurant</h1>
              <p>Discover our Esteemed Dining Option.</p>
            </div>

          </div>
        </div>
      </div>
    </section>
    <!-- END section -->

    <section class="site-section">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-12">
            <div class="heading-wrap  element-animate">
              <h4 class="sub-heading">Enjoy your Meal</h4>
              <h2 class="heading">Your Order</h2>
              <p class="">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minus illo similique natus, a recusandae? Dolorum, unde a quibusdam est? Corporis deleniti obcaecati quibusdam inventore fuga eveniet! Qui delectus tempore amet!</p>

              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minus illo similique natus, a recusandae? Dolorum, unde a quibusdam est? Corporis deleniti obcaecati quibusdam inventore fuga eveniet! Qui delectus tempore amet!</p>

              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minus illo similique natus, a recusandae? Dolorum, unde a quibusdam est? Corporis deleniti obcaecati quibusdam inventore fuga eveniet! Qui delectus tempore amet!</p>

            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- END section -->

	<div class="container">
    <form:form action="save" modelAttribute="order" method="POST" class="regform mt-4">
      	<div class="col-md-4 form-group">
      		<label for="ConfirmNumber">Confirmation number</label>
          	<input type="text" placeholder="1234" name="reservationId" path="code" class="form-control" name="code" id="code"/>
      	</div>
      	<h4 class="heading">Select Meals</h4>
      	<div class="row">
      		<div class="col-md-3 form-group">
            	<label for="numBreakfast">Number of Breakfasts</label>
           		<select name="numBreakfast" path="numBreak" class="form-control">
           			<option value=0>0</option>
		            <option value=1>1</option>
		            <option value=2>2</option>
		            <option value=3>3</option>
		            <option value=4>4</option>
		            <option value=5>5</option>
		            <option value=6>6</option>
		            <option value=7>7</option>
		            <option value=8>8</option>
            	</select>
        </div>
        <div class="col-md-3 form-group">
          <label for="numLunch">Number of Lunchs</label>
          	<select name="numLunch" path="numLunch" class="form-control">
            	<option value=0>0</option>
	          	<option value=1>1</option>
	          	<option value=2>2</option>
	          	<option value=3>3</option>
	          	<option value=4>4</option>
	          	<option value=5>5</option>
	          	<option value=6>6</option>
	          	<option value=7>7</option>
	          	<option value=8>8</option>
          	</select>
      	</div>
	    <div class="col-md-3 form-group">
	      	<label for="numDinner">Number of Dinners</label>
	        <select name="numDinner" path="numDinner" class="form-control">
	        	<option value=0>0</option>
	          	<option value=1>1</option>
	          	<option value=2>2</option>
	          	<option value=3>3</option>
	          	<option value=4>4</option>
	          	<option value=5>5</option>
	          	<option value=6>6</option>
	          	<option value=7>7</option>
	          	<option value=8>8</option>
	        </select>
        
        	</div>
        </div>
        <div class="row">
             <div class="col-md-3 form-group">
             	<input type="submit" value="Submit" class="btn btn-primary">
            </div>
         </div>
      </form:form>
      <br><br><br>
      <!-- <button type="submit" class="btn btn-primary mb-4">Submit</button> -->
    </div>
    
    <footer class="site-footer">
		<div class="container">
			<div class="row mb-5">
				<div class="col-md-4">
					<h3>Phone Support</h3>
					<p>24/7 Call us now.</p>
					<p class="lead">
						<a href="tel://">+ 1 332 3093 323</a>
					</p>
				</div>
				<div class="col-md-4">
					<h3>Connect With Us</h3>
					<p>We are socialized. Follow us</p>
					<p>
						<a href="#" class="pl-0 p-3"><span class="fa fa-facebook"></span></a>
						<a href="#" class="p-3"><span class="fa fa-twitter"></span></a> <a
							href="#" class="p-3"><span class="fa fa-instagram"></span></a> <a
							href="#" class="p-3"><span class="fa fa-vimeo"></span></a> <a
							href="#" class="p-3"><span class="fa fa-youtube-play"></span></a>
					</p>
				</div>
				<div class="col-md-4">
					<h3>Connect With Us</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Maxime, odio.</p>
					<form action="#" class="subscribe">
						<div class="form-group">
							<button type="submit">
								<span class="ion-ios-arrow-thin-right"></span>
							</button>
							<input type="email" class="form-control"
								placeholder="Enter email">
						</div>

					</form>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-7 text-center">
					&copy;
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					Copyright &copy;
					<script>document.write(new Date().getFullYear());</script>
					All rights reserved | This template is made with <i
						class="fa fa-heart-o" aria-hidden="true"></i> by <a
						href="https://colorlib.com" target="_blank">Colorlib</a>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				</div>
			</div>
		</div>
	</footer>
	<!-- END footer -->  
    
    <!-- loader -->
    <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#f4b214"/></svg></div>

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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<c:if test="${empty loggedInuser}">
	<%response.sendRedirect("loginpage");%>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WhiskeyWorldWide|Quiz</title>
<link href="static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="static/css/jumbotron.css" rel="stylesheet">
</head>
<body>
	<div style="background-image: url('static/img/backgroundimg.jpg')">
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="#">WhiskeyWorldWide | Quiz</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsExampleDefault">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link ${Welcome}"
						href="welcome">Home </a></li>
					<li class="nav-item"><a class="nav-link ${about}" href="about">About</a>
					</li>
					<li class="nav-item"><a class="nav-link ${contact}"
						href="contact">Contact</a></li>
					<li class="nav-item"><a class="nav-link ${logout}"
						href="loginpage">Logout</a>
				</ul>
			</div>
		</nav>
		<div class="quizcards" style="margin-left: 40%; color: #eec170;">
			<div class="card" style="width: 21rem;">
				<div class="card-body" style="background-color: #772f1a;">
					<h5 class="card-title">BBQ</h5>
					<img src="static/img/spare-ribs-5340942_640.jpg">
					<form action="processForm" method="GET">
						<br> Can't get enough<input type="radio" name="bbq" value="5">
						<br> Pretty Good<input type="radio" name="bbq" value="4">
						<br> Don't Care<input type="radio" name="bbq" value="3">
						<br> Not my Favorite<input type="radio" name="bbq" value="2">
						<br> Can't stand it<input type="radio" name="bbq" value="1">
						<br><br>
						<!-- <button class="submit">Submit</button> -->
						<!-- When the user clicks this I want a new card to come in, I'm not sure how to implement this -->
						<%-- 			</form>
				</div>
			</div> --%>
						<!-- 			<div class="card" style="width: 21rem;">
				<div class="card-body" style="background-color: #772f1a;"> -->
						<h5 class="card-title">Sweets</h5>
						<img src="static/img/ice-cream-2104979_640.jpg">
						<%-- <form action="processForm" method="GET"> --%>
						<br> Cant' get enough<input type="radio" name="sweet"
							value="5"> <br> Pretty Good<input type="radio"
							name="sweet" value="4"> <br> Don't Care<input
							type="radio" name="sweet" value="3" /> <br> Not my Favorite<input
							type="radio" name="sweet" value="2" /> <br> Can't stand it<input
							type="radio" name="sweet" value="1" /> <br><br>
						<!-- <button class="submit">Submit</button> -->
						<!-- When the user clicks this I want a new card to come in, I'm not sure how to implement this -->
						<%-- 			</form>
				</div>
			</div> --%>
						<!-- 			<div class="card" style="width: 21rem;">
				<div class="card-body" style="background-color: #772f1a;"> -->
						<h5 class="card-title">Spicy Food</h5>
						<img src="static/img/cayenne-peppers-2779828_640.jpg">
						<%-- <form action="processForm" method="GET"> --%>
						<br> Cant' get enough<input type="radio" name="spicy"
							value="5"> <br> Pretty Good<input type="radio"
							name="spicy" value="4"> <br> Don't Care<input
							type="radio" name="spicy" value="3"> <br> Not my
						Favorite<input type="radio" name="spicy" value="2"> <br>
						Can't stand it<input type="radio" name="spicy" value="1">
						<br><br>
						<!-- <button class="submit">Submit</button> -->
						<!-- When the user clicks this I want a new card to come in, I'm not sure how to implement this -->
						<%-- 	</form>

				</div>
			</div> --%>
						<!-- 	<div class="card" style="width: 21rem;">
				<div class="card-body" style="background-color: #772f1a;"> -->
						<h5 class="card-title">Fruits</h5>
						<img src="static/img/fruit-2305192_640.jpg">
						<%-- <form action="processForm" method="GET"> --%>
						<br> Cant' get enough<input type="radio" name="fruit"
							value="5"> <br> Pretty Good<input type="radio"
							name="fruit" value="4"> <br> Don't Care<input
							type="radio" name="fruit" value="3"> <br> Not
						myFavorite<input type="radio" name="fruit" value="2"> <br>
						Can't stand it<input type="radio" name="fruit" value="1">
						<br>
						<input type="hidden" name="id" value="${loggedInuser.id}">
						<button class="submit ${profile}" type="submit">Submit</button>
						<!-- When the user clicks this I want a new card to come in, I'm not sure how to implement this -->

					</form>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
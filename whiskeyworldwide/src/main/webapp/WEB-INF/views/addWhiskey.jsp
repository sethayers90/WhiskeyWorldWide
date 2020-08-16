<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.1.1">
<title>WhiskeyWorldWide|Admin|Add Whiskey</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/jumbotron/">
<link
	href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="static/css/cover.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="#">WhiskeyWorldWide | Add Whiskey</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link ${welcome}"
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
<body class="text-center">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">WhiskeyWorldWide | Add Whiskey</h3>
			</div>
		</header>

		<main role="main" class="inner cover" style="margin-top:10%;">
			<form:form action="addWhiskey" modelAttribute="products"
				method="post">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="manufacturer">Manufacturer</label>
						<form:input type="text" class="form-control"
							id="manufacturer" path="manufacturer" />
					</div>
					<div class="form-group col-md-6">
						<label for="Name">Name</label>
						<form:input type="name" class="form-control" id="name" path="name" />
					</div>
				</div>
				<div class="form-group">
					<label for="price">Price</label>
					<form:input type="text" class="form-control" id="inputFirstName"
						placeholder="29.99" path="price" />
				</div>
				<div class="form-group">
					<label for="bbqness">BBQness(yes that's a word)</label>
					
					<form:select class="form-control" id="bbqness" path="bbqness" >
						<option>5</option>
						<option>4</option>
						<option>3</option>
						<option>2</option>
						<option>1</option>
					</form:select>
				</div>
				<div class="form-group">
					<label for="fruityness">Fruityness</label>
				
					<form:select class="form-control" id="fruityness" path="fruityness">
						<option>5</option>
						<option>4</option>
						<option>3</option>
						<option>2</option>
						<option>1</option>
					</form:select>
				</div>
				<div class="form-group">
					<label for="spicyness">Spicyness</label>
	
					<form:select class="form-control" id="spicyness" path="spicyness">
						<option>5</option>
						<option>4</option>
						<option>3</option>
						<option>2</option>
						<option>1</option>
					
					</form:select>
				</div>
				<div class="form-group">
					<label for="sweetness">Sweetness</label>
					<form:select class="form-control" id="sweetness" path="sweetness">
						<option>5</option>
						<option>4</option>
						<option>3</option>
						<option>2</option>
						<option>1</option>
					</form:select>
				</div>
				<form:input class="form-control" type="text" path="url" id="url" placeholder="URL"/>
				<button type="submit" class="btn btn-primary submit">Submit</button>
			</form:form>
		</main>

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>WhiskeyWorldWide 2020</p>
			</div>
		</footer>
	</div>
</body>
</html>



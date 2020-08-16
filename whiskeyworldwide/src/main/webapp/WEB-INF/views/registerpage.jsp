<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<link href="static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>WhiskeyWorldWide|Register</title>
<link
	href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap"
	rel="stylesheet">
<link href="static/css/register.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>WhiskeyWorldWide | Register</h1>
		<form:form action="register" modelAttribute="users" method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Email</label>
					<form:input type="email" class="form-control" id="inputEmail4"
						path="email"  />
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Password</label> <form:input type="password"
						class="form-control" id="inputPassword4" path="password" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputFirstName">First Name</label> <form:input type="text"
					class="form-control" id="inputFirstName" placeholder="Jim"
					path="firstName" />
			</div>
			<div class="form-group">
				<label for="inputLastName">Last Name</label> <form:input type="text"
					class="form-control" id="inputLastName" placeholder="Beam"
					path="lastName" />
			</div>
			<div class="form-group">
				<label for="inputAddress">Address</label> <form:input type="text"
					class="form-control" id="inputAddress" placeholder="1234 Main St"
					path="address" />
			</div>
			<div class="form-group">
				<label for="inputAddress2">Address 2</label> <form:input type="text"
					class="form-control" id="inputAddress2" path="address1"
					placeholder="Apartment, studio, or floor"/>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputCity">City</label> <form:input type="text"
						class="form-control" id="inputCity" path="city" />
				</div>
				<div class="form-group col-md-4">
					<label for="form:inputState">State</label> <form:select id="inputState"
						class="form-control" path="state" >
						<form:option value="TEST">Choose...</form:option>
						<form:option value="AL">AL</form:option>
						<form:option value="AK">AK</form:option>
						<form:option value="AZ">AZ</form:option>
						<form:option value="AR">AR</form:option>
						<form:option value="CA">CA</form:option>
						<form:option value="CO">CO</form:option>
						<form:option value="CT">CT</form:option>
						<form:option value="DE">DE</form:option>
						<form:option value="DC">DC</form:option>
						<form:option value="FL">FL</form:option>
						<form:option value="GA">GA</form:option>
						<form:option value="HI">HI</form:option>
						<form:option value="ID">ID</form:option>
						<form:option value="IL">IL</form:option>
						<form:option value="IN">IN</form:option>
						<form:option value="IA">IA</form:option>
						<form:option value="KS">KS</form:option>
						<form:option value="KY">KY</form:option>
						<form:option value="LA">LA</form:option>
						<form:option value="ME">ME</form:option>
						<form:option value="MD">MD</form:option>
						<form:option value="MA">MA</form:option>
						<form:option value="MI">MI</form:option>
						<form:option value="MN">MN</form:option>
						<form:option value="MS">MS</form:option>
						<form:option value="MO">MO</form:option>
						<form:option value="MT">MT</form:option>
						<form:option value="NE">NE</form:option>
						<form:option value="NV">NV</form:option>
						<form:option value="NH">NH</form:option>
						<form:option value="NJ">NJ</form:option>
						<form:option value="NM">NM</form:option>
						<form:option value="NY">NY</form:option>
						<form:option value="NV">NV</form:option>
						<form:option value="ND">ND</form:option>
						<form:option value="OH">OH</form:option>
						<form:option value="OK">OK</form:option>
						<form:option value="OR">OR</form:option>
						<form:option value="PA">PA</form:option>
						<form:option value="RI">RI</form:option>
						<form:option value="SC">SC</form:option>
						<form:option value="SD">SD</form:option>
						<form:option value="TN">TN</form:option>
						<form:option value="TX">TX</form:option>
						<form:option value="UT">UT</form:option>
						<form:option value="VT">VT</form:option>
						<form:option value="WA">VA</form:option>
						<form:option value="WA">WA</form:option>
						<form:option value="WV">WV</form:option>
						<form:option value="WI">WI</form:option>
						<form:option value="WY">WY</form:option>  
						
					</form:select>
				</div>
				<div class="form-group col-md-2">
					<label for="finputZip">Zip</label> <form:input type="text"
						class="form-control" id="form:inputZip" path="zip" />
				</div>
			</div>
			<button type="submit" class="btn btn-primary ${loginpage}">Sign
				up</button>
		</form:form>
	</div>
</body>
</html>
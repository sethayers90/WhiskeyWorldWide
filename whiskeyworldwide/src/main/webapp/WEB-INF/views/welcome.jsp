<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>WhiskeyWorldWide|Home</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/jumbotron/">
	<link href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap" rel="stylesheet">
    <!-- Bootstrap core CSS -->
<link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
       
      
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="static/css/jumbotron.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <a class="navbar-brand" href="#">WhiskeyWorldWide | Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link ${about}" href="about">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link ${contact}" href="contact">Contact</a>
      </li>
        <li class="nav-item">
        <a class="nav-link ${loginpage}" href="loginpage">Login</a>
    </ul>
  </div>
</nav>

<main role="main">

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">Welcome to WhiskeyWorldWide!</h1>
      <p>WhiskeyWorldWide was designed to introduce you to new whiskeys to broden your horizons</p>
      <p><a class="btn btn-primary btn-lg ${about}" href="about" role="button">Learn more &raquo;</a></p>
    </div>
  </div>

  <div class="container">
    <!-- Example row of columns -->
    <div class="row">
      <div class="col-md-4">
        <h2>Quiz</h2>
        <img class="small-pic"src="static/img/homepage1.jpg">
        <p>Take our very short quiz that will help us to suggest the best possible whiskey</p>
        <p><a class="btn btn-secondary ${quiz}" href="quiz" role="button">Quiz &raquo;</a></p>
      </div>
      <div class="col-md-4">
        <h2>About Us</h2>
        <img class="small-pic"src="static/img/homepage2.jpg">
        <p>Learn about the team behind this app</p>
        <p><a class="btn btn-secondary ${about}" href="about" role="button">About Us &raquo;</a></p>
      </div>
      <div class="col-md-4">
        <h2>Contact</h2>
        <img class="small-pic"src="static/img/homepage3.jpg">
        <p>Contact the team behind this app</p>
        <p><a class="btn btn-secondary ${contact}" href="contact" role="button">Contact Us &raquo;</a></p>
      </div>
    </div>

    <hr>

  </div> <!-- /container -->

</main>

<footer class="container">
  <p>&copy; WhiskeyWorldWide 2020</p>
</footer>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="static/vendor/js/jquery.slim.min.js"><\/script>')</script><script src="static/vendor/js/bootstrap.bundle.min.js"></script>
</html>

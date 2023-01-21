<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentification</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>
    body {
      padding: 25px;
      background: url(ranger-4df6c1b6.png);
      background-repeat: no-repeat;
      background-size: 1600px 2100px ;
    }
	</style>
	<script>
		function myFunction() {
			location.href = 'espaceAdmin.html';
		}
		</script>
		<style>.divider:after,
			.divider:before {
			content: "";
			flex: 1;
			height: 1px;
			background: #eee;
			}
			.h-custom {
			height: calc(100% - 73px);
			}
			@media (max-width: 450px) {
			.h-custom {
			height: 100%;
			}
			}
			.col-md-8 col-lg-6 col-xl-4 offset-xl-1{
				padding-top:200px;
			}</style>
</head>
<body>


 
  <section class="vh-100">
	<div class="container-fluid h-custom">
	  <div class="row d-flex justify-content-center align-items-center h-100">
		<div class="col-md-9 col-lg-6 col-xl-5">
		  <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
			class="img-fluid" alt="Sample image">
		</div>
		<br/>
		<br/>
		<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
		  <form action="Lo">
	
  
			<!-- Email input -->
			<div class="form-outline mb-4">
			  <input type="email" name="mail" id="form3Example3" class="form-control form-control-lg"
				placeholder="Ecrire votre email" />
			  <label class="form-label" for="form3Example3">Adresse email</label>
			</div>
  
			<!-- Password input -->
			<div class="form-outline mb-3">
			  <input type="password" name="mdp" id="form3Example4" class="form-control form-control-lg"
				placeholder="Enter password" />
			  <label class="form-label" for="form3Example4">Mot de passe</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" name="type" type="radio" name="exampleRadios" id="exampleRadios1" value="Admin" checked>
				<label class="form-check-label" for="exampleRadios1">
				Admin
				</label>
			  </div>
			  <div class="form-check">
				<input class="form-check-input" name="type" type="radio" name="exampleRadios" id="exampleRadios2" value="Etudiant">
				<label class="form-check-label" for="exampleRadios2">
				  Etudiant
				</label>
			  </div>
			
  
			<div class="text-center text-lg-start mt-4 pt-2">
				<input type="submit" value="Login" class="btn btn-primary btn-lg"
				style="padding-left: 2.5rem; padding-right: 2.5rem;" id="button-1"/>
			</div>
  
		  </form>
		</div>
	  </div>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>

	<div class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
	  <!-- Copyright -->
	  <div class="text-white mb-3 mb-md-0">
		Copyright © 2022. All rights reserved.
	  </div>
	  <!-- Copyright -->
  
	  <!-- Right -->
	  <div>
		<a href="#!" class="text-white me-4">
		  <i class="fab fa-facebook-f"></i>
		</a>
		<a href="#!" class="text-white me-4">
		  <i class="fab fa-twitter"></i>
		</a>
		<a href="#!" class="text-white me-4">
		  <i class="fab fa-google"></i>
		</a>
		<a href="#!" class="text-white">
		  <i class="fab fa-linkedin-in"></i>
		</a>
	  </div>
	  <!-- Right -->
	</div>
  </section>
  <div style="visibility:visible;position:absolute;top:200px;left:30%;z-index: 1000;padding:60px;background-color: white;
border-style: solid;border-radius: 10px;">
<h1 style="color: rgb(67, 143, 143);">Erruer de login</h1>
<div class="text-center text-lg-start mt-4 pt-2">
			
<a href="index.jsp" ><button class="btn btn-primary btn-lg"
				style="padding-left: 2.5rem; padding-right: 2.5rem;" id="button-1" >OK</button></a>
				</div>
</div>
</body>
</html>
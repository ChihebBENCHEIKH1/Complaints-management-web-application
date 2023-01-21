<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Espace Admin</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>@import '~mdb-ui-kit/css/mdb.min.css';
</style>
<style>@import url("https://fonts.googleapis.com/css2?family=Poppins:weight@100;200;300;400;500;600;700;800&display=swap");


  body{
   background-color:#eee;
   font-family: "Poppins", sans-serif;
   font-weight: 300;
  }

  .height{
   height: 30px;
  }
  

  .search{
  position: relative;
  box-shadow: 0 0 40px rgba(51, 51, 51, .1);
    
  }
  
  
  .search input{

   height: 60px;
   text-indent: 25px;
   border: 2px solid #d6d4d4;


  }

  .search input:focus{

   box-shadow: none;
   border: 2px solid blue;


  }

  .search .fa-search{

   position: absolute;
   top: 20px;
   left: 16px;

  }

  .search button{

   position: absolute;
   top: 5px;
   right: 5px;
   height: 50px;
   width: 110px;
   background: blue;

  }</style>
<script>import * as mdb from 'mdb-ui-kit'; // lib
  import { Input } from 'mdb-ui-kit'; // module</script>
<style>
    body {
      padding: 25px;
      background: url(ranger-4df6c1b6.png);
      background-repeat: no-repeat;
      background-size: 1600px 2100px ;
    }
    #pad {
  color: hsl(0, 0%, 28%);
  font-size: 50px;
  font-weight: bold;
  font-family: monospace;
  letter-spacing: 7px;
  cursor: pointer;
  text-transform: uppercase;
}

#pad {
  padding-left: 300px;
  padding-bottom: 50px;
  padding-top: 50px;
  background: linear-gradient(to right, hsl(0, 0%, 30%) 0, hsl(0, 0%, 100%) 10%, hsl(0, 0%, 30%) 20%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  animation: shine 3s infinite linear;
}

@keyframes shine {
  0% {
    background-position: 0;
  }
  60% {
    background-position: 600px;
  }
  100% {
    background-position: 600px;
  }
}
</style>
	<script>
		function myFunction1() {
		  location.replace("espaceEtudiant.html")
		}
		</script>


</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Barre de navigation</a>
      <button
        class="navbar-toggler"
        type="button"
        data-mdb-toggle="collapse"
        data-mdb-target="#navbarNavAltMarkup"
        aria-controls="navbarNavAltMarkup"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <a class="nav-link active" aria-current="page" href="espaceAdminEtud.jsp" >Etudiant</a>
          <a class="nav-link" href="espaceAdmin.jsp">Admin</a>
          <a class="nav-link" href="espaceAdminType.jsp">Type reclamation</a>
          
        </div>
      </div>
    </div>
  </nav>
 <h1 id="pad">Liste des etudiants</h1>
<form action="Recherche" method="post" style="margin-bottom: 80px">

  <div class="container">

    <div class="row height d-flex justify-content-center align-items-center">

      <div class="col-md-8">

        <div class="search">
          <i class="fa fa-search"></i>
          <input type="text" class="form-control" name="rechercheEtud" placeholder="recherche par nom"> <button class="btn btn-primary" type="submit" name="action" value="Recherche Etudiant">Recherche</button>

        </div>
        
      </div>
      
    </div>
</div>
</form>
<table class= "table table-hover">
    <thead  >
      <tr>
        <th scope="col">id</th>
        <th scope="col">Nom</th>
        <th scope="col">Prénom</th>
        <th scope="col">Mail</th>
        <th scope="col">Mot de passe </th>
        <th scope="col">Actif</th>
        <th scope="col">Activer/Désactiver</th>
        <th scope="col">Supprimer</th>
        <th scope="col">Mise à jour</th>



      </tr>
      <c:forEach var="c" items="${listeEtudiant}" >
  <tr> 
      <td ><c:out value="${c.getId()}"/></td>
      <td ><c:out value="${c.getNom()}"/></td>
       <td ><c:out value="${c.getPrenom()}"/></td>
       <td ><c:out value="${c.getEmail()}"/></td>
      <td ><c:out value="${c.getPassword()}"/></td>
       <td ><c:out value="${c.getActif()}"/></td>
       <td><form action="Admin" method="post">
		   <input class=" btn btn-mini btn-success" name="action" type="submit" value="Activer" id="button-7"/>
		   <input class="btn btn-mini  btn-warning" name="action" type="submit" value="Desactiver" id="button-8"/>
       		<input type="hidden" name="idValue"value="${c.getId()}" id="button-3"/>
       	</form></td>
       <td>
        <form action="Admin" method="post">
			<input class="btn btn-mini btn-danger" type="submit" name="action" value="Supprimer" id="button-9"/>
       <input type="hidden" name="idValue"value="${c.getId()}" id="button-3"/></form></td>
       <td>
        <form action="Admin" method="post" >
			<input type="submit" class="btn btn-mini btn-info	" name="action" id="formButton" value="Modifier Etudiant" id="button-10"/>
       <input type="hidden" name="idValue"value="${c.getId()}" id="button-3"/>
    </form></td>
  </tr>
</c:forEach>
    </thead>
   
  </table>
  <div style="visibility:visible;position:absolute;top:200px;left:35%;z-index: 1000;padding:60px;background-color: white;
border-style: solid;border-radius: 10px;">
<h1 style="color: rgb(67, 143, 143);">Mise à jour d'un étudiant</h1>
<c:forEach var ="c" items="${EtudiantUpdate}">
<form action="Admin" method="post">
<input id="input-2" value="${c.getId()}" name="id" placeholder="Text" type="hidden"/>
      <div class="form-group col-md-6">
        <label for="inputEmail4">Nom:</label>
        <input type="text" value="${c.getNom()}" name="nom" class="form-control" id="inputEmail4" placeholder="Nom">
      </div>
      <div class="form-group col-md-6">
        <label for="inputEmail4">Prénom:</label>
        <input type="text" value="${c.getPrenom()}" name="prenom" class="form-control" id="inputEmail4" placeholder="Prénom">
      </div>
       <div class="form-group col-md-6">
        <label for="inputEmail4">Mail:</label>
        <input type="text" value="${c.getEmail()}" name="mail" class="form-control" id="inputEmail4" placeholder="Mail">
      </div>
      <div class="form-group col-md-6">
      <label for="inputAddress2">Mot de passe </label>
      <input type="password" value="${c.getPassword()}" name="mdp" class="form-control" id="inputAddress2" placeholder="Mot de passe ">
    </div>
	<label for="cars">Actif :</label>
	<select name="actif">
	  <option value="oui">oui</option>
	  <option value="non">non</option>
	</select><br><br>
	<input type="submit" class="btn btn-primary" name="action" value="Update Etudiant" id="button-4"/>
</form>
</c:forEach>
</div>
</body>
</html>
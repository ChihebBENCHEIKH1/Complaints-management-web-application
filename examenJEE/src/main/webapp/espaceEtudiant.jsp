<%@page import="javax.persistence.EntityManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Espace Etudiant</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>@import '~mdb-ui-kit/css/mdb.min.css';
</style>
<!-- MDB -->
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.1/mdb.min.js"
></script>
<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.1/mdb.min.css"
  rel="stylesheet"
/>
 <style>
body {
  padding: 25px;
  background: url(ranger-4df6c1b6.png);
  background-repeat: no-repeat;
  background-size: 1600px 2100px ;
}
</style> 
</head>
<body>
<h1 id="pad">Liste des reclamations</h1>
<br/>
<form action="Recherche" method="post"><div class="input-group">
  <input type="search" class="form-control rounded" name="rechercheReclamation" placeholder="recherche" aria-label="Search" aria-describedby="search-addon" />
  <button type="submit" name="action" value="rechercherec" class="btn btn-outline-primary">search</button>
</div>
</form>
<br/>
<table class="table">
      <thead>
        <tr>
          <th scope="col">id</th>
          <th scope="col">description</th>
          <th scope="col">titre</th>
        </tr>
      </thead>
  

<c:forEach var="c" items="${listeReclamationDunEtudiant}" >
  <tr>
      <td ><c:out value="${c.getId()}"/></td>
      <td ><c:out value="${c.getTitre()}"/></td>
       <td ><c:out value="${c.getDescription()}"/></td>
  </tr>
</c:forEach> 
</table>
<br/>
<div id="2" style="visibility:hidden;position:absolute;top:200px;left:32%;z-index: 1000;padding:60px;background-color: white;
border-style: solid;border-radius: 10px;" >
<h1 style="color: rgb(67, 143, 143);">Ajouter une Reclamation</h1>

<form action="AddReclamation" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Titre</label>
    <input type="text" class="form-control" name="titre" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Description</label>
    <input type="text" class="form-control" name="desc" id="exampleInputPassword1">
  </div>
  <select name="type" id="cars">
    <c:forEach var="c" items="${listeTypeReclamation}">
      <option><c:out value="${c.getType()}"/></option>
    </c:forEach>
      </select>
      <br><br>
  <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
</div>
<button style="margin-left:85%" class="btn btn-primary" onclick="myFunction('2')">Ajouter type</button>
</body>
<script type="text/javascript">
function myFunction(id)
{
	var x = document.getElementById(id);
	  if (x.style.visibility === "hidden") {
	    x.style.visibility = "visible";
	  } else {
	    x.style.visibility = "hidden";
	  }
	}
</script>
</html>

<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Movies</title>
<style>
div.align {
	margin: 0 400px;
}

h1 {
	margin: 100px 0 50px 400px;
}
</style>
<link rel="stylesheet" type="text/CSS" href="styles/Mstyle.css">
<script src="js/Mscript.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/film-icon.jpg"> <a
			href="ShowMoviesListAdminServlet">Movies</a>
	</div>
	<h1>Edit Movies</h1>
	<div class="align">
		<div class="body-content-color">
			<form action="EditMoviesServlet" onsubmit="return validation()"
				name="moviesForm" method="post">
				<div class="form-field-spacing">
					<label for="name1">Title</label><br> <input type="text"
						value="${movies.title}" class="text-box text-box-title"
						name="title" id="name1" size="134">
				</div>
				<div class="form-field-spacing">
					<label for="gross">Gross($)</label><br> <input type="text"
						value="${movies.gross}" class="text-box" name="gross" id="gross">
				</div>
				<div class="form-field-spacing">
					<label for="instock">Active</label><br> <input class="radio"
						type="radio" name="instock" id="instock" value="yes"
						<c:if test="${movies.active }">checked</c:if>>Yes <input
						class="radio" type="radio" name="instock" id="instock" value="no"
						<c:if
							test="${!movies.active }">checked</c:if>>No
				</div>
				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date of Launch</label><br> <input
						value="<fmt:formatDate type="date" pattern='dd/MM/yyyy'
							value='${movies.dateOfLaunch}' />"
						type="text" class="text-box" name="dateOfLaunch" id="">
				</div>
				<div class="form-field-spacing">
					<label for="genre">Genre</label><br> <select name="genre"
						class="dropdown" id="">
						<option value="${movies.genre}">${movies.genre}</option>
						<option value="science fiction">Science Fiction</option>
						<option value="super hero">Super Hero</option>
						<option value="romance">Romance</option>
						<option value="comedy">Comedy</option>
						<option value="adventure">Adventure</option>
						<option value="thriller">Thriller</option>
					</select>
				</div>
				<br> <br>
				<div class="form-field-spacing">
					<label for=""></label> <input type="checkbox" name="teaser" id=""
						<c:if test="${movies.teaser}">checked</c:if>>Has Teaser
				</div>
				<br> <br>
				<div>
					<input type="hidden" name="id" value="${movies.id}"> <input
						type="submit" class="button success-button" value="Save">
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<p>Copyright @ 2019</p>
	</div>
</body>
</html>
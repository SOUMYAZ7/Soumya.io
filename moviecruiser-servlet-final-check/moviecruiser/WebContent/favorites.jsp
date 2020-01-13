<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Favorites</title>
<link rel="stylesheet" type="text/CSS" href="styles/Mstyle.css">
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/film-icon.jpg"> <a
			href="ShowFavoritesServlet">Favorites</a> <a
			href="ShowMoviesListCustomerServlet">Menu</a>
	</div>
	<div class="page-title">Favorites</div>
	<c:if test="${deleteFavoritesStatus}">
		<div class="success-message">Movies removed from Favorites Successfully</div>
	</c:if>
	<table cellpadding="20px">
		<tr>
			<th>Title</th>
			<th>Gross</th>
			<th>Genre</th>
			<th></th>
		</tr>
		<c:forEach items="${favorites.moviesList}" var="movies">
			<tr>
				<td>${movies.title}</td>
				<td>$<fmt:formatNumber value="${movies.gross}"
						pattern="#,##,##,##,###" />
				</td>
				<td>${movies.genre}</td>
				<td><a style = "color : black" href="RemoveFavorites?id=${movies.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td><b>No.of Favorites:</b></td>
			<td>${favorites.total}</td>
			<td></td>
		</tr>
	</table>
	<div class="footer">
		<p>Copyright @ 2019</p>
	</div>
</body>
</html>
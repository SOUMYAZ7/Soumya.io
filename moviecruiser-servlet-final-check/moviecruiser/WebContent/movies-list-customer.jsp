<%@ page language="java" isELIgnored = "false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
<link rel="stylesheet" type="text/CSS" href="styles/Mstyle.css">
</head>
<body>
	<form action="ShowMoviesListAdminServlet" method="get">
	 <div class="topnav">
            <div class="home">
                Movie Cruiser
            </div>
            <img src="images/film-icon.jpg">
            <a href="ShowFavoritesServlet">Favorites</a>
            <a href="ShowMoviesListCustomerServlet">Movies</a>   
        </div>
        <div class = "page-title">Movies</div>
        <c:if test = "${addFavoritesStatus}">
        	<div class = "success-message">Movies added to favorites Successfully</div>
        </c:if>
        <table cellpadding="20px">
            <tr>    
                <th>Title</th>
                <th>Has Teaser</th>
                <th>Gross</th>
                <th>Genre</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${moviesList}" var="movies">
            <tr>    
                <td>${movies.title}</td>
                <td><c:if test="${movies.teaser eq 'true'}">Yes</c:if>
						<c:if test="${movies.teaser eq 'false'}">No</c:if></td>
				<td>$<fmt:formatNumber type="number"
							pattern="##,##,##,###" value='${movies.gross}' /></td>
				<td>${movies.genre}</td>
				<td><a style = "color : black"  href="AddToFavoritesServlet?id=${movies.id}">Add to Favorites</a></td>
            </tr>
            </c:forEach>
            </table>
            <div class="footer">
                <p>Copyright @ 2019</p>
            </div>
	</form>
</body>
</html>
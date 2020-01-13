<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Items</title>
<link rel="stylesheet" type="text/CSS" href="styles/style.css">
</head>
<body>
	<form action="ShowMenuItemListAdminServlet" method="get">
		<div class="topnav">
			<div class="home">truYum</div>
			<img src="images/truyum-logo-light.png"> 
			<a href="ShowMenuItemListAdminServlet">Menu</a>
		</div>
		<div class="page-title">Menu Items</div>
		<table class="body-content-color">
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Category</th>
				<th>Free Delivery</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menuItem">
				<tr>
					<td>${menuItem.name}</td>
					<td>Rs.<fmt:formatNumber type="number"
							pattern="##,##,##,###.00" value='${menuItem.price}' /></td>
					<td><c:if test="${menuItem.active eq 'true'}">Yes</c:if> <c:if
							test="${menuItem.active eq 'false'}">No</c:if></td>
					<td><fmt:formatDate type="date" pattern='dd/MM/yyyy'
							value='${menuItem.dateOfLaunch}' /></td>
					<td>${menuItem.category}</td>
					<td><c:if test="${menuItem.freeDelivery eq 'true'}">Yes</c:if>
						<c:if test="${menuItem.freeDelivery eq 'false'}">No</c:if></td>
					<td><a style = "color : black"  href="ShowEditMenuItemServlet?id=${menuItem.id}">Edit</a></td>
					
				</tr>
			</c:forEach>
		</table>
		<div class="footer">
			<h3>Copyright @ 2019</h3>
		</div>
	</form>
</body>
</html>
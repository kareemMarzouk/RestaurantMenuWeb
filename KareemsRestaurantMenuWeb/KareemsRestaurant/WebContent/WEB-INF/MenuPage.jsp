<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Menu</title>
</head>
<h2>Welcome to Kareem's Restaurant</h2>

<body>

<ul>
<c:forEach items="${menu}" var="current">
	<li>${current.id} ${current.name} <fmt:formatNumber currencySymbol="$" type="currency">${current.price}</fmt:formatNumber></li>	
</c:forEach>
 </ul>
 
<form method="POST" action=MenuServlet>
Enter your name: 
<input type="text" name="name">
<input type="submit" value="Submit">
</form>

<p>${flag}</p>

</body>


</html>
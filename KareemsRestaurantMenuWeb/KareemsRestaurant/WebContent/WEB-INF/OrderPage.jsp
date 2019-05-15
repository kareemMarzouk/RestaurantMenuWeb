<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h1>Building the order: ${orderName}${orderNo}</h1>
<p>Please enter the quantity of each item you would like to order and press order when you have finished selection.</p>
</head>
<body>

<table border=1>
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Quantity</th>
</tr>

<form method="POST" action=OrderServlet>
<c:forEach items="${menu}" var="current">
	<tr>
		<td>${current.id}</td>
		<td>${current.name}</td>
		<td><fmt:formatNumber currencySymbol="$" type="currency">${current.price}</fmt:formatNumber></td>
		<td>
		<select name = "${current.id}">
		<option value="0"></option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
		<option value="10">10</option>
		</select>
		</td>
	</tr>
 </c:forEach>
 <tr>
 <td></td> <td></td> <td></td>
 <td>
<input type="submit" value="Order">
</form>
 </td>

 </tr>
 
</table>



</body>
</html>
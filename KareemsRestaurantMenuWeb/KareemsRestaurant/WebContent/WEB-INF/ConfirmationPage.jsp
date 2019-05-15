<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<h1>${orderName}${orderNo}, please confirm your order</h1>
</head>
<body>

<table border=1>

<tr>
	<th>Number</th>
	<th>Name</th>
	<th>Unit Price</th>
	<th>Quantity</th>
	<th>Cost</th>
</tr>


<c:forEach items="${order_items}" var="current">
<tr>
	<td>${current.id}</td>
	<td>${current.name}</td>
	<td> <fmt:formatNumber currencySymbol="$" type="currency">${current.unit}</fmt:formatNumber> </td>
	<td>${current.quantity}</td>
	<td><fmt:formatNumber currencySymbol="$" type="currency">${current.total}</fmt:formatNumber></td>
</tr>
</c:forEach>


<tr>
<td></td>
<td>Total cost:</td>
<td></td>
<td></td>
<td><fmt:formatNumber currencySymbol="$" type="currency">${order.total} </fmt:formatNumber></td>
</tr>

</table>


<form action = ConfirmationServlet method = "GET">
	<input name= "button" type="submit" value = "Confirm" >
	<input  name= "button" type="submit" value = "Cancel">
	<br>
</form>


</body>
</html>
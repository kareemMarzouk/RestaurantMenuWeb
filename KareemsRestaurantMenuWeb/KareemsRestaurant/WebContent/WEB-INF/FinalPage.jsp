<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>


<body>

 <c:if test = "${Status == 1}">
         <h1>Thank you for visiting Kareem's Restaurant</h1>
         <br> 
         <h3>Order ${orderName}${orderNo} will ready within 20 minutes, by ${time} </h3>
</c:if>

 <c:if test = "${Status == 0}">
         <h3>Order ${orderName}${orderNo} has been cancelled.</h3>
</c:if>

</body>
</html>
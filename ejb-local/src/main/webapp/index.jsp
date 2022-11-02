<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>EJB</title>
</head>
<body>

<h2>Hello, EJB Bean</h2>
<h3>Message: ${message}</h3>

<ul>
<c:forEach items="${lists}" var="item">
    <li>${item.name}</li>
</c:forEach>
</ul>
</body>
</html>
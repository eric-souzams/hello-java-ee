<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Products</title>
</head>
<body>
    <c:if test="${username.present}">
        <h3>Hello, ${username.get()}</h3>
        <h3>Hello, ${requestScope.username.get()}</h3>
        <p><a href="${pageContext.request.contextPath}/products/form">Create Product [+]</a></p>
    </c:if>

    <h1>List Products</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>

            <c:if test="${username.present}">
                <th>Price</th>
                <th>Add +</th>
                <th>Edit</th>
                <th>Delete</th>
            </c:if>
        </tr>

        <c:forEach items="${products}" var="prod">
            <tr>
                <td>${prod.id}</td>
                <td><c:out value="${prod.name}" /></td>
                <td>${prod.category.name}</td>
                <c:if test="${username.present}">
                    <td>${prod.price}</td>
                    <td><a href="${pageContext.request.contextPath}/add-cart?id=${prod.id}">Add to cart</a></td>
                    <td><a href="${pageContext.request.contextPath}/products/form?id=${prod.id}">Edit</a></td>
                    <td><a onclick="return confirm('Have sure?');" href="${pageContext.request.contextPath}/products/delete?id=${prod.id}">Delete</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
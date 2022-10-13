<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
</head>
<body>
<h1>Cart</h1>

<c:choose>
    <c:when test="${sessionScope.cart == null || sessionScope.cart.items.isEmpty()}">
        <p>Cart is empty.</p>
    </c:when>

    <c:otherwise>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
            </tr>

            <c:forEach items="${sessionScope.cart.items}" var="item">
                <tr>
                    <td>${item.product.id}</td>
                    <td>${item.product.name}</td>
                    <td>${item.product.price}</td>
                    <td>${item.quantity}</td>
                    <td>${item.totalPrice}</td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="4" style="text-align: right;">Total:</td>
                <td>${sessionScope.cart.total}</td>
            </tr>
        </table>
    </c:otherwise>
</c:choose>

<p><a href="${pageContext.request.contextPath}/index.html"><-- Back</a></p>
<p><a href="${pageContext.request.contextPath}/products">Keep Buying --></a></p>
</body>
</html>
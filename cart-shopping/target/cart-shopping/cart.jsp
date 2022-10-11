<%@page contentType="text/html" pageEncoding="UTF-8" import="org.jakarta.cart.shopping.models.*" %>
<% Cart cart = (Cart) session.getAttribute("cart"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
</head>
<body>
<h1>Cart</h1>
<% if(cart == null || cart.getItems().isEmpty()) { %>
    <p>Cart is empty.</p>
<% } else { %>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>

        <% for(CartItem item : cart.getItems()) { %>
            <tr>
                <td><%=item.getProduct().getId()%></td>
                <td><%=item.getProduct().getName()%></td>
                <td><%=item.getProduct().getPrice()%></td>
                <td><%=item.getQuantity()%></td>
                <td><%=item.getTotalPrice()%></td>
            </tr>
        <% } %>

        <tr>
            <td colspan="4" style="text-align: right;">Total:</td>
            <td><%=cart.getTotal()%></td>
        </tr>
    </table>
<% } %>

<p><a href="<%=request.getContextPath()%>/index.html"><-- Back</a></p>
<p><a href="<%=request.getContextPath()%>/products">Keep Buying --></a></p>

</body>
</html>
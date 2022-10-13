<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*, org.jakarta.cart.shopping.models.*"%>
<%
List<Product> products = (List<Product>) request.getAttribute("products");
Optional<String> username = (Optional<String>) request.getAttribute("username");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Products</title>
</head>
<body>
  <h1>List Products</h1>
  <% if (username.isPresent()) { %>
    <h3>Hello, <%=username%></h3>
    <p><a href="<%=request.getContextPath()%>/products/form">Create Product [+]</a></p>
  <%}%>
  <table border="1">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Type</th>

      <% if (username.isPresent()) { %>
        <th>Price</th>
        <th>Add +</th>
        <th>Edit</th>
        <th>Delete</th>
      <%}%>
    </tr>

    <% for (Product prod : products) { %>
      <tr>
        <td><%=prod.getId()%></td>
        <td><%=prod.getName()%></td>
        <td><%=prod.getCategory().getName()%></td>
        <% if (username.isPresent()) { %>
          <td><%=prod.getPrice()%></td>
          <td><a href="<%=request.getContextPath()%>/add-cart?id=<%=prod.getId()%>"> Add to cart </a></td>
          <td><a href="<%=request.getContextPath()%>/products/form?id=<%=prod.getId()%>"> Edit </a></td>
          <td><a onclick="return confirm('Have sure?');" href="<%=request.getContextPath()%>/products/delete?id=<%=prod.getId()%>"> Delete </a></td>
        <%}%>
      </tr>
    <%}%>
  </table>
</body>
</html>
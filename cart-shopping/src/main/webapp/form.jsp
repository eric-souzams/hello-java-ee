<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*, java.time.format.*, org.jakarta.cart.shopping.models.*"%>
<%
List<Category> categories = (List<Category>) request.getAttribute("categories");
Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
Product product = (Product) request.getAttribute("product");
String date = product.getCreatedAt() != null ? product.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : "";
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Product Form</title>
    </head>
    <body>
        <h1>Product Form</h1>
        <form action="<%=request.getContextPath()%>/products/form" method="post">
            <div>
                <label for="name">Name</label>
                <div>
                    <input type="text" name="name" id="name" value="<%=product.getName() != null ? product.getName() : ""%>">
                </div>
                <% if (errors != null && errors.containsKey("name")) { %>
                    <span style="color: red;"><%=errors.get("name")%></span>
                <%}%>
            </div>

            <div>
                <label for="price">Price</label>
                <div>
                    <input type="number" name="price" id="price" value="<%=product.getPrice() != 0 ? product.getPrice() : ""%>">
                </div>
                <% if (errors != null && errors.containsKey("price")) { %>
                    <span style="color: red;"><%=errors.get("price")%></span>
                <%}%>
            </div>

            <div>
                <label for="sku">Sku</label>
                <div>
                    <input type="text" name="sku" id="sku" value="<%=product.getSku() != null ? product.getSku() : ""%>">
                </div>
                <% if (errors != null && errors.containsKey("sku")) { %>
                    <span style="color: red;"><%=errors.get("sku")%></span>
                <%}%>
            </div>

            <div>
                <label for="created_at">Register Date</label>
                <div>
                    <input type="date" name="created_at" id="created_at" value="<%=date%>">
                </div>
                <% if (errors != null && errors.containsKey("created_at")) { %>
                    <span style="color: red;"><%=errors.get("created_at")%></span>
                <%}%>
            </div>

            <div>
                <label for="category">Category</label>
                <div>
                    <select name="category" id="category">
                        <option value="">-- select --</option>
                        <% for (Category category : categories) { %>
                            <option value="<%=category.getId()%>" <%=category.getId().equals(product.getCategory().getId()) ? "selected" : ""%> ><%=category.getName()%></option>
                        <%}%>
                    </select>
                </div>
                <% if (errors != null && errors.containsKey("category")) { %>
                    <span style="color: red;"><%=errors.get("category")%></span>
                <%}%>
            </div>

            <div>
                <div>
                    <input type="submit" value="<%=(product.getId() != null && product.getId() > 0) ? "Update" : "Save"%>">
                </div>
            </div>

            <input type="hidden" name="id" value="<%=product.getId()%>">
        </form>
    </body>
</html>
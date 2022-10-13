<%@page contentType="text/html" pageEncoding="UTF-8" import="java.time.format.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Product Form</title>
    </head>
    <body>
        <h1>Product Form</h1>
        <form action="${pageContext.request.contextPath}/products/form" method="post">
            <div>
                <label for="name">Name</label>
                <div>
                    <input type="text" name="name" id="name" value="${product.name != null ? product.name : ""}">
                </div>
                <c:if test="${errors != null && errors.containsKey('name')}">
                    <span style="color: red;"><${errors.get("name")}></span>
                </c:if>
            </div>

            <div>
                <label for="price">Price</label>
                <div>
                    <input type="number" name="price" id="price" value="${product.price > 0 ? product.price : ""}">
                </div>
                <c:if test="${errors != null && errors.containsKey('price')}">
                    <span style="color: red;"><${errors.get("price")}></span>
                </c:if>
            </div>

            <div>
                <label for="sku">Sku</label>
                <div>
                    <input type="text" name="sku" id="sku" value="${product.sku != null ? product.sku : ""}">
                </div>
                <c:if test="${errors != null && errors.containsKey('sku')}">
                    <span style="color: red;"><${errors.get("sku")}></span>
                </c:if>
            </div>

            <div>
                <label for="created_at">Register Date</label>
                <div>
                    <input type="date" name="created_at" id="created_at" value="${product.createdAt != null ? product.createdAt.format(DateTimeFormatter.ofPattern('yyyy-MM-dd')) : ""}">
                </div>
                <c:if test="${errors != null && errors.containsKey('created_at')}">
                    <span style="color: red;"><${errors.get("created_at")}></span>
                </c:if>
            </div>

            <div>
                <label for="category">Category</label>
                <div>
                    <select name="category" id="category">
                        <option value="">-- select --</option>
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.id}" ${category.id.equals(product.category.id) ? "selected" : ""}>${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <c:if test="${errors != null && errors.containsKey('category')}">
                    <span style="color: red;"><${errors.get("category")}></span>
                </c:if>
            </div>

            <div>
                <div>
                    <input type="submit" value="${(product.id != null && product.id > 0) ? "Update" : "Save"}">
                </div>
            </div>

            <input type="hidden" name="id" value="${product.id}">
        </form>
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%
Map<String, String> errors = (Map<String, String>)request.getAttribute("errors");
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Form Register</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <h3>Form to Register</h3>
        <div class="px-5">
            <form action="/form/register" method="post">
                <div class="row mb-3">
                    <label for="username" class="col-form-label col-sm-2">Username</label>
                    <div class="col-sm-4">
                        <input type="text" id="username" name="username" class="form-control" value="${param.username}">
                        <% if (errors != null && errors.containsKey("username")) {
                                out.println("<small style='color: red;'>" + errors.get("username") + "</small>");
                        }%>
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="password" class="col-form-label col-sm-2">Password</label>
                    <div class="col-sm-4">
                        <input type="password" id="password" name="password" class="form-control">
                        <% if (errors != null && errors.containsKey("password")) {
                            out.println("<small style='color: red;'>" + errors.get("password") + "</small>");
                        }%>
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="email" class="col-form-label col-sm-2">E-mail</label>
                    <div class="col-sm-4">
                        <input type="email" id="email" name="email" class="form-control" value="${param.email}">
                        <% if (errors != null && errors.containsKey("email")) {
                            out.println("<small style='color: red;'>" + errors.get("email") + "</small>");
                        }%>
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="pais" class="col-form-label col-sm-2"></label>
                    <div class="col-sm-4">
                        <select name="pais" id="pais" class="form-select">
                            <option value="">-- select --</option>
                            <option value="ES" ${param.pais.equals("ES") ? "selected" : ""}>Spanish</option>
                            <option value="MX" ${param.pais.equals("MX") ? "selected" : ""}>Mexico</option>
                            <option value="US" ${param.pais.equals("US") ? "selected" : ""}>Unite States</option>
                            <option value="BR" ${param.pais.equals("BR") ? "selected" : ""}>Brazil</option>
                        </select>
                        <% if (errors != null && errors.containsKey("pais")) {
                            out.println("<small style='color: red;'>" + errors.get("pais") + "</small>");
                        }%>
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="languages" class="col-form-label col-sm-2">Languages</label>
                    <div class="col-sm-4">
                        <select name="languages" id="languages" multiple class="form-select">
                            <option value="java" ${paramValues.languages.stream().anyMatch(v -> v.equals("java")).get() ? "selected" : ""}>Java</option>
                            <option value="js" ${paramValues.languages.stream().anyMatch(v -> v.equals("js")).get() ? "selected" : ""}>JavaScript</option>
                            <option value="ts" ${paramValues.languages.stream().anyMatch(v -> v.equals("ts")).get() ? "selected" : ""}>TypeScript</option>
                            <option value="spring" ${paramValues.languages.stream().anyMatch(v -> v.equals("spring")).get() ? "selected" : ""}>Spring Boot</option>
                            <option value="php" ${paramValues.languages.stream().anyMatch(v -> v.equals("php")).get() ? "selected" : ""}>PHP</option>
                            <option value="python" ${paramValues.languages.stream().anyMatch(v -> v.equals("python")).get() ? "selected" : ""}>Python</option>
                        </select>
                        <% if (errors != null && errors.containsKey("languages")) {
                            out.println("<small style='color: red;'>" + errors.get("languages") + "</small>");
                        }%>
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-form-label col-sm-2">Roles</label>
                    <div class="form-check col-sm-2">
                        <input type="checkbox" name="roles" value="ROLE_ADMIN" class="form-check-input" ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_ADMIN")).get() ? "checked" : ""}>
                        <label class="col-form-label">Administrator</label>
                    </div>
                    <div class="form-check col-sm-2">
                        <input type="checkbox" name="roles" value="ROLE_USER" checked class="form-check-input" ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_USER")).get() ? "checked" : ""}>
                        <label class="col-form-label">User</label>
                    </div>
                    <div class="form-check col-sm-2">
                        <input type="checkbox" name="roles" value="ROLE_MOD" class="form-check-input" ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_MOD")).get() ? "checked" : ""}>
                        <label class="col-form-label">Moderator</label>
                    </div>
                    <% if (errors != null && errors.containsKey("roles")) {
                        out.println("<small style='color: red;'>" + errors.get("roles") + "</small>");
                    }%>
                </div>

                <div class="row mb-3">
                    <label class="col-form-label col-sm-2">Idioms</label>
                    <div class="form-check col-sm-2">
                        <input type="radio" name="idioms" value="br" class="form-check-input" ${param.idioms.equals("br") ? "checked" : ""}>
                        <label class="col-form-label">Portuguese</label>
                    </div>
                    <div class="form-check col-sm-2">
                        <input type="radio" name="idioms" value="es" class="form-check-input" ${param.idioms.equals("es") ? "checked" : ""}>
                        <label class="col-form-label">English</label>
                    </div>
                    <div class="form-check col-sm-2">
                        <input type="radio" name="idioms" value="us" class="form-check-input" ${param.idioms.equals("us") ? "checked" : ""}>
                        <label class="col-form-label">Spanish</label>
                    </div>
                    <% if (errors != null && errors.containsKey("idioms")) {
                        out.println("<small style='color: red;'>" + errors.get("idioms") + "</small>");
                    }%>
                </div>

                <div class="row mb-3">
                    <label class="col-form-label col-sm-2">Active</label>
                    <div class="form-check col-sm-2">
                        <input type="checkbox" name="active" id="active" checked class="form-check-input">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="">
                        <input type="submit" value="Send" class="btn btn-primary">
                    </div>
                </div>

                <input type="hidden" name="secret" value="1234fsy5$%">
            </form>
        </div>
    </body>
</html>
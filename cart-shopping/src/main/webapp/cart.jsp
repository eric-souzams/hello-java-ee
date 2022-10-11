<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <div>
            <label>Username</label>
            <input type="text" name="username" id="username">
        </div>
        <div>
            <label>Password</label>
            <input type="password" name="password" id="password">
        </div>

        <div>
            <input type="submit" value="Submit">
        </div>
    </form>
</body>
</html>
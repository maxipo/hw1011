
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <h3 class="text-center">Register</h3>
                <form action="register" method="post">
                    <div class="form-group">
                        <label for="loginname">Account Name</label>
                        <input type="text" id="loginname" name="loginname" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="username">Nickname</label>
                        <input type="text" id="username" name="username" class="form-control" required>
                    </div>
                    <div class="form-group text-center">
                        <input type="submit" id="submit" value="註冊" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
    </div>
    </body>
</html>
<%--
<form action="register" method="post">
    <table>
        <tr>
            <td><label>帳號名稱：</label></td>
            <td><input type="text" id="loginname" name="loginname"> </td>
        </tr>
        <tr>
            <td><label>密碼：</label></td>
            <td><input type="password" id="password" name="password"> </td>
        </tr>
        <tr>
            <td><label>姓名：</label></td>
            <td><input type="text" id="username" name="username"> </td>
        </tr>
        <tr>
            <td><input type="submit" id="submit" value="註冊"> </td>
        </tr>
    </table>
</form>
--%>






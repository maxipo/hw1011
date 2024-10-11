
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <h3 class="text-center">Login Page</h3>
                <form action="login" method="post">
                    <div class="form-group">
                        <label for="loginname">account name</label>
                        <input type="text" id="loginname" name="loginname" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="password">password</label>
                        <input type="password" id="password" name="password" class="form-control" required>
                    </div>
                    <div class="form-group text-center">
                        <input type="submit" id="submit" value="登錄" class="btn btn-primary btn-block">
                    </div>
                </form>
                <!-- 顯示登入結果的地方 -->
                <div id="loginResult" class="mt-3"></div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function() {
            $("#submit").click(function() {
                event.preventDefault();
                var loginname = $("#loginname").val();
                var password = $("#password").val();

                // // 檢查欄位是否為空
                // if (loginname === "" || password === "") {
                //     $("#loginResult").text("請輸入登錄名稱和密碼");
                //     return;
                // }

                // 發送 AJAX 請求
                $.ajax({
                    url: "${pageContext.request.contextPath}/user/login",  // 發送到控制器的路徑
                    type: "POST",
                    data: {
                        loginname: loginname,
                        password: password
                    },
                    success: function(response) {
                        if (response === "success") {
                            // 登錄成功，跳轉到主頁
                            window.location.href = "${pageContext.request.contextPath}/main";
                        } else {
                            // 顯示錯誤消息
                            $("#loginResult").text("登錄失敗，請檢查您的登錄名稱或密碼");
                        }
                    },
                    error: function() {
                        $("#loginResult").text("伺服器發生錯誤，請稍後再試");
                    }
                });
            });
        });
    </script>
</body>
</html>
<%--<form action="login" method="post">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td><label>帳號名稱：</label></td>--%>
<%--            <td><input type="text" id="loginname" name="loginname"> </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><label>密碼：</label></td>--%>
<%--            <td><input type="password" id="password" name="password"> </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input type="submit" id="submit" value="登錄"> </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>



<%--<%= request.getContextPath() %>/--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>登錄頁面</title>--%>
<%--</head>--%>
<%--<body></body>--%>


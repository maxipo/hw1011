<%--
  Created by IntelliJ IDEA.
  User: asher
  Date: 2024/9/20
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    <link href="<%= request.getContextPath() %>/style/myStyle.css" rel="stylesheet"></link>--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-4">
             <h3 class="text-center">Hello Lottery</h3>
            <form action="${pageContext.request.contextPath}/lotteryController" method="post" class="form-inline justify-content-center">
                <div class="form-group">
                    <label for="group" class="sr-only">組數</label>
                    <input type="text" class="form-control" name="group" placeholder="組數">
                </div>
                <div class="form-group">
                    <label for="exclude" class="sr-only">排除</label>
                    <input type="text" class="form-control" name="exclude" placeholder="排除">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">選號</button>
                </div>
            <div class="form-group text-center">
                <a href="index.jsp" class="btn btn-secondary">Go Home</a>
            </div>
            </form>
    </div>

</body>
</html>

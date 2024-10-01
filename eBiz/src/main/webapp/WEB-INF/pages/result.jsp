
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.reflect.Array" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
    <div class="container mt-5">
        <h2 class="text-center">Lucky Number:</h2>
        <table class="table table-bordered table-striped" style="margin: auto; text-align: left;">
            <thead>
                <tr>
                    <th>Numbers</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList[] returnAList = (ArrayList[]) request.getAttribute("numbers");
                    for (ArrayList list : returnAList) { %>
                        <tr>
                            <td><%= list %></td>
                        </tr>
                <% } %>
            </tbody>
        </table>
        <br/>
        <div class="text-center">
            <a href="index.jsp" class="btn btn-secondary">Go Home</a>
        </div>
    </div>
</body>
</html>

<%--
<html>
<head>
    <title>result</title>
</head>
<body>
    <h2>Lucky Number :</h2>
        <table border="1" style="margin: auto; text-align: Left">
		<tbody>
		<%
			ArrayList[] returnAList = (ArrayList[]) request.getAttribute("numbers");
			for (ArrayList list : returnAList) { %>
				<tr>
				<td><%= list%></td>
				</tr>
			<%}%>
		</tbody>
	</table>
	<br/>
	<a href="index.jsp">Go Home</a>
</body>
</html>
--%>


<%--
  Created by IntelliJ IDEA.
  User: ilkin
  Date: 19.06.20
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="jumbotron" style="background-color: #22D37D">
                <h1 style="color: white">Welcome to Human Resource Web Management Application</h1>
                <p class="lead" style="color: white">This is a simple Human Resource Management system over web. WIP
                    product</p>
                <hr class="my-4">
                <div>
                    <a class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/employee/" role="button">Employee
                        List</a>
                    <a class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/department/"
                       role="button">Department
                        List</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

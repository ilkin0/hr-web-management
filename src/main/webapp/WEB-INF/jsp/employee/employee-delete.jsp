<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Employee</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body>
<h2>Would u like to delete this entry?</h2>
<form action="<c:url value="/employee/employee-delete?id=${employeeView}"/>" method="post">
    <div class="container">
        <input type="submit" value="Delete" class="btn btn-danger">
        <a href="<c:url value="/employee/"/>" class="btn btn-primary"><b>Back to
            Employee List</b></a>
    </div>
</form>
</body>
</html>

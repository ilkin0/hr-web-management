<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ilkin
  Date: 08.04.20
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee Information</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body>
<form method="post" action="employee-add">
    <section class="content">
        <div class="container-fluid">
            <div class="row h-100 justify-content-center align-items-center">
                <div class="col-md-3">
                    <div class="card card-primary">
                        <div class="card-header card-primary">
                            <h3 class="card-title">Add New Employee</h3>
                        </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="id">Employee ID:</label>
                                    <input type="text" class="form-control" name="id" id="id">
                                </div>
                                <div class="form-group">
                                    <label for="jobId">Job ID:</label>
                                    <input type="text" class="form-control" name="jobId" id="jobId">
                                </div>
                                <div class="form-group">
                                    <label for="first-name">First Name:</label>
                                    <input type="text" class="form-control" name="firstName" id="first-name">
                                </div>
                                <div class="form-group">
                                    <label for="last-name">Last Name:</label>
                                    <input type="text" class="form-control" name="lastName" id="last-name">
                                </div>
                                <div class="form-group">
                                    <label for="hireDate">Hire Date:</label>
                                    <input type="date" class="form-control" name="hireDate" id="hireDate">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="text" class="form-control" name="email" id="email">
                                </div>
                                <div class="form-group">
                                    <label for="phoneNumber">Phone Number:</label>
                                    <input type="text" class="form-control" name="phoneNumber" id="phoneNumber">
                                </div>
                                <div class="form-group">
                                    <label for="salary">Salary:</label>
                                    <input type="number" step="0.01" class="form-control" name="salary" id="salary">
                                </div>
                            </div>
                            <div class="card-footer">
                                <input class="btn btn-success btn-block" type="submit" value="Add New Employee">
                                <a href="<c:url value="/employee/"/>" class="btn btn-secondary btn-block"><b>Back to list</b></a>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</form>
</body>
</html>

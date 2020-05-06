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
<form method="post" role="form" action="${pageContext.request.contextPath}/employee/employee-edit">
    <section class="content">
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-md-3">
                    <div class="card card-primary">
                        <div class="card-header card-primary">
                            <h3 class="card-title">Edit Employee Information</h3>
                        </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="id" id="id" value="${employee.id}">
                                </div>
                                <div class="form-group">
                                    <label for="first-name">First Name:</label>
                                    <input type="text" class="form-control" name="firstName" id="first-name"
                                           value="${employee.firstName}">
                                </div>
                                <div class="form-group">
                                    <label for="last-name">Last Name:</label>
                                    <input type="text" class="form-control" name="lastName" id="last-name"
                                           value="${employee.lastName}" >
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="text" class="form-control" name="email" id="email"
                                           value="${employee.email}">
                                </div>
                                <div class="form-group">
                                    <label for="phoneNumber">Phone Number:</label>
                                    <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"
                                           value="${employee.phoneNumber}">
                                </div>
                                <div class="form-group">
                                    <label for="salary">Salary:</label>
                                    <input type="number" step="0.01" class="form-control" name="salary" id="salary"
                                           value="${employee.salary}">
                                </div>
                            </div>
                            <div class="card-footer">
                                <input class="btn btn-success btn-block" type="submit" value="Save">
                                <a href="employee-view?id=${employee.id}"
                                   class="btn btn-danger btn-block"><b>Cancel</b></a>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</form>
</body>
</html>

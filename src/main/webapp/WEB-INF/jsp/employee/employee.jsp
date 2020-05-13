<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 04.04.20
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

</head>
<body>
<section class="content">
    <div class="container-fluid ">
        <div class="row h-100 justify-content-center align-items-center">
            <div class="col-md-3 ">
                <div class="card card-primary card-outline">
                    <div class="card-body box-profile">
                        <div class="text-center">
                            <strong><i class="fa fa-user fa-5x"></i></strong>
                        </div>
                        <form action="employee-edit" method="post">

                            <h3 class="profile-username text-center">${employeeView.firstName} ${employeeView.lastName}</h3>

                            <p class="text-muted text-center">Job ID: ${employeeView.jobID}</p>

                            <input type="hidden" name="id" value="${employeeView.id} ">
                            <input type="hidden" name="action" value="delete">

                            <ul class="list-group list-group-unbordered mb-3">
                                <li class="list-group-item">
                                    <b>Employee ID</b> <a class="float-right">${employeeView.id}</a>
                                </li>
                                <li class="list-group-item">
                                    <b>Email</b> <a class="float-right">${employeeView.email}</a>
                                </li>
                                <li class="list-group-item">
                                    <b>Phone number</b> <a
                                        class="float-right">${employeeView.phoneNumber}</a>
                                </li>
                                <li class="list-group-item">
                                    <b>Salary</b> <a class="float-right">${employeeView.salary}</a>
                                </li>
                            </ul>
                            <a href="employee-edit?id=${employeeView.id}"
                               class="btn btn-primary btn-block"><b>Edit</b></a>
                            <a href="<c:url value="/employee/"/>" class="btn btn-secondary btn-block"><b>Back to
                                list</b></a>
                            <a href="<c:url value="/employee/employee-delete?id=${employeeView.id}" />"
                               class="btn btn-danger btn-block">Delete</a>
                        </form>
                    </div>
                </div>

            </div>

        </div>

    </div>
</section>


</body>
</html>

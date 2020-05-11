<%--
  Created by IntelliJ IDEA.
  User: ilkin
  Date: 08.04.20
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Employee Information</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body>
<form:form method="post" role="form" action="${pageContext.request.contextPath}/employee/employee-edit"
           modelAttribute="employeeForm">
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
                                <form:hidden path="id"/>
                            </div>
                            <div class="form-group">
                                <label for="first-name">First Name:</label>
                                <form:input path="firstName" id="first-name" cssClass="form-control"/>
                                <div class="alert alert-danger" role="alert" style="display: none" id="errorMessage">
                                    <form:errors path="firstName" role="alert"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="last-name">Last Name:</label>
                                <form:input path="lastName" id="last-name" cssClass="form-control"/>
                                <div class="alert alert-danger" role="alert" style="display: none" id="errorMessage">
                                    <form:errors path="lastName" role="alert"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <form:input path="email" id="email" cssClass="form-control"/>
                                <div class="alert alert-danger" role="alert" style="display: none" id="errorMessage">
                                    <form:errors path="email" role="alert"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phoneNumber">Phone Number:</label>
                                <form:input path="phoneNumber" id="phoneNumber" cssClass="form-control"/>
                                <div class="alert alert-danger" role="alert" style="display: none" id="errorMessage">
                                    <form:errors path="phoneNumber" role="alert"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="salary">Salary:</label>
                                <form:input path="salary" id="salary" cssClass="form-control"/>
                                <div class="alert alert-danger" role="alert" style="display: none" id="errorMessage">
                                    <form:errors path="salary" role="alert"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="jobID">JobID</label>
                                <form:input path="jobID" id="jobID" cssClass="form-control"/>
                                <div class="alert alert-danger" role="alert" style="display: none" id="errorMessage">
                                    <form:errors path="jobID" role="alert"/>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer">
                            <input class="btn btn-success btn-block" type="submit" value="Save">
                            <a href="employee-view?id=${employeeForm.id}"
                               class="btn btn-danger btn-block"><b>Cancel</b></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</form:form>

<script>
    $("#errorMessage").onclick{
        function x() {

        }
    }
</script>
</body>
</html>

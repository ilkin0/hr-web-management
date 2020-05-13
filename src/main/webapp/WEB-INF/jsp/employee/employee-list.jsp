<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 04.04.20
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee List</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
</head>
<body>
<h2>Employee List</h2>
<table id="employee_table">
    <thead>
    <tr>
        <th>No</th>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Salary</th>
        <th>Action</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>No</th>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Salary</th>
        <th>Action</th>
    </tr>
    </tfoot>
</table>
<div>
    <a href="employee-add" class="btn btn-primary"><b>Add Employee</b></a>
    <a href="" class="btn btn-success"><b>Switch to Department List</b></a>
</div>
</body>
<script>
    $(document).ready(function () {
        $('#employee_table').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": "employee-list-ajax"
        });
    });
</script>
</html>

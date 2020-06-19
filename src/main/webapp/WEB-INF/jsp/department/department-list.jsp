<%--
  Created by IntelliJ IDEA.
  User: ilkin
  Date: 11.05.20
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department List</title>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

</head>
<body>
<h2>Department List</h2>

<table id="department_table">
    <thead>
    <tr>
        <th>No</th>
        <th>ID</th>
        <th>Department Name</th>
        <th>Manager ID</th>
        <th>Location ID</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>No</th>
        <th>ID</th>
        <th>Department Name</th>
        <th>Manager ID</th>
        <th>Location ID</th>
    </tr>

    </tfoot>
</table>

<div>
    <a href="#" class="btn btn-primary"><b>Add Department</b></a>
    <a class="btn btn-success" href="${pageContext.request.contextPath}/employee/" role="button">Switch to Employee
        List</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>

<script>
    $(document).ready(function () {
        $("#department_table").DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": "department-list-ajax"
        });
    });
</script>
</body>
</html>

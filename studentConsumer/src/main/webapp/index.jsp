<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-4">
    <h2 class="text-center text-primary mb-4">Student Management System</h2>
<br>
<a href="insertStudent" class="btn btn-sm btn-warning btn-action">Insert New Student</a><br><br>
    <!-- Employee Table -->
    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>SI.NO</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Date of Birth</th>
                    <th>Class</th>
                    <th>Contact</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${students}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${student.student_id}</td>
                        <td>${student.full_name}</td>
                        <td><fmt:formatDate value="${student.date_of_birth}" pattern="yyyy-MM-dd" /></td>
                        <td>${student.class1}</td>
                        <td>${student.contact_number}</td>
                        <td>${student.address}</td>
                        <td>
                       <a href="editStd?student_id=${student.student_id}" class="btn btn-sm btn-warning">Edit</a>


            <a href="deleteStudent/${student.student_id}" 
   class="btn btn-sm btn-danger btn-action"
   onclick="return confirm('Are you sure you want to delete this Student?')">Delete</a>

               </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>

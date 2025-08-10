<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 500px;
            margin: 40px auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }
        h2 {
            text-align: center;
            color: #007bff;
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin: 12px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            margin-top: 10px;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Student</h2>
        <form action="update" method="post">
    <input type="hidden" name="_method" value="put" />
    <input type="hidden" name="student_id" value="${student.student_id}" />
        
            <label>Student Full  Name:</label>
            <input type="text" name="full_name" value="${student.full_name}"required />

            <label>Date of Birth:</label>
<input type="date" name="date_of_birth" value="${dobFormatted}" required />

            
            <label>Class:</label> <select name="class1" required>
				<option value="">Select</option>
				<option value="First Year"
					${student.class1 == 'First Year' ? 'selected' : ''}>First
					Year</option>
				<option value="Second Year"
					${student.class1 == 'Second Year' ? 'selected' : ''}>Second
					Year</option>
				<option value="Third Year"
					${student.class1 == 'Third Year' ? 'selected' : ''}>Third
					Year</option>
			</select> <label>Salary:</label>
            <input type="number" name="contact_number" value="${student.contact_number}"required />

            <label>Role:</label>
            <input type="text" name="address" value="${student.address}" required />

            <button type="submit">Update Student</button>
        </form>
    </div>
</body>
</html>
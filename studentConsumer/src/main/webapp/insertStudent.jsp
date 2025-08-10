<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert New Student</title>
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
        <h2>Add New Student</h2>
        <form method="post" action="insertStd">
            <label>Student Full Name:</label>
            <input type="text" name="full_name" required />

            <label>Date of Birth:</label>
            <input type="date" name="date_of_birth" required />

            <label>Class:</label>
            <select name="class1" required>
                <option value="">Select</option>
                <option value="First Year">First Year</option>
                <option value="Second Year">Second Year</option>
                <option value="Third Year">Third Year</option>
            </select>

            <label>Contact :</label>
            <input type="number" name="contact_number" required />

            <label>Address:</label>
            <input type="text" name="address" required />

            <button type="submit">Insert Student</button>
        </form>
    </div>
</body>
</html>
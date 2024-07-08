<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome <%= request.getParameter("username")%></title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .container a {
            margin-top: 20px;
            text-decoration: none;
            color: #000;
            background-color: #f0f0f0;
            padding: 10px 20px;
            border-radius: 5px;
        }
        .container a:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome <%= request.getParameter("username") %></h1>
    <p><a href="HomePage.jsp">Log Out</a></p>
</div>
</body>
</html>

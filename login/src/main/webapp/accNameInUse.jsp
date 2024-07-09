<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Entry</title>
    <link rel="shortcut icon" href="images/Bulb.png" type="image/x-icon">
    <script src="https://kit.fontawesome.com/1f82d9d6d9.js" crossorigin="anonymous"></script>
    <style><%@include file="./styles/reset.css"%></style>
    <style>
        h1 {
            font-size: 25px;
            color: #F89EC4;
        }
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
            display: inline-block;
        }

        .login-box {
            display: inline-flex;
            flex-direction: column;
            row-gap: 12px;
            width: 500px;
            height: 320px;
            background-color: #FAEDFF;
            border: 2px solid #F89EC4;
            border-radius: 30px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: left;
            margin-block: 10px;
        }

        .login-box input[type="text"],
        .login-box input[type="password"] {
            color: #F89EC4;
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .login-box input[type="password"]:focus {
            outline-color: #F89EC4;
        }

        .login-box input[type="text"]:focus {
            outline-color: #F89EC4;
        }


        .login-box input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: none;
            border-radius: 4px;
            background-color: #F89EC4;
            color: #FAEDFF;
            cursor: pointer;
        }

        .login-box input[type="submit"]:hover {
            background-color: #DCCBED;
            color: #F89EC4;
        }

        label, p {
            color: #F89EC4;
            font-size: 20px;
        }

        a {
            font-size: 20px;
            color: #F89EC4;
        }

        .form {
            display: inline-flex;
            flex-direction: column;
            row-gap: 20px;
        }

        .user_info {
            height: inherit;
        }

        .create_new:hover {
            color: #DCCBED;
        }


    </style>
</head>
<body>
<div class="container">
    <h1>The Name <%=request.getParameter("username")%> is Already In Use</h1>
    <div class="login-box">
        <p>Please enter another name and password</p>
        <form action="accountServlet" method="post" class="form">
            <div class="user_info">
                <label for="username">User Name:</label><br>
                <input type="text" id="username" name="username"/><br>
            </div>
            <div class="user_info">
                <label for="pass">Password:</label><br>
                <input type="password" id="pass" name="pass"/><br>
            </div>
            <input type="submit" value="Login">
        </form>
    </div>
    <p><a href="newacc.jsp" class="create_new">Create New Account</a></p>
</div>
</body>
</html>
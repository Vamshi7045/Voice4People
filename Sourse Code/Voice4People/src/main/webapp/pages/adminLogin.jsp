<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Admin Login</title>

<style>

body {
    font-family: Arial;
    background: #e9ecef;
}

.login-box {

    width: 400px;
    margin: 80px auto;
    background: white;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 0 15px gray;

}

h2 {
    text-align: center;
    color: #0d6efd;
}

input {

    width: 100%;
    padding: 12px;
    margin: 12px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;

}

button {

    width: 100%;
    padding: 12px;
    background: #0d6efd;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;

}

button:hover {

    background: #084298;

}

.error {

    text-align: center;
    color: red;
    margin-bottom: 15px;

}

</style>

</head>

<body>

<div class="login-box">

<h2>Administrator Login</h2>

<%
String error = request.getParameter("error");

if ("invalid".equals(error)) {
%>

<p class="error">
Invalid Admin Credentials
</p>

<%
}
%>

<form action="../AdminLoginServlet" method="post">

<input
type="email"
name="email"
placeholder="Admin Email"
required>

<input
type="password"
name="password"
placeholder="Password"
required>

<button type="submit">
Login
</button>

</form>

</div>

</body>
</html>
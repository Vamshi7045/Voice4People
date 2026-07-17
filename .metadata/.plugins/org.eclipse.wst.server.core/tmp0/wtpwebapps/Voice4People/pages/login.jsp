<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Voice4People</title>

<style>

body{
    font-family:Arial,sans-serif;
    background:#f2f2f2;
}

.container{
    width:400px;
    margin:70px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}

h2{
    text-align:center;
    color:#0d6efd;
}

input{
    width:100%;
    padding:10px;
    margin:10px 0;
    box-sizing:border-box;
}

button{
    width:100%;
    padding:12px;
    background:#0d6efd;
    color:white;
    border:none;
    cursor:pointer;
    border-radius:5px;
}

button:hover{
    background:#084298;
}

</style>

</head>

<body>

<div class="container">

<h2>User Login</h2>

<form action="../LoginServlet" method="post">

<input type="email"
name="email"
placeholder="Enter Email"
required>

<input type="password"
name="password"
placeholder="Enter Password"
required>

<button type="submit">

Login

</button>

</form>

</div>

</body>
</html>
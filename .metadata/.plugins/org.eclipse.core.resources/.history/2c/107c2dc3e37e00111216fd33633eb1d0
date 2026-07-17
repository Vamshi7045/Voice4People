<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.voice4people.model.User"%>

<%
User user = (User)request.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>My Profile</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
}

.container{
    width:500px;
    margin:40px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px lightgray;
}

h2{
    text-align:center;
    color:#0d6efd;
}

label{
    font-weight:bold;
}

input{
    width:100%;
    padding:10px;
    margin-top:5px;
    margin-bottom:15px;
    border:1px solid #ccc;
    border-radius:5px;
    box-sizing:border-box;
}

button{
    width:100%;
    padding:12px;
    background:#0d6efd;
    color:white;
    border:none;
    border-radius:5px;
    cursor:pointer;
    font-size:16px;
}

button:hover{
    background:#084298;
}

.back{
    display:block;
    text-align:center;
    margin-top:15px;
}

</style>

</head>

<body>

<div class="container">

<h2>My Profile</h2>

<form action="../UpdateProfileServlet" method="post">

<input
type="hidden"
name="id"
value="<%=user.getId()%>">

<label>Full Name</label>

<input
type="text"
name="fullName"
value="<%=user.getFullName()%>"
required>

<label>Email</label>

<input
type="email"
value="<%=user.getEmail()%>"
readonly>

<label>Phone</label>

<input
type="text"
name="phone"
value="<%=user.getPhone()%>"
required>

<button type="submit">

Update Profile

</button>

</form>

<a href="citizenDashboard.jsp" class="back">

⬅ Back to Dashboard

</a>

</div>

</body>
</html>
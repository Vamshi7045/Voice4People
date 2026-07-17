<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Contact Voice4People</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
    margin:0;
}

.container{
    width:80%;
    margin:40px auto;
    background:white;
    padding:35px;
    border-radius:10px;
    box-shadow:0 0 10px lightgray;
}

h1{
    text-align:center;
    color:#0d6efd;
}

.contact-box{
    display:flex;
    gap:30px;
    justify-content:center;
    flex-wrap:wrap;
}

.card{
    width:280px;
    padding:25px;
    text-align:center;
    background:#f8f9fa;
    border-radius:10px;
}

.card h2{
    color:#0d6efd;
}

.card p{
    line-height:1.6;
}

.back{
    display:block;
    text-align:center;
    margin-top:30px;
    color:#0d6efd;
    text-decoration:none;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="container">

<h1>Contact Us</h1>

<div class="contact-box">

<div class="card">

<h2>📧 Email</h2>

<p>
support@voice4people.com
</p>

</div>

<div class="card">

<h2>📞 Phone</h2>

<p>
+91 98765 43210
</p>

</div>

<div class="card">

<h2>📍 Location</h2>

<p>
Hyderabad, Telangana, India
</p>

</div>

</div>

<a href="<%=request.getContextPath()%>/index.jsp"
   class="back">

⬅ Back to Home

</a>

</div>

</body>

</html>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>About Voice4People</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
    margin:0;
}

.container{
    width:80%;
    margin:50px auto;
    background:white;
    padding:40px;
    border-radius:10px;
    box-shadow:0 0 10px lightgray;
}

h1{
    text-align:center;
    color:#0d6efd;
}

h2{
    color:#0d6efd;
}

p{
    font-size:17px;
    line-height:1.7;
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

<h1>About Voice4People</h1>

<h2>Our Mission</h2>

<p>
Voice4People is a citizen complaint management platform designed
to connect citizens with government officials.
</p>

<p>
Citizens can report local problems such as road damage, water supply
issues, electricity problems, drainage, garbage and other public issues.
</p>

<h2>Our Vision</h2>

<p>
Our vision is to create a transparent and efficient communication
system between citizens and government authorities.
</p>

<h2>Why Voice4People?</h2>

<p>
Voice4People helps citizens submit complaints, track complaint status
and receive updates regarding their reported issues.
</p>

<a href="<%=request.getContextPath()%>/index.jsp" class="back">
⬅ Back to Home
</a>

</div>

</body>

</html>
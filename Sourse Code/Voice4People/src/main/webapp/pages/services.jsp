<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Voice4People Services</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
    margin:0;
}

.container{
    width:85%;
    margin:40px auto;
}

h1{
    text-align:center;
    color:#0d6efd;
}

.services{
    display:flex;
    gap:25px;
    justify-content:center;
    flex-wrap:wrap;
}

.card{
    width:280px;
    background:white;
    padding:25px;
    border-radius:10px;
    text-align:center;
    box-shadow:0 0 10px lightgray;
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

<h1>Our Services</h1>

<div class="services">

<div class="card">

<h2>📝 Report Complaint</h2>

<p>
Citizens can report local problems and public issues
directly through the Voice4People platform.
</p>

</div>

<div class="card">

<h2>🔍 Track Complaint</h2>

<p>
Track the current status of your submitted complaints
easily and efficiently.
</p>

</div>

<div class="card">

<h2>📊 Complaint Monitoring</h2>

<p>
View complaint progress and status updates
through a transparent system.
</p>

</div>

<div class="card">

<h2>👤 Citizen Profile</h2>

<p>
Manage your personal information and update your
profile details securely.
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
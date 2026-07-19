<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.voice4people.model.Complaint"%>

<%

Complaint complaint =
    (Complaint)request.getAttribute("complaint");

List<String> history =
    (List<String>)request.getAttribute("history");

if(complaint == null){

    response.sendRedirect("adminDashboard.jsp");

    return;
}

%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Complaint Details</title>

<style>

body{

    margin:0;

    font-family:Arial;

    background:#f2f2f2;

}

.container{

    width:700px;

    margin:40px auto;

    background:white;

    padding:30px;

    border-radius:10px;

    box-shadow:0 0 10px lightgray;

}

h2{

    text-align:center;

    color:#0d6efd;

    margin-bottom:25px;

}

.details{

    border:1px solid #ddd;

    border-radius:8px;

    overflow:hidden;

}

.row{

    display:flex;

    border-bottom:1px solid #ddd;

}

.row:last-child{

    border-bottom:none;

}

.label{

    width:35%;

    background:#f8f9fa;

    padding:12px;

    font-weight:bold;

}

.value{

    width:65%;

    padding:12px;

}

.status{

    padding:6px 12px;

    background:#ffc107;

    border-radius:5px;

    font-weight:bold;

}

.complaint-image{

    width:100%;

    max-height:400px;

    object-fit:contain;

    border-radius:8px;

    border:1px solid #ccc;

    margin-top:20px;

}

.history-box{

    margin-top:30px;

    padding:20px;

    border:1px solid #ddd;

    border-radius:8px;

}

.history-box h3{

    color:#0d6efd;

    margin-top:0;

}

.history-item{

    padding:12px;

    margin:10px 0;

    background:#f8f9fa;

    border-left:5px solid #0d6efd;

    border-radius:5px;

    font-weight:bold;

}

.back{

    display:block;

    width:220px;

    margin:25px auto 0;

    padding:12px;

    text-align:center;

    background:#0d6efd;

    color:white;

    text-decoration:none;

    border-radius:5px;

}

.back:hover{

    background:#084298;

}

</style>

</head>

<body>

<div class="container">

<h2>📋 Complaint Details</h2>

<div class="details">

<div class="row">

<div class="label">Complaint ID</div>

<div class="value">

<%=complaint.getId()%>

</div>

</div>

<div class="row">

<div class="label">User ID</div>

<div class="value">

<%=complaint.getUserId()%>

</div>

</div>

<div class="row">

<div class="label">Title</div>

<div class="value">

<%=complaint.getTitle()%>

</div>

</div>

<div class="row">

<div class="label">Category</div>

<div class="value">

<%=complaint.getCategory()%>

</div>

</div>

<div class="row">

<div class="label">Description</div>

<div class="value">

<%=complaint.getDescription()%>

</div>

</div>

<div class="row">

<div class="label">District</div>

<div class="value">

<%=complaint.getDistrict()%>

</div>

</div>

<div class="row">

<div class="label">Mandal</div>

<div class="value">

<%=complaint.getMandal()%>

</div>

</div>

<div class="row">

<div class="label">Village</div>

<div class="value">

<%=complaint.getVillage()%>

</div>

</div>

<div class="row">

<div class="label">Address</div>

<div class="value">

<%=complaint.getAddress()%>

</div>

</div>

<div class="row">

<div class="label">Current Status</div>

<div class="value">

<span class="status">

<%=complaint.getStatus()%>

</span>

</div>

</div>

</div>

<%

if(complaint.getImage() != null &&
   !complaint.getImage().trim().isEmpty()){

%>

<img

src="<%=request.getContextPath()%>/uploads/<%=complaint.getImage()%>"

class="complaint-image"

alt="Complaint Image">

<%

}

%>

<!-- STATUS HISTORY -->

<div class="history-box">

<h3>📜 Complaint Status History</h3>

<%

if(history != null && !history.isEmpty()){

    for(String status : history){

%>

<div class="history-item">

<%=status%>

</div>

<%

    }

}else{

%>

<p>No status history available.</p>

<%

}

%>

</div>

<a href="adminDashboard.jsp" class="back">

⬅ Back to Dashboard

</a>

</div>

</body>

</html>
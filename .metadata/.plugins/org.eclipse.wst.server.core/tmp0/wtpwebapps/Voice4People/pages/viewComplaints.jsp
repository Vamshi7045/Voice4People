<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.voice4people.model.Complaint"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>All Complaints</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
    margin:0;
}

.container{
    width:95%;
    margin:30px auto;
}

h2{
    text-align:center;
    color:#0d6efd;
}

.search-box{
    background:white;
    padding:20px;
    margin-bottom:20px;
    border-radius:10px;
    box-shadow:0 0 10px lightgray;
}

.search-box input,
.search-box select{
    padding:8px;
    margin-right:10px;
    border:1px solid #ccc;
    border-radius:5px;
}

.search-box button{
    padding:8px 15px;
    background:#0d6efd;
    color:white;
    border:none;
    border-radius:5px;
    cursor:pointer;
}

.search-box button:hover{
    background:#084298;
}

.reset-btn{
    background:#6c757d !important;
}

.reset-btn:hover{
    background:#495057 !important;
}

table{
    width:100%;
    border-collapse:collapse;
    background:white;
}

table th{
    background:#0d6efd;
    color:white;
    padding:12px;
}

table td{
    padding:10px;
    border:1px solid #ddd;
    text-align:center;
    vertical-align:middle;
}

tr:nth-child(even){
    background:#f8f8f8;
}

.status-select,
.priority-select{
    padding:6px;
    margin-top:5px;
    width:140px;
}

.update-btn{
    margin-top:10px;
    padding:6px 12px;
    background:#198754;
    color:white;
    border:none;
    border-radius:5px;
    cursor:pointer;
}

.update-btn:hover{
    background:#146c43;
}

.complaint-image{
    width:120px;
    height:90px;
    object-fit:cover;
    border-radius:6px;
    border:1px solid #ccc;
}

.priority-high{
    color:#dc3545;
    font-weight:bold;
}

.priority-medium{
    color:#fd7e14;
    font-weight:bold;
}

.priority-low{
    color:#198754;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="container">

<h2>All Complaints</h2>

<!-- ==========================
     SEARCH SECTION
========================== -->

<div class="search-box">

<form action="<%=request.getContextPath()%>/SearchComplaintServlet"
      method="get">

<input
    type="text"
    name="title"
    placeholder="Search by Title">

<select name="category">

<option value="All">All Categories</option>
<option value="Road">Road</option>
<option value="Water Supply">Water Supply</option>
<option value="Electricity">Electricity</option>
<option value="Drainage">Drainage</option>
<option value="Street Lights">Street Lights</option>
<option value="Garbage">Garbage</option>
<option value="Other">Other</option>

</select>

<select name="status">

<option value="All">All Status</option>
<option value="Pending">Pending</option>
<option value="In Progress">In Progress</option>
<option value="Resolved">Resolved</option>

</select>

<button type="submit">
🔍 Search
</button>

<a href="<%=request.getContextPath()%>/ViewComplaintsServlet">

<button
    type="button"
    class="reset-btn">

Reset

</button>

</a>

</form>

</div>

<!-- ==========================
     COMPLAINT TABLE
========================== -->

<table>

<tr>

<th>ID</th>
<th>User ID</th>
<th>Title</th>
<th>Category</th>
<th>Description</th>
<th>District</th>
<th>Mandal</th>
<th>Village</th>
<th>Address</th>
<th>Image</th>
<th>Status</th>
<th>Priority</th>
<th>Action</th>

</tr>

<%

List<Complaint> list =
    (List<Complaint>)request.getAttribute("complaints");

if(list != null && !list.isEmpty()){

    for(Complaint c : list){

%>

<tr>

<td>
<%=c.getId()%>
</td>

<td>
<%=c.getUserId()%>
</td>

<td>
<%=c.getTitle()%>
</td>

<td>
<%=c.getCategory()%>
</td>

<td>
<%=c.getDescription()%>
</td>

<td>
<%=c.getDistrict()%>
</td>

<td>
<%=c.getMandal()%>
</td>

<td>
<%=c.getVillage()%>
</td>

<td>
<%=c.getAddress()%>
</td>

<!-- IMAGE -->

<td>

<%

if(c.getImage() != null &&
   !c.getImage().trim().isEmpty()){

%>

<img
src="<%=request.getContextPath()%>/uploads/<%=c.getImage()%>"
class="complaint-image"
alt="Complaint Image">

<%

}else{

%>

No Image

<%

}

%>

</td>

<!-- STATUS -->

<td>

<%=c.getStatus()%>

</td>

<!-- PRIORITY -->

<td>

<%

String priority = c.getPriority();

if("High".equalsIgnoreCase(priority)){

%>

<span class="priority-high">
🔴 High
</span>

<%

}else if("Low".equalsIgnoreCase(priority)){

%>

<span class="priority-low">
🟢 Low
</span>

<%

}else{

%>

<span class="priority-medium">
🟡 Medium
</span>

<%

}

%>

</td>

<!-- ACTION -->

<td>

<a
    href="<%=request.getContextPath()%>/ComplaintDetailsServlet?id=<%=c.getId()%>"
    style="
        display:inline-block;
        padding:6px 12px;
        background:#0d6efd;
        color:white;
        text-decoration:none;
        border-radius:5px;
        margin-bottom:8px;
    ">

🔍 View Details

</a>

<form
    action="<%=request.getContextPath()%>/UpdateStatusServlet"
    method="post">

<input
    type="hidden"
    name="id"
    value="<%=c.getId()%>">

<!-- STATUS -->

<select
    name="status"
    class="status-select">

<option
    value="Pending"
    <%= "Pending".equals(c.getStatus())
        ? "selected" : "" %>>

Pending

</option>

<option
    value="In Progress"
    <%= "In Progress".equals(c.getStatus())
        ? "selected" : "" %>>

In Progress

</option>

<option
    value="Resolved"
    <%= "Resolved".equals(c.getStatus())
        ? "selected" : "" %>>

Resolved

</option>

</select>

<br>

<!-- PRIORITY -->

<select
    name="priority"
    class="priority-select">

<option
    value="High"
    <%= "High".equals(c.getPriority())
        ? "selected" : "" %>>

🔴 High

</option>

<option
    value="Medium"
    <%= "Medium".equals(c.getPriority())
        ? "selected" : "" %>>

🟡 Medium

</option>

<option
    value="Low"
    <%= "Low".equals(c.getPriority())
        ? "selected" : "" %>>

🟢 Low

</option>

</select>

<br>

<button
    type="submit"
    class="update-btn">

Update

</button>

</form>

</td>

</tr>

<%

    }

}else{

%>

<tr>

<td colspan="13">

No complaints found.

</td>

</tr>

<%

}

%>

</table>

</div>

</body>

</html>
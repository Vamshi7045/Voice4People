<%@ page import="java.util.List"%>
<%@ page import="com.voice4people.model.Complaint"%>
<%@ page import="com.voice4people.model.User"%>

<%
User user = (User)session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}

List<Complaint> complaints = (List<Complaint>)request.getAttribute("complaints");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>My Complaints</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
}

.container{
    width:90%;
    margin:40px auto;
    background:white;
    padding:25px;
    border-radius:10px;
    box-shadow:0 0 10px gray;
}

h2{
    color:#0d6efd;
}

table{
    width:100%;
    border-collapse:collapse;
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
}

.pending{
    color:red;
    font-weight:bold;
}

.resolved{
    color:green;
    font-weight:bold;
}

.inprogress{
    color:orange;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="container">

<h2>My Complaints</h2>

<table>

<tr>
<th>ID</th>
<th>Title</th>
<th>Category</th>
<th>District</th>
<th>Status</th>
</tr>

<%
if(complaints != null){

for(Complaint c : complaints){
%>

<tr>

<td><%=c.getId()%></td>

<td><%=c.getTitle()%></td>

<td><%=c.getCategory()%></td>

<td><%=c.getDistrict()%></td>

<td>

<%
String status = c.getStatus();

if(status.equalsIgnoreCase("Pending")){
%>

<span class="pending"><%=status%></span>

<%
}else if(status.equalsIgnoreCase("Resolved")){
%>

<span class="resolved"><%=status%></span>

<%
}else{
%>

<span class="inprogress"><%=status%></span>

<%
}
%>

</td>

</tr>

<%
}
}
%>

</table>

<br>

<a href="citizenDashboard.jsp">⬅ Back to Dashboard</a>

</div>

</body>
</html>
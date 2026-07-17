<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.voice4people.model.Complaint"%>

<%
List<Complaint> complaints =
    (List<Complaint>) request.getAttribute("complaints");

Map<Integer, List<String>> statusHistory =
    (Map<Integer, List<String>>)
    request.getAttribute("statusHistory");

if (complaints == null) {
    response.sendRedirect("citizenDashboard.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Track Complaints</title>

<style>

body {
    margin: 0;
    font-family: Arial;
    background: #f2f2f2;
}

.container {
    width: 90%;
    margin: 40px auto;
}

h2 {
    text-align: center;
    color: #0d6efd;
}

.card {
    background: white;
    margin: 25px auto;
    padding: 25px;
    border-radius: 10px;
    box-shadow: 0 0 10px lightgray;
}

.title {
    font-size: 20px;
    font-weight: bold;
    color: #333;
}

.status {
    margin-top: 10px;
    font-weight: bold;
}

.timeline {
    margin-top: 30px;
    border-left: 4px solid #0d6efd;
    padding-left: 25px;
}

.history-item {
    margin-bottom: 25px;
    position: relative;
}

.history-item::before {
    content: "";
    position: absolute;
    left: -37px;
    top: 2px;
    width: 18px;
    height: 18px;
    background: #0d6efd;
    border-radius: 50%;
}

.history-status {
    font-size: 18px;
    font-weight: bold;
    color: #0d6efd;
}

.pending {
    color: #dc3545;
}

.progress {
    color: #fd7e14;
}

.resolved {
    color: #198754;
}

.no-history {
    color: gray;
    font-style: italic;
}

.back {
    display: block;
    width: 220px;
    margin: 30px auto;
    padding: 12px;
    text-align: center;
    background: #0d6efd;
    color: white;
    text-decoration: none;
    border-radius: 5px;
}

</style>

</head>

<body>

<div class="container">

<h2>🔍 Track My Complaints</h2>

<%

if (complaints.isEmpty()) {

%>

<div class="card">

<h3>No complaints found.</h3>

</div>

<%

} else {

for (Complaint c : complaints) {

List<String> history =
    statusHistory.get(c.getId());

%>

<div class="card">

<div class="title">

Complaint #<%=c.getId()%> -
<%=c.getTitle()%>

</div>

<div class="timeline">

<%

if (history != null &&
    !history.isEmpty()) {

for (String status : history) {

String statusClass = "";

if ("Pending".equalsIgnoreCase(status)) {

statusClass = "pending";

} else if ("In Progress".equalsIgnoreCase(status)) {

statusClass = "progress";

} else if ("Resolved".equalsIgnoreCase(status)) {

statusClass = "resolved";

}

%>

<div class="history-item">

<div class="history-status <%=statusClass%>">

<%=status%>

</div>

<div>

Status updated successfully

</div>

</div>

<%

}

} else {

%>

<div class="no-history">

No status history available.

</div>

<%

}

%>

</div>

</div>

<%

}

}

%>

<a href="citizenDashboard.jsp" class="back">

⬅ Back to Dashboard

</a>

</div>

</body>

</html>
<%@ page import="com.voice4people.model.User"%>
<%@ page import="com.voice4people.dao.ComplaintDAO"%>

<%
User user = (User)session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}

ComplaintDAO dao = new ComplaintDAO();

int total = dao.getUserTotalComplaints(user.getId());
int pending = dao.getUserPendingComplaints(user.getId());
int progress = dao.getUserInProgressComplaints(user.getId());
int resolved = dao.getUserResolvedComplaints(user.getId());
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Citizen Dashboard</title>

<link rel="stylesheet" href="../css/dashboard.css">

<style>

.table-box{
    margin-top:30px;
    background:white;
    padding:20px;
    border-radius:10px;
    box-shadow:0 0 10px lightgray;
}

.table-box p{
    font-size:16px;
    margin:10px 0;
}

</style>

</head>

<body>

<div class="header">

<h2>Voice4People</h2>

<div>

Welcome,

<b><%=user.getFullName()%></b>

|

<a href="../LogoutServlet" style="color:white;text-decoration:none;">Logout</a>

</div>

</div>

<div class="container">

<div class="sidebar">

<h2>Citizen</h2>

<a href="citizenDashboard.jsp">🏠 Dashboard</a>

<a href="submitComplaint.jsp">➕ Submit Complaint</a>

<a href="../MyComplaintsServlet">📋 My Complaints</a>

<a href="#">🔍 Track Complaint</a>

<a href="../ProfileServlet">👤 My Profile</a>

</div>

<div class="content">

<h2>Citizen Dashboard</h2>

<div class="cards">

<div class="card">

<h3>Total Complaints</h3>

<h1><%=total%></h1>

</div>

<div class="card">

<h3>Pending</h3>

<h1><%=pending%></h1>

</div>

<div class="card">

<h3>In Progress</h3>

<h1><%=progress%></h1>

</div>

<div class="card">

<h3>Resolved</h3>

<h1><%=resolved%></h1>

</div>

</div>

<div class="table-box">

<h3>Quick Actions</h3>

<hr>

<p>✅ Submit a new complaint using the <b>Submit Complaint</b> option.</p>

<p>📋 View all your complaints in <b>My Complaints</b>.</p>

<p>🔄 Track complaint status anytime.</p>

<p>📊 Dashboard statistics update automatically after every complaint submission or status update.</p>

</div>

</div>

</div>

</body>
</html>
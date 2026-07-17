<%@ page import="com.voice4people.model.User"%>
<%@ page import="com.voice4people.dao.ComplaintDAO"%>

<%
User admin = (User)session.getAttribute("admin");

if(admin == null){
    response.sendRedirect("adminLogin.jsp");
    return;
}

ComplaintDAO dao = new ComplaintDAO();

int total = dao.getTotalComplaints();
int pending = dao.getPendingComplaints();
int progress = dao.getInProgressComplaints();
int resolved = dao.getResolvedComplaints();
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Admin Dashboard</title>

<style>

body{
    margin:0;
    font-family:Arial;
    background:#f4f6f9;
}

.header{
    background:#0d6efd;
    color:white;
    padding:15px 30px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.container{
    display:flex;
}

.sidebar{
    width:250px;
    background:#343a40;
    min-height:100vh;
}

.sidebar h3{
    color:white;
    text-align:center;
    padding-top:20px;
}

.sidebar a{
    display:block;
    color:white;
    padding:15px;
    text-decoration:none;
}

.sidebar a:hover{
    background:#495057;
}

.content{
    flex:1;
    padding:30px;
}

.cards{
    display:flex;
    gap:20px;
    flex-wrap:wrap;
    margin-bottom:30px;
}

.card{
    flex:1;
    min-width:220px;
    background:white;
    padding:20px;
    border-radius:10px;
    box-shadow:0 0 10px lightgray;
    text-align:center;
}

.card h3{
    margin-bottom:10px;
}

.card h1{
    color:#0d6efd;
    font-size:40px;
}

</style>

</head>

<body>

<div class="header">

<h2>Voice4People - Admin Panel</h2>

<div>

Welcome,

<b><%=admin.getFullName()%></b>

|

<a href="../LogoutServlet" style="color:white;">Logout</a>

</div>

</div>

<div class="container">

<div class="sidebar">

<h3>Admin</h3>

<a href="adminDashboard.jsp">🏠 Dashboard</a>

<a href="../ViewComplaintsServlet">📋 View Complaints</a>

<a href="../AnalyticsServlet">📊 Analytics</a>

<a href="<%=request.getContextPath()%>/UsersServlet">
    👥 Users
</a>

<a href="<%=request.getContextPath()%>/ReportsServlet">
    📊 Reports
</a>

</div>

<div class="content">

<h2>Dashboard</h2>

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

<h3>Administrator Dashboard ✅</h3>

<p>Live complaint statistics are now connected to the database.</p>

</div>

</div>

</body>
</html>
<%@ page import="com.voice4people.model.User"%>

<%
User user = (User) session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Submit Complaint</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
}

.container{
    width:700px;
    margin:40px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px gray;
}

h2{
    text-align:center;
    color:#0d6efd;
}

input,select,textarea{
    width:100%;
    padding:10px;
    margin:10px 0;
    border:1px solid #ccc;
    border-radius:5px;
    box-sizing:border-box;
}

input[type=file]{
    padding:8px;
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

</style>

</head>

<body>

<div class="container">

<h2>Submit Complaint</h2>

<form action="../ComplaintServlet"
      method="post"
      enctype="multipart/form-data">

<input
type="hidden"
name="userId"
value="<%=user.getId()%>">

<label>Complaint Title</label>
<input
type="text"
name="title"
required>

<label>Category</label>

<select name="category">

<option>Road</option>
<option>Water Supply</option>
<option>Electricity</option>
<option>Drainage</option>
<option>Street Lights</option>
<option>Garbage</option>
<option>Other</option>

</select>

<label>Description</label>

<textarea
name="description"
rows="5"
required></textarea>

<label>District</label>

<input
type="text"
name="district"
required>

<label>Mandal</label>

<input
type="text"
name="mandal"
required>

<label>Village</label>

<input
type="text"
name="village"
required>

<label>Address</label>

<textarea
name="address"
rows="3"
required></textarea>

<label>Complaint Image (Optional)</label>

<input
type="file"
name="image"
accept=".jpg,.jpeg,.png">

<button type="submit">

Submit Complaint

</button>

</form>

</div>

</body>
</html>
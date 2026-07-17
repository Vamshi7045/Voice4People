<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Complaint Analytics</title>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>

body{

font-family:Arial;
background:#f2f2f2;
margin:30px;

}

.container{

display:flex;
gap:40px;
justify-content:center;
flex-wrap:wrap;

}

.chart-box{

width:500px;
background:white;
padding:20px;
border-radius:10px;
box-shadow:0 0 10px lightgray;

}

h2{

text-align:center;
color:#0d6efd;

}

</style>

</head>

<body>

<h2>Complaint Analytics Dashboard</h2>

<div class="container">

<div class="chart-box">

<canvas id="statusChart"></canvas>

</div>

<div class="chart-box">

<canvas id="categoryChart"></canvas>

</div>

</div>

<script>

const statusChart = new Chart(document.getElementById('statusChart'),{

type:'pie',

data:{

labels:['Pending','In Progress','Resolved'],

datasets:[{

data:[
<%=request.getAttribute("pending")%>,
<%=request.getAttribute("progress")%>,
<%=request.getAttribute("resolved")%>
]

}]

}

});

const categoryChart = new Chart(document.getElementById('categoryChart'),{

type:'bar',

data:{

labels:['Road','Water','Electricity'],

datasets:[{

label:'Complaints',

data:[
<%=request.getAttribute("road")%>,
<%=request.getAttribute("water")%>,
<%=request.getAttribute("electricity")%>
]

}]

}

});

</script>

</body>
</html>
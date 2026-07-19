<%@ page language="java"
    contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Complaint Analytics</title>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>

*{
    box-sizing:border-box;
}

body{

    margin:0;

    font-family:Arial;

    background:#f4f6f9;

}

.header{

    background:#0d6efd;

    color:white;

    padding:20px;

    text-align:center;

}

.container{

    width:90%;

    margin:30px auto;

}

.summary{

    display:flex;

    justify-content:center;

    margin-bottom:30px;

}

.total-card{

    width:280px;

    background:white;

    padding:25px;

    text-align:center;

    border-radius:10px;

    box-shadow:0 0 10px lightgray;

}

.total-card h1{

    font-size:45px;

    color:#0d6efd;

    margin:10px;

}

.charts{

    display:flex;

    gap:30px;

    justify-content:center;

    flex-wrap:wrap;

}

.chart-box{

    width:500px;

    min-height:350px;

    background:white;

    padding:25px;

    border-radius:10px;

    box-shadow:0 0 10px lightgray;

}

.chart-box h3{

    text-align:center;

    color:#343a40;

}

.back{

    display:block;

    width:220px;

    margin:30px auto;

    padding:12px;

    text-align:center;

    background:#343a40;

    color:white;

    text-decoration:none;

    border-radius:5px;

}

.back:hover{

    background:#495057;

}

</style>

</head>

<body>

<div class="header">

<h2>📊 Complaint Analytics Dashboard</h2>

</div>

<div class="container">

<!-- Total Complaints -->

<div class="summary">

<div class="total-card">

<h3>Total Complaints</h3>

<h1><%=request.getAttribute("total")%></h1>

</div>

</div>

<!-- Charts -->

<div class="charts">

<!-- Status Chart -->

<div class="chart-box">

<h3>Complaint Status</h3>

<canvas id="statusChart"></canvas>

</div>

<!-- Category Chart -->

<div class="chart-box">

<h3>Complaints by Category</h3>

<canvas id="categoryChart"></canvas>

</div>

</div>

<a href="<%=request.getContextPath()%>/pages/adminDashboard.jsp">
    ⬅ Back to Dashboard
</a>

</div>

<script>

/* ==========================
   STATUS CHART
========================== */

const statusChart = new Chart(

    document.getElementById('statusChart'),

    {

        type:'pie',

        data:{

            labels:[

                'Pending',

                'In Progress',

                'Resolved'

            ],

            datasets:[{

                data:[

                    <%=request.getAttribute("pending")%>,

                    <%=request.getAttribute("progress")%>,

                    <%=request.getAttribute("resolved")%>

                ]

            }]

        },

        options:{

            responsive:true,

            plugins:{

                legend:{

                    position:'bottom'

                }

            }

        }

    }

);


/* ==========================
   CATEGORY CHART
========================== */

const categoryChart = new Chart(

    document.getElementById('categoryChart'),

    {

        type:'bar',

        data:{

        	labels:[

        	    'Road',
        	    'Water Supply',
        	    'Electricity',
        	    'Drainage',
        	    'Street Lights',
        	    'Garbage',
        	    'Other'

        	],

            datasets:[{

                label:'Complaints',

                data:[

                    <%=request.getAttribute("road")%>,

                    <%=request.getAttribute("water")%>,

                    <%=request.getAttribute("electricity")%>,

                    <%=request.getAttribute("drainage")%>,

                    <%=request.getAttribute("streetLights")%>,

                    <%=request.getAttribute("garbage")%>,

                    <%=request.getAttribute("other")%>

                ]

            }]

        },

        options:{

            responsive:true,

            scales:{

                y:{

                    beginAtZero:true,

                    ticks:{

                        stepSize:1

                    }

                }

            }

        }

    }

);

</script>

</body>

</html>
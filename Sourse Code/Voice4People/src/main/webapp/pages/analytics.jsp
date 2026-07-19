<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>

```
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Complaint Analytics | Voice4People</title>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>

    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        font-family: "Segoe UI", Arial, sans-serif;
        background: #f4f6f9;
        color: #212529;
    }

    /* Header */

    .header {
        background: linear-gradient(135deg, #0d6efd, #084298);
        color: white;
        padding: 25px 15px;
        text-align: center;
        box-shadow: 0 3px 10px rgba(0, 0, 0, 0.15);
    }

    .header h2 {
        margin: 0;
        font-size: 28px;
    }

    .header p {
        margin: 8px 0 0;
        opacity: 0.9;
        font-size: 14px;
    }

    /* Main Container */

    .container {
        width: 92%;
        max-width: 1200px;
        margin: 35px auto;
    }

    /* Summary Card */

    .summary {
        display: flex;
        justify-content: center;
        margin-bottom: 35px;
    }

    .total-card {
        width: 300px;
        background: white;
        padding: 25px;
        text-align: center;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
        border-top: 5px solid #0d6efd;
        transition: 0.3s;
    }

    .total-card:hover {
        transform: translateY(-5px);
    }

    .total-card h3 {
        margin: 0;
        color: #495057;
        font-size: 18px;
    }

    .total-card h1 {
        font-size: 48px;
        color: #0d6efd;
        margin: 12px 0 0;
    }

    /* Charts */

    .charts {
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        gap: 30px;
    }

    .chart-box {
        background: white;
        padding: 25px;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
        min-height: 390px;
    }

    .chart-box h3 {
        text-align: center;
        color: #343a40;
        margin-top: 0;
        margin-bottom: 20px;
        font-size: 20px;
    }

    .chart-container {
        position: relative;
        height: 300px;
    }

    /* Back Button */

    .back {
        display: block;
        width: 240px;
        margin: 35px auto 10px;
        padding: 13px;
        text-align: center;
        background: #343a40;
        color: white;
        text-decoration: none;
        border-radius: 6px;
        font-weight: 600;
        transition: 0.3s;
    }

    .back:hover {
        background: #212529;
        transform: translateY(-2px);
    }

    /* Responsive Design */

    @media (max-width: 768px) {

        .header h2 {
            font-size: 22px;
        }

        .charts {
            grid-template-columns: 1fr;
        }

        .total-card {
            width: 100%;
            max-width: 300px;
        }

        .chart-box {
            min-height: 350px;
        }

    }

</style>
```

</head>

<body>

```
<!-- Header -->

<div class="header">

    <h2>📊 Complaint Analytics Dashboard</h2>

    <p>Voice4People Complaint Management System</p>

</div>


<!-- Main Container -->

<div class="container">


    <!-- Total Complaints -->

    <div class="summary">

        <div class="total-card">

            <h3>Total Complaints</h3>

            <h1>
                <%= request.getAttribute("total") != null
                        ? request.getAttribute("total")
                        : 0 %>
            </h1>

        </div>

    </div>


    <!-- Charts -->

    <div class="charts">


        <!-- Status Chart -->

        <div class="chart-box">

            <h3>📌 Complaint Status</h3>

            <div class="chart-container">

                <canvas id="statusChart"></canvas>

            </div>

        </div>


        <!-- Category Chart -->

        <div class="chart-box">

            <h3>📂 Complaints by Category</h3>

            <div class="chart-container">

                <canvas id="categoryChart"></canvas>

            </div>

        </div>


    </div>


    <!-- Back Button -->

    <a class="back"
       href="<%= request.getContextPath() %>/pages/adminDashboard.jsp">

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

            type: 'doughnut',

            data: {

                labels: [

                    'Pending',

                    'In Progress',

                    'Resolved'

                ],

                datasets: [{

                    data: [

                        <%= request.getAttribute("pending") != null
                                ? request.getAttribute("pending")
                                : 0 %>,

                        <%= request.getAttribute("progress") != null
                                ? request.getAttribute("progress")
                                : 0 %>,

                        <%= request.getAttribute("resolved") != null
                                ? request.getAttribute("resolved")
                                : 0 %>

                    ],

                    borderWidth: 2

                }]

            },

            options: {

                responsive: true,

                maintainAspectRatio: false,

                plugins: {

                    legend: {

                        position: 'bottom'

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

            type: 'bar',

            data: {

                labels: [

                    'Road',

                    'Water Supply',

                    'Electricity',

                    'Drainage',

                    'Street Lights',

                    'Garbage',

                    'Other'

                ],

                datasets: [{

                    label: 'Complaints',

                    data: [

                        <%= request.getAttribute("road") != null
                                ? request.getAttribute("road")
                                : 0 %>,

                        <%= request.getAttribute("water") != null
                                ? request.getAttribute("water")
                                : 0 %>,

                        <%= request.getAttribute("electricity") != null
                                ? request.getAttribute("electricity")
                                : 0 %>,

                        <%= request.getAttribute("drainage") != null
                                ? request.getAttribute("drainage")
                                : 0 %>,

                        <%= request.getAttribute("streetLights") != null
                                ? request.getAttribute("streetLights")
                                : 0 %>,

                        <%= request.getAttribute("garbage") != null
                                ? request.getAttribute("garbage")
                                : 0 %>,

                        <%= request.getAttribute("other") != null
                                ? request.getAttribute("other")
                                : 0 %>

                    ],

                    borderWidth: 1

                }]

            },

            options: {

                responsive: true,

                maintainAspectRatio: false,

                plugins: {

                    legend: {

                        display: false

                    }

                },

                scales: {

                    y: {

                        beginAtZero: true,

                        ticks: {

                            stepSize: 1

                        }

                    }

                }

            }

        }

    );

</script>
```

</body>

</html>

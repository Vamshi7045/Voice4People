\# Voice4People 🏛️



Voice4People is a Java-based citizen complaint management web application that connects citizens with government authorities for reporting and tracking local issues.



The platform allows citizens to submit complaints related to public services and enables administrators to manage, track, and update complaint statuses efficiently.



\---



\## 🚀 Features



\### 👤 Citizen Module



\- Citizen Registration

\- Secure Login

\- Citizen Dashboard

\- Submit Public Complaints

\- Upload Complaint Images

\- View My Complaints

\- Track Complaint Status

\- Update Citizen Profile

\- Logout



\### 🛡️ Admin Module



\- Admin Login

\- Admin Dashboard

\- View All Complaints

\- Search Complaints by Title

\- Filter Complaints by Category

\- Filter Complaints by Status

\- Update Complaint Status

\- Complaint Status History

\- View Complaint Details

\- Complaint Reports

\- Complaint Analytics

\- Manage Users



\---



\## 🛠️ Technologies Used



| Technology | Usage |

|---|---|

| Java | Backend Development |

| Java Servlets | Request Handling |

| JSP | Dynamic Web Pages |

| HTML | Page Structure |

| CSS | User Interface Design |

| MySQL | Database |

| JDBC | Database Connectivity |

| Apache Tomcat | Web Server |

| Eclipse IDE | Development Environment |



\---



\## 🏗️ Project Architecture



The project follows a layered architecture:



```text

Voice4People

│

├── Controller

│   └── Servlets

│

├── DAO

│   └── Database Operations

│

├── Model

│   └── User and Complaint Models

│

├── DB

│   └── Database Connection

│

└── JSP

&#x20;   └── User Interface

\## 📊 Complaint Workflow



```text

Citizen

&#x20;  │

&#x20;  ▼

Submit Complaint

&#x20;  │

&#x20;  ▼

Complaint Stored in Database

&#x20;  │

&#x20;  ▼

Admin Reviews Complaint

&#x20;  │

&#x20;  ▼

Status Updated

&#x20;  │

&#x20;  ├── Pending

&#x20;  ├── In Progress

&#x20;  └── Resolved

&#x20;  │

&#x20;  ▼

Citizen Tracks Status





\### 2️⃣ Database



Paste this section \*\*after Complaint Workflow\*\*:



```markdown

\## 🗄️ Database



The application uses \*\*MySQL\*\* as the database.



\### Main Tables



\- `users`

\- `complaints`

\- `complaint\_status\_history`


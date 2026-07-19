package com.voice4people.controller;

import java.io.IOException;

import com.voice4people.dao.ComplaintDAO;
import com.voice4people.model.Complaint;
import com.voice4people.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ComplaintServlet")
public class ComplaintServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;

        protected void doPost(
                        HttpServletRequest request,
                        HttpServletResponse response)
                        throws ServletException, IOException {

                HttpSession session = request.getSession(false);

                // Check login
                if (session == null || session.getAttribute("user") == null) {

                        response.sendRedirect("pages/login.jsp");
                        return;
                }

                // Get logged-in user from session
                User user = (User) session.getAttribute("user");

                int userId = user.getId();

                String title = request.getParameter("title");
                String category = request.getParameter("category");
                String description = request.getParameter("description");
                String district = request.getParameter("district");
                String mandal = request.getParameter("mandal");
                String village = request.getParameter("village");
                String address = request.getParameter("address");

                Complaint complaint = new Complaint();

                complaint.setUserId(userId);
                complaint.setTitle(title);
                complaint.setCategory(category);
                complaint.setDescription(description);
                complaint.setDistrict(district);
                complaint.setMandal(mandal);
                complaint.setVillage(village);
                complaint.setAddress(address);

                ComplaintDAO dao = new ComplaintDAO();

                if (dao.addComplaint(complaint)) {

                        response.sendRedirect(
                                        "pages/citizenDashboard.jsp");

                } else {

                        response.getWriter().println(
                                        "<h2>Complaint Submission Failed!</h2>");
                }
        }
}
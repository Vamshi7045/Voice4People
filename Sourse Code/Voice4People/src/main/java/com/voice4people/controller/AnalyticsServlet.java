package com.voice4people.controller;

import java.io.IOException;

import com.voice4people.dao.ComplaintDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AnalyticsServlet")
public class AnalyticsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ComplaintDAO dao = new ComplaintDAO();

        // ==========================
        // Status Analytics
        // ==========================

        request.setAttribute(
                "total",
                dao.getTotalComplaints()
        );

        request.setAttribute(
                "pending",
                dao.getPendingComplaints()
        );

        request.setAttribute(
                "progress",
                dao.getInProgressComplaints()
        );

        request.setAttribute(
                "resolved",
                dao.getResolvedComplaints()
        );

        // ==========================
        // Category Analytics
        // ==========================

        request.setAttribute(
                "road",
                dao.getCategoryComplaints("Road")
        );

        request.setAttribute(
                "water",
                dao.getCategoryComplaints("Water Supply")
        );

        request.setAttribute(
                "electricity",
                dao.getCategoryComplaints("Electricity")
        );

        request.setAttribute(
                "drainage",
                dao.getCategoryComplaints("Drainage")
        );

        request.setAttribute(
                "streetLights",
                dao.getCategoryComplaints("Street Lights")
        );

        request.setAttribute(
                "garbage",
                dao.getCategoryComplaints("Garbage")
        );

        request.setAttribute(
                "other",
                dao.getCategoryComplaints("Other")
        );

        // ==========================
        // Open Analytics Page
        // ==========================

        request.getRequestDispatcher(
                "pages/analytics.jsp"
        ).forward(request, response);
    }
}
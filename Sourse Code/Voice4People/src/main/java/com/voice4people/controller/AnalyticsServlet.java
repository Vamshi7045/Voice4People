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

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ComplaintDAO dao = new ComplaintDAO();

        // ==========================
        // Status Analytics
        // ==========================

        int total = dao.getTotalComplaints();
        int pending = dao.getPendingComplaints();
        int progress = dao.getInProgressComplaints();
        int resolved = dao.getResolvedComplaints();

        request.setAttribute("total", total);
        request.setAttribute("pending", pending);
        request.setAttribute("progress", progress);
        request.setAttribute("resolved", resolved);

        // ==========================
        // Category Analytics
        // ==========================

        int road = dao.getRoadComplaints();
        int water = dao.getWaterComplaints();
        int electricity = dao.getElectricityComplaints();

        request.setAttribute("road", road);
        request.setAttribute("water", water);
        request.setAttribute("electricity", electricity);

        // ==========================
        // Open Analytics Page
        // ==========================

        request.getRequestDispatcher("pages/analytics.jsp")
               .forward(request, response);
    }
}
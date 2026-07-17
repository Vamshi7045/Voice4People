package com.voice4people.controller;

import java.io.IOException;

import com.voice4people.dao.ComplaintDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReportsServlet")
public class ReportsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ComplaintDAO dao = new ComplaintDAO();

        int total = dao.getTotalComplaints();
        int pending = dao.getPendingComplaints();
        int progress = dao.getInProgressComplaints();
        int resolved = dao.getResolvedComplaints();

        request.setAttribute("total", total);
        request.setAttribute("pending", pending);
        request.setAttribute("progress", progress);
        request.setAttribute("resolved", resolved);

        request.getRequestDispatcher("pages/reports.jsp")
               .forward(request, response);
    }
}
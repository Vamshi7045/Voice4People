package com.voice4people.controller;

import java.io.IOException;
import java.util.List;

import com.voice4people.dao.ComplaintDAO;
import com.voice4people.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchComplaintServlet")
public class SearchComplaintServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String status = request.getParameter("status");

        ComplaintDAO dao = new ComplaintDAO();

        List<Complaint> complaints = dao.searchComplaints(title, category, status);

        request.setAttribute("complaints", complaints);

        request.getRequestDispatcher("pages/viewComplaints.jsp")
               .forward(request, response);
    }
}
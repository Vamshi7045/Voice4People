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

@WebServlet("/ComplaintDetailsServlet")
public class ComplaintDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");

        if (idParameter == null || idParameter.isEmpty()) {

            response.sendRedirect("ViewComplaintsServlet");
            return;
        }

        int id = Integer.parseInt(idParameter);

        ComplaintDAO dao = new ComplaintDAO();

        Complaint complaint = dao.getComplaintById(id);

        if (complaint == null) {

            response.getWriter().println(
                    "<h2>Complaint Not Found</h2>");

            return;
        }

        List<String> history =
                dao.getStatusHistoryByComplaintId(id);

        request.setAttribute("complaint", complaint);

        request.setAttribute("history", history);

        request.getRequestDispatcher(
                "pages/complaintDetails.jsp")
               .forward(request, response);
    }
}
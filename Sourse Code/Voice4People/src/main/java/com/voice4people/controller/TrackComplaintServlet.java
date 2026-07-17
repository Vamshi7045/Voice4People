package com.voice4people.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.voice4people.dao.ComplaintDAO;
import com.voice4people.model.Complaint;
import com.voice4people.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/TrackComplaintServlet")
public class TrackComplaintServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
                session.getAttribute("user") == null) {

            response.sendRedirect("pages/login.jsp");

            return;
        }

        User user =
                (User) session.getAttribute("user");

        ComplaintDAO dao = new ComplaintDAO();

        List<Complaint> complaints =
                dao.getComplaintsByUserId(user.getId());

        Map<Integer, List<String>> statusHistory =
                new HashMap<>();

        for (Complaint complaint : complaints) {

            List<String> history =
                    dao.getStatusHistoryByComplaintId(
                            complaint.getId());

            statusHistory.put(
                    complaint.getId(),
                    history);
        }

        request.setAttribute("complaints", complaints);

        request.setAttribute(
                "statusHistory",
                statusHistory);

        request.getRequestDispatcher(
                "pages/trackComplaint.jsp")
               .forward(request, response);
    }
}
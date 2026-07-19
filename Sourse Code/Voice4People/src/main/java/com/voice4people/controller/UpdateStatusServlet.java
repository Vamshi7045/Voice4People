package com.voice4people.controller;

import java.io.IOException;

import com.voice4people.dao.ComplaintDAO;
import com.voice4people.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        String newStatus =
                request.getParameter("status");

        String priority =
                request.getParameter("priority");

        ComplaintDAO dao =
                new ComplaintDAO();

        // ==================================
        // Get Existing Complaint
        // ==================================

        Complaint complaint =
                dao.getComplaintById(id);

        if (complaint == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/ViewComplaintsServlet");

            return;
        }

        String oldStatus =
                complaint.getStatus();

        // ==================================
        // Update Status
        // ==================================

        boolean statusUpdated =
                dao.updateComplaintStatus(id, newStatus);

        // ==================================
        // Update Priority
        // ==================================

        boolean priorityUpdated =
                dao.updateComplaintPriority(id, priority);

        // ==================================
        // Save History Only If Status Changed
        // ==================================

        if (statusUpdated &&
                !newStatus.equalsIgnoreCase(oldStatus)) {

            boolean historySaved =
                    dao.addStatusHistory(id, newStatus);

            System.out.println(
                    "Status Changed: "
                    + oldStatus
                    + " → "
                    + newStatus);

            System.out.println(
                    "History Saved: "
                    + historySaved);
        }

        System.out.println(
                "Status Updated: "
                + statusUpdated);

        System.out.println(
                "Priority Updated: "
                + priorityUpdated);

        // ==================================
        // Redirect
        // ==================================

        response.sendRedirect(
                request.getContextPath()
                + "/ViewComplaintsServlet");
    }
}
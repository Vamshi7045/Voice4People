package com.voice4people.controller;

import java.io.IOException;

import com.voice4people.dao.ComplaintDAO;

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

        String status =
                request.getParameter("status");

        String priority =
                request.getParameter("priority");

        ComplaintDAO dao =
                new ComplaintDAO();

        // ============================
        // Update Status
        // ============================

        boolean updated =
                dao.updateComplaintStatus(id, status);

        // ============================
        // Update Priority
        // ============================

        boolean priorityUpdated =
                dao.updateComplaintPriority(id, priority);

        // ============================
        // Save Status History
        // ============================

        if (updated) {

            boolean historySaved =
                    dao.addStatusHistory(id, status);

            System.out.println(
                    "Status Updated: " + updated);

            System.out.println(
                    "Priority Updated: "
                    + priorityUpdated);

            System.out.println(
                    "History Saved: "
                    + historySaved);

        } else {

            System.out.println(
                    "Status Update Failed");

        }

        response.sendRedirect(
                request.getContextPath()
                + "/ViewComplaintsServlet");
    }
}
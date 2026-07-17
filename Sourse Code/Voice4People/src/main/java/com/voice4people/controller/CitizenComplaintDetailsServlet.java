package com.voice4people.controller;

import java.io.IOException;

import com.voice4people.dao.ComplaintDAO;
import com.voice4people.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CitizenComplaintDetailsServlet")
public class CitizenComplaintDetailsServlet extends HttpServlet {

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

        String idParameter = request.getParameter("id");

        if (idParameter == null ||
                idParameter.isEmpty()) {

            response.sendRedirect("MyComplaintsServlet");

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

        request.setAttribute("complaint", complaint);

        request.getRequestDispatcher(
                "pages/citizenComplaintDetails.jsp")
               .forward(request, response);
    }
}
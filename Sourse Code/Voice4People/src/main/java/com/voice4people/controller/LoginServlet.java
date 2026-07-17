package com.voice4people.controller;

import java.io.IOException;

import com.voice4people.dao.UserDAO;
import com.voice4people.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();

        User user = dao.loginUser(email, password);

        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if (user.getRole().equalsIgnoreCase("Citizen")) {

                response.sendRedirect("pages/citizenDashboard.jsp");

            } else if (user.getRole().equalsIgnoreCase("Officer")) {

                response.sendRedirect("pages/officerDashboard.jsp");

            } else {

                response.sendRedirect("pages/adminDashboard.jsp");

            }

        } else {

            response.getWriter().println("<h2>Invalid Email or Password</h2>");

        }

    }

}
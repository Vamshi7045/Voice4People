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

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();

        User user = dao.loginUser(email, password);

        if (user != null
                && user.getRole() != null
                && user.getRole().equalsIgnoreCase("admin")) {

            HttpSession session = request.getSession();

            session.setAttribute("admin", user);

            response.sendRedirect(
                    request.getContextPath()
                    + "/pages/adminDashboard.jsp"
            );

        } else {

            response.sendRedirect(
                    request.getContextPath()
                    + "/pages/adminLogin.jsp?error=invalid"
            );
        }
    }
}
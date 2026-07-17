package com.voice4people.controller;

import java.io.IOException;

import com.voice4people.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null ||
                session.getAttribute("user") == null){

            response.sendRedirect(
                    request.getContextPath()
                    + "/pages/login.jsp");

            return;
        }

        User user =
                (User) session.getAttribute("user");

        request.setAttribute("user", user);

        // Forward message to profile page
        String message =
                request.getParameter("message");

        if(message != null){

            request.setAttribute(
                    "message", message);
        }

        request.getRequestDispatcher(
                "pages/profile.jsp")
               .forward(request, response);
    }
}
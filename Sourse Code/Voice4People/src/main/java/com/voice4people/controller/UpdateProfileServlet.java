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

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        String fullName =
                request.getParameter("fullName");

        String phone =
                request.getParameter("phone");

        User user = new User();

        user.setId(id);
        user.setFullName(fullName);
        user.setPhone(phone);

        UserDAO dao = new UserDAO();

        if(dao.updateProfile(user)) {

            HttpSession session =
                    request.getSession();

            User sessionUser =
                    (User) session.getAttribute("user");

            sessionUser.setFullName(fullName);
            sessionUser.setPhone(phone);

            session.setAttribute(
                    "user", sessionUser);

            response.sendRedirect(
                    request.getContextPath()
                    + "/ProfileServlet?message=success");

        } else {

            response.getWriter().println(
                    "<h2>Profile Update Failed</h2>");
        }
    }
}
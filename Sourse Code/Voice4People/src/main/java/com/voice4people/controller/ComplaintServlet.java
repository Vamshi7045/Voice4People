package com.voice4people.controller;

import java.io.File;
import java.io.IOException;

import com.voice4people.dao.ComplaintDAO;
import com.voice4people.model.Complaint;
import com.voice4people.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/ComplaintServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class ComplaintServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // ============================
            // Get Logged-in User
            // ============================

            HttpSession session = request.getSession(false);

            if (session == null ||
                    session.getAttribute("user") == null) {

                response.sendRedirect("pages/login.jsp");
                return;
            }

            User user = (User) session.getAttribute("user");

            int userId = user.getId();

            // ============================
            // Read Form Data
            // ============================

            String title = request.getParameter("title");
            String category = request.getParameter("category");
            String description = request.getParameter("description");
            String district = request.getParameter("district");
            String mandal = request.getParameter("mandal");
            String village = request.getParameter("village");
            String address = request.getParameter("address");

            // ============================
            // Debug Logs
            // ============================

            System.out.println("========== COMPLAINT DATA ==========");
            System.out.println("User ID: " + userId);
            System.out.println("Title: " + title);
            System.out.println("Category: " + category);
            System.out.println("Description: " + description);
            System.out.println("District: " + district);
            System.out.println("Mandal: " + mandal);
            System.out.println("Village: " + village);
            System.out.println("Address: " + address);
            System.out.println("====================================");

            // ============================
            // Validate Required Fields
            // ============================

            if (title == null || title.trim().isEmpty()) {

                response.getWriter().println(
                        "<h2>Complaint Title is Missing!</h2>");

                return;
            }

            if (description == null ||
                    description.trim().isEmpty()) {

                response.getWriter().println(
                        "<h2>Description is Missing!</h2>");

                return;
            }

            // ============================
            // Image Upload
            // ============================

            Part imagePart = request.getPart("image");

            String fileName = "";

            if (imagePart != null &&
                    imagePart.getSize() > 0) {

                String originalFileName =
                        imagePart.getSubmittedFileName();

                fileName = System.currentTimeMillis()
                        + "_" + originalFileName;

                String uploadPath =
                        getServletContext().getRealPath("/")
                        + File.separator
                        + "uploads";

                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                File imageFile =
                        new File(uploadDir, fileName);

                imagePart.write(
                        imageFile.getAbsolutePath());

                System.out.println(
                        "IMAGE UPLOAD SUCCESS: "
                                + fileName);
            }

            // ============================
            // Create Complaint
            // ============================

            Complaint complaint = new Complaint();

            complaint.setUserId(userId);
            complaint.setTitle(title);
            complaint.setCategory(category);
            complaint.setDescription(description);
            complaint.setDistrict(district);
            complaint.setMandal(mandal);
            complaint.setVillage(village);
            complaint.setAddress(address);

            ComplaintDAO dao = new ComplaintDAO();

            // ============================
            // Save Complaint
            // ============================

            if (dao.addComplaint(complaint)) {

                response.sendRedirect(
                        "pages/citizenDashboard.jsp");

            } else {

                response.getWriter().println(
                        "<h2>Complaint Submission Failed!</h2>");
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "<h2>Complaint Error: "
                            + e.getMessage()
                            + "</h2>");
        }
    }
}
package com.voice4people.controller;

import java.io.File;
import java.io.IOException;

import com.voice4people.dao.ComplaintDAO;
import com.voice4people.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

        int userId = Integer.parseInt(request.getParameter("userId"));

        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        String district = request.getParameter("district");
        String mandal = request.getParameter("mandal");
        String village = request.getParameter("village");
        String address = request.getParameter("address");

        Part imagePart = request.getPart("image");

        String fileName = "";

        if (imagePart != null && imagePart.getSize() > 0) {

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

            imagePart.write(imageFile.getAbsolutePath());

            System.out.println("=================================");
            System.out.println("IMAGE UPLOAD SUCCESS");
            System.out.println("UPLOAD PATH: "
                    + imageFile.getAbsolutePath());
            System.out.println("FILE NAME: "
                    + fileName);
            System.out.println("=================================");
        }

        Complaint complaint = new Complaint();

        complaint.setUserId(userId);
        complaint.setTitle(title);
        complaint.setCategory(category);
        complaint.setDescription(description);
        complaint.setDistrict(district);
        complaint.setMandal(mandal);
        complaint.setVillage(village);
        complaint.setAddress(address);
        complaint.setImage(fileName);

        ComplaintDAO dao = new ComplaintDAO();

        if (dao.addComplaint(complaint)) {

            response.sendRedirect(
                    "pages/citizenDashboard.jsp");

        } else {

            response.getWriter().println(
                    "<h2>Complaint Submission Failed!</h2>");
        }
    }
}
package com.voice4people.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.voice4people.db.DBConnection;
import com.voice4people.model.Complaint;

public class ComplaintDAO {

    // ============================
    // Update Complaint Status
    // ============================
    public boolean updateComplaintStatus(int id, String status) {

        boolean result = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE complaints SET status=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                result = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // ============================
    // Add Complaint
    // ============================
    public boolean addComplaint(Complaint complaint) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO complaints "
                    + "(user_id,title,category,description,district,mandal,village,address,status) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, complaint.getUserId());
            ps.setString(2, complaint.getTitle());
            ps.setString(3, complaint.getCategory());
            ps.setString(4, complaint.getDescription());
            ps.setString(5, complaint.getDistrict());
            ps.setString(6, complaint.getMandal());
            ps.setString(7, complaint.getVillage());
            ps.setString(8, complaint.getAddress());
            ps.setString(9, "Pending");

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ============================
    // Get All Complaints
    // ============================
    public List<Complaint> getAllComplaints() {

        List<Complaint> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM complaints ORDER BY created_at DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Complaint c = new Complaint();

                c.setId(rs.getInt("id"));
                c.setUserId(rs.getInt("user_id"));
                c.setTitle(rs.getString("title"));
                c.setCategory(rs.getString("category"));
                c.setDescription(rs.getString("description"));
                c.setDistrict(rs.getString("district"));
                c.setMandal(rs.getString("mandal"));
                c.setVillage(rs.getString("village"));
                c.setAddress(rs.getString("address"));
                c.setStatus(rs.getString("status"));
                c.setPriority(rs.getString("priority"));

                list.add(c);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ============================
    // Get Complaints By User
    // ============================
    public List<Complaint> getComplaintsByUser(int userId) {

        List<Complaint> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM complaints WHERE user_id=? ORDER BY id DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Complaint complaint = new Complaint();

                complaint.setId(rs.getInt("id"));
                complaint.setUserId(rs.getInt("user_id"));
                complaint.setTitle(rs.getString("title"));
                complaint.setCategory(rs.getString("category"));
                complaint.setDescription(rs.getString("description"));
                complaint.setDistrict(rs.getString("district"));
                complaint.setMandal(rs.getString("mandal"));
                complaint.setVillage(rs.getString("village"));
                complaint.setAddress(rs.getString("address"));
                complaint.setStatus(rs.getString("status"));
                complaint.setPriority(rs.getString("priority"));

                list.add(complaint);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ============================
    // Total Complaints
    // ============================
    public int getTotalComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // Pending Complaints
    // ============================
    public int getPendingComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints WHERE status='Pending'";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // In Progress Complaints
    // ============================
    public int getInProgressComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints WHERE status='In Progress'";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // Resolved Complaints
    // ============================
    public int getResolvedComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints WHERE status='Resolved'";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // User Total Complaints
    // ============================
    public int getUserTotalComplaints(int userId) {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // User Pending Complaints
    // ============================
    public int getUserPendingComplaints(int userId) {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints "
                    + "WHERE user_id=? AND status='Pending'";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // User In Progress Complaints
    // ============================
    public int getUserInProgressComplaints(int userId) {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints "
                    + "WHERE user_id=? AND status='In Progress'";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // User Resolved Complaints
    // ============================
    public int getUserResolvedComplaints(int userId) {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints "
                    + "WHERE user_id=? AND status='Resolved'";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // Search Complaints
    // ============================
    public List<Complaint> searchComplaints(
            String title,
            String category,
            String status) {

        List<Complaint> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM complaints WHERE 1=1";

            if (title != null && !title.trim().isEmpty()) {
                sql += " AND title LIKE ?";
            }

            if (category != null && !category.equals("All")) {
                sql += " AND category=?";
            }

            if (status != null && !status.equals("All")) {
                sql += " AND status=?";
            }

            sql += " ORDER BY id DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            int index = 1;

            if (title != null && !title.trim().isEmpty()) {
                ps.setString(index++, "%" + title + "%");
            }

            if (category != null && !category.equals("All")) {
                ps.setString(index++, category);
            }

            if (status != null && !status.equals("All")) {
                ps.setString(index++, status);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Complaint c = new Complaint();

                c.setId(rs.getInt("id"));
                c.setUserId(rs.getInt("user_id"));
                c.setTitle(rs.getString("title"));
                c.setCategory(rs.getString("category"));
                c.setDescription(rs.getString("description"));
                c.setDistrict(rs.getString("district"));
                c.setMandal(rs.getString("mandal"));
                c.setVillage(rs.getString("village"));
                c.setAddress(rs.getString("address"));
                c.setStatus(rs.getString("status"));
                c.setPriority(rs.getString("priority"));

                list.add(c);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ============================
    // Road Complaints
    // ============================
    public int getRoadComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints WHERE category='Road'";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // Water Complaints
    // ============================
    public int getWaterComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints "
                    + "WHERE category='Water Supply'";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // Electricity Complaints
    // ============================
    public int getElectricityComplaints() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT COUNT(*) FROM complaints "
                    + "WHERE category='Electricity'";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ============================
    // Get Complaints By User ID
    // ============================
    public List<Complaint> getComplaintsByUserId(int userId) {

        List<Complaint> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM complaints "
                    + "WHERE user_id=? ORDER BY id DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Complaint complaint = new Complaint();

                complaint.setId(rs.getInt("id"));
                complaint.setUserId(rs.getInt("user_id"));
                complaint.setTitle(rs.getString("title"));
                complaint.setCategory(rs.getString("category"));
                complaint.setDescription(rs.getString("description"));
                complaint.setDistrict(rs.getString("district"));
                complaint.setMandal(rs.getString("mandal"));
                complaint.setVillage(rs.getString("village"));
                complaint.setAddress(rs.getString("address"));
                complaint.setStatus(rs.getString("status"));
                complaint.setPriority(rs.getString("priority"));

                list.add(complaint);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ============================
    // Get Complaint By ID
    // ============================
    public Complaint getComplaintById(int id) {

        Complaint complaint = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM complaints WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                complaint = new Complaint();

                complaint.setId(rs.getInt("id"));
                complaint.setUserId(rs.getInt("user_id"));
                complaint.setTitle(rs.getString("title"));
                complaint.setCategory(rs.getString("category"));
                complaint.setDescription(rs.getString("description"));
                complaint.setDistrict(rs.getString("district"));
                complaint.setMandal(rs.getString("mandal"));
                complaint.setVillage(rs.getString("village"));
                complaint.setAddress(rs.getString("address"));
                complaint.setStatus(rs.getString("status"));
                complaint.setPriority(rs.getString("priority"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return complaint;
    }

    // ============================
    // Add Complaint Status History
    // ============================
    public boolean addStatusHistory(int complaintId, String status) {

        boolean result = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO complaint_status_history "
                    + "(complaint_id, status) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, complaintId);
            ps.setString(2, status);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                result = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // ============================
    // Get Status History
    // ============================
    public List<String> getStatusHistoryByComplaintId(int complaintId) {

        List<String> history = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT status FROM complaint_status_history "
                    + "WHERE complaint_id=? ORDER BY updated_at ASC";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, complaintId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                history.add(rs.getString("status"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return history;
    }

    // ============================
    // Update Complaint Priority
    // ============================
    public boolean updateComplaintPriority(int id, String priority) {

        boolean result = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE complaints SET priority=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, priority);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                result = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
package edu.sdccd.cisc191.repository;

import edu.sdccd.cisc191.model.Student;
import edu.sdccd.cisc191.util.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStudentRepository implements StudentRepository {

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO students (id, name, gpa) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setDouble(3, student.getGpa());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error saving student");
        }
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("gpa")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error finding student");
        }

        return null;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("gpa")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving students");
        }

        return students;
    }

    @Override
    public void updateGpa(int id, double newGpa) {
        String sql = "UPDATE students SET gpa = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, newGpa);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error updating GPA");
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error deleting student");
        }
    }
}
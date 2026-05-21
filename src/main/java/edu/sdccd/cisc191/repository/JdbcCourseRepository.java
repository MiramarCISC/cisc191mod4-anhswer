package edu.sdccd.cisc191.repository;

import edu.sdccd.cisc191.model.Course;
import edu.sdccd.cisc191.util.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcCourseRepository implements CourseRepository {

    @Override
    public void save(Course course) {
        String sql = "INSERT INTO courses (id, title, student_id) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, course.getId());
            stmt.setString(2, course.getTitle());
            stmt.setInt(3, course.getStudentId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to save course: " + course.getId(), e);
        }
    }

    @Override
    public List<Course> findByStudentId(int studentId) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses WHERE student_id = ? ORDER BY id";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    courses.add(new Course(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getInt("student_id")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to find courses for studentId: " + studentId, e);
        }

        return courses;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses ORDER BY id";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("student_id")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve all courses", e);
        }

        return courses;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM courses WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete course with id: " + id, e);
        }
    }
}
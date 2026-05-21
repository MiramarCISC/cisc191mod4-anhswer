package edu.sdccd.cisc191.repository;

import edu.sdccd.cisc191.model.Student;
<<<<<<< HEAD

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
=======
import edu.sdccd.cisc191.util.DatabaseConfig;

import java.sql.*;
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
import java.util.ArrayList;
import java.util.List;

public class JdbcStudentRepository implements StudentRepository {
    private final Connection conn;
    public JdbcStudentRepository(Connection conn){
        this.conn = conn;
    }
    @Override
    public void save(Student student) {
<<<<<<< HEAD
        String sql = "Insert into students(id, name, gpa ) VALUES (?,?,?)";
        // TODO use PreparedStatement INSERT
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setDouble(3, student.getGpa());
            ps.executeUpdate();
        } catch(Exception e) {
            throw new RuntimeException("failed to save", e);
        }

=======
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
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
<<<<<<< HEAD
        try(PreparedStatement pstate = conn.prepareStatement(sql)) {
            pstate.setInt(1, id);
            try(ResultSet rs = pstate.executeQuery()) {
                if(rs.next()) {
=======

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("gpa")
                    );
                }
            }
<<<<<<< HEAD
        } catch(Exception e) {
            throw new RuntimeException("Cant find student " + id, e);
        }
        // TODO use PreparedStatement SELECT by id
=======

        } catch (SQLException e) {
            System.out.println("Error finding student");
        }

>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        return null;
    }

    @Override
    public List<Student> findAll() {
<<<<<<< HEAD
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();
        try(PreparedStatement pstate = conn.prepareStatement(sql);
            ResultSet rs = pstate.executeQuery()) {
            while(rs.next()) {
=======
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("gpa")
                ));
            }

<<<<<<< HEAD
        } catch(Exception e) {
            throw new RuntimeException("Cannot find all", e);
        }
        // TODO query all rows and map to List<Student>
=======
        } catch (SQLException e) {
            System.out.println("Error retrieving students");
        }

>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
        return students;
    }

    @Override
<<<<<<< HEAD
    public void updateGpa(int id, double gpa) {
        String sql = "UPDATE students SET gpa = ? WHERE id = ?";
        try(PreparedStatement pstate = conn.prepareStatement(sql)) {
            pstate.setDouble(1, gpa);
            pstate.setInt(2, id);
            pstate.executeUpdate();
        } catch(Exception e) {
            throw new RuntimeException("cannot update", e);
        }
        // TODO use PreparedStatement UPDATE
=======
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
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
    }
    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
<<<<<<< HEAD
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(Exception e){
            throw new RuntimeException("Cannot delete", e);
        }
        // TODO use PreparedStatement DELETE
=======

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error deleting student");
        }
>>>>>>> 9105828dd9b915bbcff480e9b6d64c098fe7392a
    }
}